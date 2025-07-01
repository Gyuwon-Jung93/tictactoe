# Tic Tac Toe

The following project was created for the UCD module COMP41400, Multi-Agent Systems.

Instructions are posted on Brightspace.

Requirements:

For this lab you will need to use Java version 11.
You will need Maven.

To run the ttt-api you will need Python or Docker. See the ttt-api [README](https://gitlab.com/astra-language/examples/semantic-environments/tic-tac-toe/-/blob/main/ttt-api/README.md?ref_type=heads) file for instructions on how to run this.

## ttt-api

This hosts a game of Tic-Tac-Toe using Semantic Web technology. The [README](https://gitlab.com/astra-language/examples/semantic-environments/tic-tac-toe/-/blob/main/ttt-api/README.md?ref_type=heads) will walk you through the game play.

The ttt-api is a bespoke REST (REpresentational State Transfer )API that includes hypermedia controls (hyperlinks and forms). The API returns JSON-LD representations that contain links to the ontologies used, allowing agents to reason about and learn from the information presented.

It has a single entry point from which agents can navigate the system (e.g. http://localhost:8083/). From this entry point, agents can register themselves as players. From this entry point, agents can register to play, at which point they are added to a list of free players (accessible at the /players endpoint, e.g. http://localhost:8083/players. Once players find another player to play with, they can register a game. At this point they receiv e an assigned game identifier (ID), can view the board, make moves, and view the result when the game has been completed. The JSON-LD representations combine data with links and forms that specify contextually valid interactions. The ontologies used to achieve this includes: the [Hypermedia Controls Ontology](https://www.w3.org/2019/wot/hypermedia#) the [Hypertext Transfer Protocol (HTTP) Ontology](http://www.w3.org/2011/http#), the [Web of Things (WoT) Thing Description 1.1](https://w3c.github.io/wot-thing-description/#) as well as the custom built Tic-Tac-Toe Ontology.

The Tic-Tac-Toe Ontology was created to provide the concept of a game, moves, players, player roles, squares, the board and the result. When a new game is registered, a new RDF graph of the instantiated ontology classes (which represent the game, game ID, board, squares, players and player roles) is created and stored in memory. When moves are made, an instance of the Move class is created along with relationships which link the Move to a Square, `inSquare`, and with a player role, `moveTakenBy`. On querying the result, a JSON-LD representation is returned, and in addition the [RDF graph](https://www.w3.org/TR/rdf12-concepts/) of the game is written out to a file, which provides the possibility to analyse past games and construct a knowledge graph of the game history.

## sample-agents

You agent starter kit: ready for you to start coding.
