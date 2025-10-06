# TIC TAC TOE API

This API allows users to play a game of Tic-Tac-Toe, using RESTful API calls to various endpoints, which return JSON with hypermedia controls and the use of Hypermedia As The Engine Of Application State (HATEOAS). 

Important note: 
The form properties field, and inner values, are entirely made up at the moment and future work would change this to something that fits an existing ontology (e.g. change this to be compatible with WOT descriptions)

## Requirements

You will need the programming language [Python](https://www.python.org/downloads/). If you are not familiar with Python, you can skip this and use [Docker](https://www.docker.com/) to run the API instead. 

This has been developed using the [anaconda3](https://anaconda.org/) environment / suite of libraries and dependencies and [pip](https://pypi.org/project/pip/) for dependencies.

[RDFLib](https://rdflib.readthedocs.io/en/stable/index.html) is used for the ontology and graph. [Flask](https://flask.palletsprojects.com/en/3.0.x/) is used for the server. [pyLODE](https://github.com/RDFLib/pyLODE) is used to load in the Tic-Tac-Toe ontology and host it as HTML.

Requirements are in requirements.txt
Run ```pip install -r requirements.txt```

## Test and run

NB as this has been modified for two agents... all the tests are broken! Don't run them.

## Running the server

To specify host and port:

```flask run --host=localhost --port=8083```

or use the script:

```sh run.sh```

Please note, if you are running this for the [Sample Agent code](https://gitlab.com/astra-language/examples/semantic-environments/tic-tac-toe), you will need to use localhost port 8083.

Use the Docker image [here](https://gitlab.com/mams-ucd/examples/semantic-environments/tic-tac-toe/container_registry) liek so:


```docker pull registry.gitlab.com/mams-ucd/examples/semantic-environments/tic-tac-toe:latest```


Then: 


```docker run -p 8083:8083 registry.gitlab.com/mams-ucd/examples/semantic-environments/tic-tac-toe:latest```


OR to build locally on Docker either use the script:

```sh runDocker.sh```

Or to do this manually:

`docker build --tag ttt/gameapi .` in the current directory, 

then 

`docker run -it -p 8083:8083 -d ttt/gameapi` 

## Game Play

The information in the responses to the endpoints provides information to the agents as to what the next steps in game play are. 
The X Player always goes first.

The game play is as follows;

- The index page is the route in to the API (see 1 below). This provides information about the form to register with the agemt API.
- The agent registers at the endpoint /register, by POST request (2 below) which must include the Agent URL "@id : <url> ". This adds the agent url to a list (free players)
- The agent can see the list of free players by GET request to the /players endpoint (3 below)

- The agent can register a game, with another player, by POST request to the /registerGame endpoint. At this point the agents are removed from the list of free players (4 below)
- This returns links and forms to play the game, and the assigned game ID (in the examples below this is d0603a12-4c09-4407-9ee3-eea34caaf3f9)

- Players make a move by PUT request to the relevant Square endpoint (5 below).
- When a winning move is made a link to the result and form to register again are provided (8 below). 
- The graph of the game is stored in the /results folder, with the game ID as the file title and in ttl format.

## Example requests and responses

#### 1. Index page request:

GET http://localhost:8083/
Headers:
Content-Type application/json

#### Index page response:

```
{
  "@id": "http://localhost:8083/",
  "@type": "ttt:Game",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "links": [
    {
      "href": "http://localhost:8083/players",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/register",
      "contentType": "application/json",
      "htv:methodName": "POST",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```

#### 2. Register form request:

POST http://localhost:8083/register
Headers:
Content-Type application/json

Body: 
```
{
  "@id": "http://agent-url.ie/agent_zero/",
  "@type": "ttt:Agent",
  "@context": {
    "ttt": "http://localhost:8083/tic-tac-toe#"
  }
}
```

#### Register form response:

```
{
  "@id": "http://localhost:8083/register",
  "@type": "ttt:Game",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:Agent": "http://agent-url.ie/agent_zero/",
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    },
    {
      "href": "http://localhost:8083/players",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/registerGame",
      "contentType": "application/json",
      "htv:methodName": "POST",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "ttt:XPlayerRole",
          "readOnly": false,
          "required": true
        },
        {
          "name": "ttt:OPlayerRole",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```

#### 3 Players page request

GET http://localhost:8083/players
Headers:
Content-Type application/json

#### Players page response

```
{
  "@id": "http://localhost:8083/players",
  "@type": "ttt:Game",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:Agent": [
    "http://agent-url.ie/agent_zero/"
  ],
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/registerGame",
      "contentType": "application/json",
      "htv:methodName": "POST",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "ttt:XPlayerRole",
          "readOnly": false,
          "required": true
        },
        {
          "name": "ttt:OPlayerRole",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```

#### Players page response with multiple players

```
{
  "@id": "http://localhost:8083/players",
  "@type": "ttt:Game",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:Agent": [
    "http://agent-url.ie/agent_zero/",
    "http://agent-url.ie/agent_one/"
  ],
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/registerGame",
      "contentType": "application/json",
      "htv:methodName": "POST",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "ttt:XPlayerRole",
          "readOnly": false,
          "required": true
        },
        {
          "name": "ttt:OPlayerRole",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```

#### 4 Register Game Form:

POST http://localhost:8083/registerGame
Headers:
Content-Type application/json

Body: 
```
{
  "@id": "http://agent-url.ie/agent_zero/",   
  "@type": "ttt:Agent",
  "@context": {
    "ttt": "http://localhost:8083/tic-tac-toe#"
  },
  "ttt:XPlayerRole": "http://agent-url.ie/agent_zero/",
  "ttt:OPlayerRole": "http://agent-url.ie/agent_one/"
}
```

#### Register Game form response:

```
{
  "@id": "http://localhost:8083/registerGame",
  "@type": "ttt:Game",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:hasID": "af8ea82a-9668-4d89-8f7c-331be2f1f480",
  "ttt:XPlayerRole": "http://agent-url.ie/agent_zero/",
  "ttt:OPlayerRole": "http://agent-url.ie/agent_one/",
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    },
    {
      "href": "http://localhost:8083/Board/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/Square11/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square12/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square13/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square21/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square22/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square23/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square31/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square32/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square33/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```

#### 5 Square Form Request:

PUT http://localhost:8083/Square11/af8ea82a-9668-4d89-8f7c-331be2f1f480
Headers:
Content-Type application/json

Body

```
{
  "@id": "http://agent-url.ie/agent_zero/"
}
```

#### Square Form Response:

```
{
  "@id": "http://localhost:8083/Square11/af8ea82a-9668-4d89-8f7c-331be2f1f480",
  "@type": "ttt:Square11",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:moveTakenBy": "http://localhost:8083/tic-tac-toe#XPlayerRole",
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    },
    {
      "href": "http://localhost:8083/Board/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "htv:methodName": "GET"
    }
  ]
}
```

#### 6 Board Request:

GET http://localhost:8083/Board/af8ea82a-9668-4d89-8f7c-331be2f1f480
Content-Type application/json

#### Board Response:

```
{
  "@id": "http://localhost:8083/Board/af8ea82a-9668-4d89-8f7c-331be2f1f480",
  "@type": "ttt:Board",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:hasSquare": [
    {
      "http://localhost:8083/Square11/af8ea82a-9668-4d89-8f7c-331be2f1f480": {
        "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": "http://localhost:8083/tic-tac-toe#Square11",
        "http://localhost:8083/tic-tac-toe#moveTakenBy": "http://localhost:8083/tic-tac-toe#XPlayerRole"
      }
    }
  ],
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/Square12/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square13/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square21/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square22/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square23/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square31/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square32/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square33/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```
### 6 More moves...

#### O
PUT http://localhost:8083/Square31/af8ea82a-9668-4d89-8f7c-331be2f1f480
Headers:
Content-Type application/json

Body

```
{
  "@id": "http://agent-url.ie/agent_one/"
}
```

#### X
PUT http://localhost:8083/Square12/af8ea82a-9668-4d89-8f7c-331be2f1f480
Headers:
Content-Type application/json

Body

```
{
  "@id": "http://agent-url.ie/agent_zero/"
}
```

#### O
PUT http://localhost:8083/Square32/af8ea82a-9668-4d89-8f7c-331be2f1f480
Headers:
Content-Type application/json

Body

```
{
  "@id": "http://agent-url.ie/agent_one/"
}
```

### 7 Board After more moves

```
{
  "@id": "http://localhost:8083/Board/af8ea82a-9668-4d89-8f7c-331be2f1f480",
  "@type": "ttt:Board",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:hasSquare": [
    {
      "http://localhost:8083/Square11/af8ea82a-9668-4d89-8f7c-331be2f1f480": {
        "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": "http://localhost:8083/tic-tac-toe#Square11",
        "http://localhost:8083/tic-tac-toe#moveTakenBy": "http://localhost:8083/tic-tac-toe#XPlayerRole"
      }
    },
    {
      "http://localhost:8083/Square12/af8ea82a-9668-4d89-8f7c-331be2f1f480": {
        "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": "http://localhost:8083/tic-tac-toe#Square12",
        "http://localhost:8083/tic-tac-toe#moveTakenBy": "http://localhost:8083/tic-tac-toe#XPlayerRole"
      }
    },
    {
      "http://localhost:8083/Square31/af8ea82a-9668-4d89-8f7c-331be2f1f480": {
        "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": "http://localhost:8083/tic-tac-toe#Square31",
        "http://localhost:8083/tic-tac-toe#moveTakenBy": "http://localhost:8083/tic-tac-toe#OPlayerRole"
      }
    },
    {
      "http://localhost:8083/Square32/af8ea82a-9668-4d89-8f7c-331be2f1f480": {
        "http://www.w3.org/1999/02/22-rdf-syntax-ns#type": "http://localhost:8083/tic-tac-toe#Square32",
        "http://localhost:8083/tic-tac-toe#moveTakenBy": "http://localhost:8083/tic-tac-toe#OPlayerRole"
      }
    }
  ],
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/Square13/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square21/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square22/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square23/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    },
    {
      "href": "http://localhost:8083/Square33/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "contentType": "application/json",
      "htv:methodName": "PUT",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```

### Move out of turn

PUT http://localhost:8083/Square13/d0603a12-4c09-4407-9ee3-eea34caaf3f9
Headers:
Content-Type application/json

Body

```
{
  "@id": "http://agent-url.ie/agent_one/"
}
```

### Response

```
{
  "@id": "http://localhost:8083/Square13/af8ea82a-9668-4d89-8f7c-331be2f1f480",
  "@type": "ttt:Square13",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "sch:error": "It is not this agent's turn",
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    }
  ]
}
```

### 8...Winning Move

PUT http://localhost:8083/Square13/af8ea82a-9668-4d89-8f7c-331be2f1f480
Headers:
Content-Type application/json

Body

```
{
  "@id": "http://agent-url.ie/agent_zero/"
}
```

### Response

```
{
  "@id": "http://localhost:8083/Square13/af8ea82a-9668-4d89-8f7c-331be2f1f480",
  "@type": "ttt:Square13",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:moveTakenBy": "http://localhost:8083/tic-tac-toe#XPlayerRole",
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    },
    {
      "href": "http://localhost:8083/result/af8ea82a-9668-4d89-8f7c-331be2f1f480",
      "htv:methodName": "GET"
    }
  ]
}
```

### Request

GET http://localhost:8083/result/af8ea82a-9668-4d89-8f7c-331be2f1f480

### Response

```
{
  "@id": "http://localhost:8083/result/af8ea82a-9668-4d89-8f7c-331be2f1f480",
  "@type": "ttt:TicTacToeResult",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "ttt:TicTacToeResult": "http://localhost:8083/tic-tac-toe#XPlayerRole",
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    }
  ]
}
```

### Errors: player not registered

Attempt to register a game when players are not registered

```
{
  "@id": "http://localhost:8083/registerGame",
  "@type": "ttt:Game",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "sch:error": "X Player Agent is not registered",
  "links": [
    {
      "href": "http://localhost:8083//",
      "htv:methodName": "GET"
    },
    {
      "href": "http://localhost:8083//players",
      "htv:methodName": "GET"
    }
  ],
  "forms": [
    {
      "href": "http://localhost:8083/register",
      "contentType": "application/json",
      "htv:methodName": "POST",
      "wot:op": "writeproperty",
      "properties": [
        {
          "name": "@id",
          "readOnly": false,
          "required": true
        }
      ]
    }
  ]
}
```

Attempt a request to a game that doesn't exist

```
{
  "@id": "http://localhost:8083/Square13/af8ea82a-1668-4d89-8f7c-331be2f1f480",
  "@type": "ttt:Square13",
  "@context": {
    "@vocab": "https://www.w3.org/2019/wot/hypermedia#",
    "ttt": "http://localhost:8083/tic-tac-toe#",
    "htv": "http://www.w3.org/2011/http#",
    "wot": "https://w3c.github.io/wot-thing-description/#",
    "sch": "https://schema.org/",
    "links": {
      "@id": "Link"
    },
    "forms": {
      "@id": "Form"
    },
    "href": {
      "@id": "hasTarget"
    },
    "rel": {
      "@id": "hasRelationType",
      "@type": "@vocab"
    }
  },
  "sch:error": "No active game registered",
  "links": [
    {
      "href": "http://localhost:8083/",
      "htv:methodName": "GET"
    }
  ]
}
```