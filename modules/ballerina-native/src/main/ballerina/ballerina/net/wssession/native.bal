package ballerina.net.wssession;

import ballerina.doc;

struct Session {
    string webSocketSessionID;
}

@doc:Description {value:"This gives the session of the current WebSocket client"}
@doc:Return { value:"Session: WebSocket session" }
native function getSession() (Session);

@doc:Description {value:"Give the ID of the required client"}
@doc:Param {value:"session: WebSocket Session"}
@doc:Return { value:"string: ID of the given session" }
native function getId(Session session) (string);

@doc:Description {value:"Push text to required client"}
@doc:Param {value:"session: WebSocket Session"}
@doc:Param { value:"text: Text which should be sent" }
native function pushText(Session session, string text);