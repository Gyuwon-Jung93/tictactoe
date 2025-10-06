import json
from flask import Flask,request,Response,render_template,current_app
from rdflib import Graph, URIRef
from rdfstore import RDFStore
from pylode import OntPub
import uuid
import io
import os
from rdflib.tools.rdf2dot import rdf2dot
from flask import Response
from constants import HOST, PORT, BASE_URL, GAME_ONTOLOGY, GAME_ONTOLOGY_TAG, GAME_ONTOLOGY_PREFIX
from responsewriter import ResponseWriter

GAMES = {}
FREE_PLAYERS = []

### Start the server ###
# Convoluted set up is to enable app testing
def create_app():
    app = Flask(__name__)
    config_type = os.getenv('CONFIG_TYPE', default='config.DevelopmentConfig')
    app.config.from_object(config_type)
    return app

app = create_app()

### Routes ###
# /
#   Link to:        /players
#   Form to:        /register
#
# If registered
#   Links and forms to active game (see function add_links_for_active_game) 
@app.route('/')
def home():
    rw = ResponseWriter(BASE_URL,GAME_ONTOLOGY_PREFIX + ":Game")

    id = request.args.get('id')
    if id:
        id = uuid.UUID(id)
        if id in GAMES:
            game_rdf_store = GAMES[id] 
            add_links_for_active_game(game_rdf_store, rw, id)
    else:
        rw.add_link(BASE_URL + "players",method_name="GET") 
        rw.add_form(BASE_URL + "register",method_name="POST",contentType="application/json",op="writeproperty")
        rw.add_form_property(BASE_URL + "register","@id",False,True)

    return format_response(rw)


# /tic-tac-toe
# HOSTING THE ONTOLOGY
# Generated using https://github.com/RDFLib/pyLODE
# initialise
od = OntPub(ontology=GAME_ONTOLOGY)

# produce HTML
html = od.make_html()

# Route returns html, unlike other routes, which return JSON
@app.route("/" + GAME_ONTOLOGY_TAG, methods=["GET"])
def info():
    return html


# /register HTTP method POST
# This is a form
#   FORM: https://w3c.github.io/wot-thing-description/#form
#   "A form can be viewed as a statement of "To perform an operation ]
#   type operation on form context, make a request method request to 
#   submission target" where the optional form fields may further
#   describe the required request. In Thing Descriptions, the form 
#   context is the surrounding Object, such as Properties, Actions, 
#   and Events or the Thing itself for meta-interactions."
#
#   Agents must register to be added to the free players (FREE_PLAYERS) list, and
#   to register to play a game with an opponent
#   Example data:
#   Body: 
#   {
#       "@id": "http://agentURL.com",
#       "@type": "ttt:Agent",
#       "@context": {
#           "ttt": "http://localhost:8083/tic-tac-toe#"
#       }
#   }
#
#   Links to:     /
#                 /players
#   Forms:        /registerGame
@app.route("/register", methods=["POST"])
def register():  
    rw = ResponseWriter(BASE_URL + "register",GAME_ONTOLOGY_PREFIX+":Game")
    print(request.get_json())
    agent_url = request.get_json()['@id']

    if (agent_url in FREE_PLAYERS):
        rw.add_error("Already registered")
    else:
    # Add to list of available players
        FREE_PLAYERS.append(agent_url)
        rw.add_field(GAME_ONTOLOGY_PREFIX+":Agent", agent_url)
    
    rw.add_link(BASE_URL,method_name="GET") 
    rw.add_link(BASE_URL + "players",method_name="GET") 
 
    rw.add_form(BASE_URL + "registerGame",method_name="POST",contentType="application/json",op="writeproperty")
    rw.add_form_property(BASE_URL + "registerGame",GAME_ONTOLOGY_PREFIX+":XPlayerRole",False,True)
    rw.add_form_property(BASE_URL + "registerGame",GAME_ONTOLOGY_PREFIX+":OPlayerRole",False,True)
    return format_response(rw)


# /registerGame HTTP method POST
# This is a form
#   FORM: https://w3c.github.io/wot-thing-description/#form
#   "A form can be viewed as a statement of "To perform an operation ]
#   type operation on form context, make a request method request to 
#   submission target" where the optional form fields may further
#   describe the required request. In Thing Descriptions, the form 
#   context is the surrounding Object, such as Properties, Actions, 
#   and Events or the Thing itself for meta-interactions."
#
#   Agents must submit one form to start a game and get the game ID
#   It is up to the agents to work out who is going to be X player, 
#   and who will be O player. X always goes first.
#   Example data:
#   {
#       "@id": "http://agent-url.ie/agent_zero/",   
#       "@type": "ttt:Agent",
#       "@context": {
#           "ttt": "http://localhost:8083/tic-tac-toe#"
#       },
#       "ttt:XPlayerRole": "http://agent-url.ie/agent_zero/",
#       "ttt:OPlayerRole": "http://agent-url.ie/agent_one/"
#   }
#
#   Links to:     /

#   Links and forms to active game (see function add_links_for_active_game) 
@app.route("/registerGame", methods=["POST"])
def play():
    rw = ResponseWriter(BASE_URL + "registerGame",GAME_ONTOLOGY_PREFIX+":Game")
    # Assign an ID for the game
    id = uuid.uuid4()

    # Get the opponent name from the request body
    body = request.get_json()
    primary_agent = body['ttt:XPlayerRole']
    second_agent = body['ttt:OPlayerRole']
    if not (primary_agent in FREE_PLAYERS):
        rw.add_error("X Player Agent is not registered")
        rw.add_link(BASE_URL + "/",method_name="GET") 
        rw.add_link(BASE_URL + "/players",method_name="GET") 
        rw.add_form(BASE_URL + "register",method_name="POST",contentType="application/json",op="writeproperty")
        rw.add_form_property(BASE_URL + "register","@id",False,True)

    elif not (second_agent in FREE_PLAYERS):
        rw.add_error("O Player Agent is not registered")
        rw.add_link(BASE_URL + "/",method_name="GET") 
        rw.add_link(BASE_URL + "/players",method_name="GET") 
        rw.add_form(BASE_URL + "register",method_name="POST",contentType="application/json",op="writeproperty")
        rw.add_form_property(BASE_URL + "register","@id",False,True)

    else:
        # Remove players from FREE_PLAYERS
        FREE_PLAYERS.remove(primary_agent)
        FREE_PLAYERS.remove(second_agent)
        # Create a new RDF graph for the game using the tic-tac-toe ontology
        g = Graph()
        g.parse(GAME_ONTOLOGY)

        game_rdf_store = RDFStore(g, GAME_ONTOLOGY_TAG, BASE_URL, URIRef(primary_agent), URIRef(second_agent), id)
        
        # Store the game game_rdf_store (access to RDF graph) and the opponent instance against the game ID
        GAMES[id] = game_rdf_store
        
        # Write the response
        rw.add_field(GAME_ONTOLOGY_PREFIX+":hasID", str(id));
        rw.add_field(GAME_ONTOLOGY_PREFIX+":XPlayerRole",URIRef(primary_agent));
        rw.add_field(GAME_ONTOLOGY_PREFIX+":OPlayerRole",URIRef(second_agent));
        rw.add_link(BASE_URL,method_name="GET")
        add_links_for_active_game(game_rdf_store, rw, id)

    return format_response(rw)

# /players
# Parameter: none
# Contains information about the players, e.g. 
# "ttt:Agent": [
#    "http://agent-url.ie/agent_one/",
#    "http://agent-url.ie/agent_zero/"
#  ]
#   Links to      / 
#   Form to register
@app.route(('/players'), methods=["GET"])
def players():
    rw = ResponseWriter(BASE_URL + "players",GAME_ONTOLOGY_PREFIX + ":Game")
    rw.add_link(BASE_URL + "",method_name="GET")
    if FREE_PLAYERS:
        rw.add_field(GAME_ONTOLOGY_PREFIX + ":Agent",FREE_PLAYERS) 
        rw.add_form(BASE_URL + "registerGame",method_name="POST",contentType="application/json",op="writeproperty")
        rw.add_form_property(BASE_URL + "registerGame",GAME_ONTOLOGY_PREFIX+":XPlayerRole",False,True)
        rw.add_form_property(BASE_URL + "registerGame",GAME_ONTOLOGY_PREFIX+":OPlayerRole",False,True)
    else:
        rw.add_error("No free players")
        rw.add_form(BASE_URL + "register",method_name="POST",contentType="application/json",op="writeproperty")
        rw.add_form_property(BASE_URL + "register","@id",False,True)

    return format_response(rw)


# /Board HTTP method GET
# Parameter: Game ID
# If not a valid game id
#   Links to:       /
# If registered
#   Links and forms to active game (see function add_links_for_active_game) 
#   Game information, e.g. 
#   "ttt:hasSquare": [
#    {
#      "http://localhost:8083/Square11/d0603a12-4c09-4407-9ee3-eea34caaf3f9": {
#        "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": "http://localhost:8083/tic-tac-toe#Square11",
#        "http://localhost:8083/tic-tac-toe#moveTakenBy": "http://localhost:8083/tic-tac-toe#XPlayerRole"
#      }
#    }
#  ],
@app.route("/Board/<id>", methods=["GET"])
def board(id):
    rw = ResponseWriter(request.url,GAME_ONTOLOGY_PREFIX + ":Board")
    rw.add_link(BASE_URL + "",method_name="GET")
    
    #For testing...
    if id == "test":
        return get_test_board()
 
    id = uuid.UUID(id)
    if id in GAMES:
        game_rdf_store = GAMES[id] 
        add_links_for_active_game(game_rdf_store, rw, id, False) #This adds links to free squares
        
        board = game_rdf_store.get_board_occupied()
        for b in board:
            rw.add_nested_field(GAME_ONTOLOGY_PREFIX + ":hasSquare",b,board[b]) #Just passing key in 

    else:
        rw.add_error("No active game registered")
        

    return format_response(rw)
    

def get_test_board():
    with open('templates/testboard.json') as f:
        content = json.load(f)
        return Response(json.dumps(content), mimetype='application/ld+json')

# /result
# Parameter: Game ID
# If registered
#   Links to      /Board
#                 / 
#   Result RDF in the form of (for example)
#       GAME_ONTOLOGY_PREFIX + ":TicTacToeResult" : agent_url OR "Draw" 
# Else
#   Error and link to index
@app.route('/result/<res>')
def result(res):
    #Start building response
    rw = ResponseWriter(request.url,GAME_ONTOLOGY_PREFIX + ":TicTacToeResult")
    id = uuid.UUID(res)
    #Is the player registered 
    if id in GAMES:
        game_rdf_store = GAMES[id] 
        winner = game_rdf_store.get_winner()
       
        if winner:
            rw.add_field(GAME_ONTOLOGY_PREFIX + ":TicTacToeResult",winner)
        else:
            rw.add_field(GAME_ONTOLOGY_PREFIX + ":TicTacToeResult","Draw") 

        # Save game
        try:
            game_rdf_store.save_graph()
        except:
           print("An exception occurred saving the graph")

        # Remove value from GAMES dictionary (means can't see the board, but tidies up memory))
        # del GAMES[id]

    else:
        rw.add_error("No active game registered")


    rw.add_link(BASE_URL,method_name="GET")
   

    return format_response(rw)


# /Square<sq>
# E.g. /Square11, /Square12... /Square33
# Parameter: Game ID
# This is a form, body needs one one value, the ID of the curent agent
# {
#  "@id": "http://agent-url.ie/agent_zero/"
# }
# 
# If registered
#   Links to      /Board
#                 / 
#   Information on move taken by e.g.
#   GAME_ONTOLOGY_PREFIX + ":moveTakenBy": "ttt:XPlayerRole",
#   If game over
#       Links to      /result
#   If the move is invalid
#       Provides error
# Else
#   Error and link to index
@app.route('/Square<sq>/<id>', methods=["PUT"])
def square(sq, id):
    rw = ResponseWriter(request.url,GAME_ONTOLOGY_PREFIX + ":Square"+sq) 
    rw.add_link(BASE_URL + "",method_name="GET") #Always link to index page
    id = uuid.UUID(id)

    agent_url = request.get_json()['@id']

    if id in GAMES:
        id_str = str(id)
        game_rdf_store = GAMES[id] 

        role = game_rdf_store.get_role(URIRef(agent_url))
        if not check_valid_turn(game_rdf_store, role):
            rw.add_error("It is not this agent's turn")
            return format_response(rw)
        
        # Lazy check to verify player is part of game
        if not role:
            rw.add_error("Agent isn't assigned a role for this game")
            return format_response(rw)
        
        # Check for invalid posts
        # Instead of using request.url for the square checking (which breaks tests),
        # get it from the rdf store
        square_url = game_rdf_store.square_instance_from_number(sq)
        if game_rdf_store.is_square_free(square_url):

            # Need to know if this fails
            game_rdf_store.add_move(square_url, URIRef(agent_url))
           
            rw.add_field(GAME_ONTOLOGY_PREFIX + ":moveTakenBy", role)
            
            #Is there a winner
            game_over = game_rdf_store.is_game_over()
            if game_over:
                #Make the result URL available
                #print("We have a result (after agent move)")
                rw.add_link(BASE_URL + "result/" + id_str,method_name="GET") 
            else:
                rw.add_link(game_rdf_store.board,method_name="GET") 
        
        else:
            rw.add_error("Invalid move")

    else: 
        rw.add_error("No active game registered")
    
    return format_response(rw)


### Helper methods ###

#If the number of free squares is odd, it is the X player's turn as X starts first
def check_valid_turn(game_rdf_store, role):
    num = len(game_rdf_store.get_free_squares())
    if num % 2 == 0:
        if (role == game_rdf_store.ttt.OPlayerRole):
            return True
        else:
            return False
    else:
        if (role == game_rdf_store.ttt.XPlayerRole):
            return True
        else:
            return False
        
        

# Game over?
# Links to:    /result
# Forms to:    /registerGame
# Otherwise
# Links to:    /Board (unless this is the board response)
# Forms to:    /Square<SquareId>    (all free squares)
def add_links_for_active_game(game_rdf_store, rw, id, includeBoardLink=True):
    id_str = str(id)
    if (game_rdf_store.is_game_over()):
        rw.add_link(BASE_URL + "result/" + id_str,method_name="GET") 
        rw.add_form(BASE_URL + "registerGame",method_name="POST",contentType="application/json",op="writeproperty")
        rw.add_form_property(BASE_URL + "registerGame",GAME_ONTOLOGY_PREFIX+":XPlayerRole",False,True)
        rw.add_form_property(BASE_URL + "registerGame",GAME_ONTOLOGY_PREFIX+":OPlayerRole",False,True)
    else:
        board = game_rdf_store.board
        if (includeBoardLink):
            rw.add_link(board,method_name="GET") 


        free_squares = game_rdf_store.get_free_squares()
        for sq in free_squares:
            rw.add_form(str(sq),method_name="PUT",contentType="application/json",op="writeproperty") 
            rw.add_form_property(str(sq),"@id",False,True)
            

# Write the response object 
def format_response(rw):
    response_json = rw.build()
    json_str = json.dumps(response_json);
    return Response(json_str, mimetype='application/ld+json')


# Start the server
if __name__ == '__main__':
    app.debug=True
    app.run(host='0.0.0.0',port=PORT)
