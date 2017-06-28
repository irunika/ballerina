package ballerina.net.ws_session;

import ballerina.lang.system;
import src.main.ballerina.ballerina.doc;

struct Session {
    string webSocketSessionID;
}

@doc:Description {value:"This gives the session of the current WebSocket client"}
@doc:Return { value:"Session: WebSocket session" }
native function getSession () (Session);
