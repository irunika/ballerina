# WebSocket Server Connector

WebSocket is a protocol that provides full-duplex, persistent communication channels over a single TCP connection. 
Once a WebSocket connection is established, the connection stays open until the client or server decides to close this 
connection. This connection is also initialized by the client, in which case the WebSocket protocol uses an HTTP request 
to upgrade the connection from HTTP to WebSocket using two HTTP headers, “Connection” and “Upgrade”.

For example:

```
GET ws://websocket.example.com/ HTTP/1.1
Origin: http://example.com
Connection: Upgrade
Host: websocket.example.com
Upgrade: websocket
```

This tells the server that the client needs to establish a WebSocket connection. 
If the server supports WebSocket, it sends the response agreeing to establish the connection using the “Upgrade” header.

For example:

```
HTTP/1.1 101 WebSocket Protocol Handshake
Date: Wed, 16 Oct 2013 10:07:34 GMT
Connection: Upgrade
Upgrade: WebSocket
```

Once this message is sent, the handshake is completed, and the initial HTTP connection is replaced by the WebSocket 
connection using the same underlying TCP/IP connection. Ballerina uses the same HTTP base path + WebSocket Upgrade path
 to upgrade the existing connection to a WebSocket 
connection. 

## Defining a WebSocket service in Ballerina

### Step 1: Define the service as a WebSocket service
To define the service as a WebSocket service ballerina.net.ws package should be imported and define the service
as WebSocket

```
import ballerina.net.ws;

service<ws> wsServer {
}
```

### Step 2: Add ws:configuration annotation
To make a WebSocket endpoint to work ws:configuration annotation should be defined. It has several attributes.

|Attribute|Description|
|---------|--------------|
|basePath|Path for the WebSocket connection|
|subProtocols|string array of sub protocols for WebSocket connection|
|idleTimeoutInSeconds|Idle timeout for a given connection in seconds|
|host|Host of the server|
|port|port of the server|
|wssPort|secure WebSocket port of the server. But to use this port|
|keyStoreFile|Key store file for wss connection|
|keyStorePass|Key store password for wss connection|
|certPass|Certificate password for wss connection|

For example:

```
import ballerina.net.ws;

@ws:configuration {
    basePath: "/test/ws",
    subProtocols: ["xml", "json"],
    idleTimeoutInSeconds: 60,
    host: "0.0.0.0",
    port: 5010,
    wssPort: 5008,
    keyStoreFile: "${ballerina.home}/bre/security/wso2carbon.jks",
    keyStorePass: "wso2carbon",
    certPass: "wso2carbon"
}
service<ws> SimpleSecureServer {
}
```
If you want to connect to this WebSocket endpoint, use `ws://host:port/test/ws`. 

### Step 3: Adding resources to the service
There are few very restricted resource which can be put inside a WebSocket service. Each and every resources are 
defined for very specific purposes. Note that since the resource definition is restricted inside WS service defining a 
resource signature other than mentioned below will produce errors.

#### resource onHandshake(ws:HandshakeConnection conn)
This resource is used to process something before the connection is established. Which means before the handshake
is done. 

|Argument|Description|
|--------|-----------|
|ws:HandshakeConnection|Contains all the details about the incoming connection. This can be used to identify the behavior of the connection which is going to connect|

#### resource onOpen(ws:Connection conn) 
This resource is called after the connection is established. 

|Argument|Description|
|--------|-----------|
|ws:Connection|Contains details about the current connection which the message is received from. Can be used do connection oriented operations and obtain details about the connection|

#### resource onTextMessage (ws:Connection conn, ws:TextFrame frame)
This is called when new text frame is received from a well established connection.

|Argument|Description|
|--------|-----------|
|ws:Connection|Contains details about the current connection which the message is received from. Can be used do connection oriented operations and obtain details about the connection|
|ws:TextFrame|Text frame received from the client|

#### resource onBinaryMessage(ws:Connection conn, ws:BinaryFrame frame)
This is called when new binary frame is received from a well established connection.

|Argument|Description|
|--------|-----------|
|ws:Connection|Contains details about the current connection which the message is received from. Can be used do connection oriented operations and obtain details about the connection|
|ws:BinaryFrame|Binary data frame received from the client|


#### resource onIdleTimeout(ws:Connection conn)
This is called when idle timeout specified in ws:configuration annotation is achieved. Note that this is to work,
idle timeout should be defined in the ws:configuration annotation. Otherwise this will not triggered since ballerina
treat it as an infinite connection.

|Argument|Description|
|--------|-----------|
|ws:Connection|Contains details about the current connection which the message is received from. Can be used do connection oriented operations and obtain details about the connection|

#### resource onClose(ws:Connection conn, ws:CloseFrame closeFrame)
This is called when the connection is closed from the client side.

|Argument|Description|
|--------|-----------|
|ws:Connection|Contains details about the current connection which the message is received from. Can be used do connection oriented operations and obtain details about the connection|
|ws:CloseFrame|Close frame received from the client|


#### Example

```
import ballerina.lang.system;
import ballerina.net.ws;

@ws:configuration {
    basePath:"/basic/ws",
    port:9090,
    idleTimeoutInSeconds:10
}
service<ws> basicEndpoint {

    resource onHandshake(ws:HandshakeConnection conn) {
        system:println("New client is going to connect");
    }

    resource onOpen(ws:Connection conn) {
        system:println("New client connected");
    }

    resource onTextMessage(ws:Connection conn, ws:TextFrame frame) {
        system:println("New text message received: " + frame.text);
    }

    resource onBinaryMessage(ws:Connection conn, ws:BinaryFrame frame) {
        blob b = frame.data;
        system:println("New binary message received");
    }

    resource onIdleTimeout(ws:Connection conn) {
        system:println("Connection " + ws:getID(conn) + " achieved it's idle timeout");
    }

    resource onClose(ws:Connection conn, ws:CloseFrame frame) {
        system:println("Connection " + ws:getID(conn) + "is closed");
        system:println("Status code: " + frame.statusCode);
        system:println("Close reason: " + frame.reason);
    }
}
```

## Built in Structs for WebSocket
There are few built in functions for WebSocket and in the previous example those structs were used to obtain data, 
details and do connection oriented operations. 

## ws:HandshakeConnection
This struct is used to obtain details about the connection on the handshake which will only be used as a argument
for the "onHandshake" resource.

### Fields of the ws:HandshakeConnection
|Field|Parameter type|Description|
|-----|--------------|-----------|
|connectionID|string|ID of the connection. This will not change for the entire time while connection is disconnected|
|isSecure|boolean|true if the connection is a secure connection|
|upgradeHeaders|map|A map of upgrade headers of a given connection. This field include all the headers including connection and upgrade headers|

## ws:Connection
This struct represents a already opened connection. This struct is valid after the handshake. This is used to 
do connection oriented operations and obtain the current details of the connection.

### Function for ws:Connection
#### ws:getID(ws:Connection conn) returns (string)
This function returns the id of the connection. This is the same ID which is obtained from the ws:HandshakeConnection
on the handshake since the connection never changes for a given WebSocket connection.

#### ws:getNegotiatedSubProtocol(ws:Connection conn) returns (string)
This returns negotiated sub protocol of the connection. This sub protocol can be a one of the sub protocols defined
in the ws:configuration annotation or null if client did not define any sub protocol for negotiation.

#### ws:isOpen(ws:Connection conn) returns (boolean)
Check whether the connection is still open or not.

#### ws:getUpgradeHeaders(ws:Connection conn) returns (map)
Get a map of all the upgrade headers of the connection

#### ws:getUpgradeHeader(ws:Connection conn, string key) returns (string)
Get the value of upgrade header for a given key.

#### ws:getParentConnection(ws:Connection conn) returns (ws:Connection)
If there is a parent connection set for a given connection it can be retrieved via this function.

#### ws:pushText(Connection conn, string text)
This method is used to write text to the connection. Which will send text to the other end of the connection.

#### ws:pushBinary(Connection conn, blob data)
This method is used to write binary data to the connection. 
Which will send binary data to the other end of the connection.

#### ws:closeConnection(Connection conn, int statusCode, string reason)
Close the connection. Need to set status code and reason for closing the connection.

