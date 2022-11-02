# ApiProject

 http://localhost:8080/polls

to get the polls listed press GET to post them once database is created and used hit POST when creating the BODY pressing raw then JSON and filling in 
the info below inside the body.

{ "question": "who will win the superbowl this year",
    "option": [

{"value": "New England Patriots"},
{"value": "Seattle Seahawks"},
{"value": "Green Bay Packers"},
{"value": "Denver Broncos"}
]
}

 http://localhost:8080/polls/1/votes
 
 this is to cast a vote for ID number 1 or whatever value you want to use making sure to put this as the body
 
 {"option":{
    "id":1,
    "value": "Green Bay Packers"
}
}

 http://localhost:8080/computeresult?pollId=1
 
 this is to view what was implemented in the body as a result.
