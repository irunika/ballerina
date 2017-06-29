/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.services.dispatchers.ws;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import javax.websocket.CloseReason;
import javax.websocket.Session;

/**
 * This contains all the sessions which are received via a {@link org.wso2.carbon.messaging.CarbonMessage}.
 */
public class WebSocketConnectionManager {

    // Map <sessionId, session>
    private final Map<String, Session> sessions = new ConcurrentHashMap<>();
    // Map<serviceName, List<sessionId>>
    private final Map<String, List<String>> broadcastSessions = new ConcurrentHashMap<>();
    // Map<groupName, Map<sessionId, session>>
    private final Map<String, List<String>> connectionGroups = new ConcurrentHashMap<>();
    // Map<NameToStoreConnection, sessionId>
    private final Map<String, String> connectionStore = new ConcurrentHashMap<>();

    private static final WebSocketConnectionManager sessionManager = new WebSocketConnectionManager();

    private WebSocketConnectionManager() {
    }

    public static WebSocketConnectionManager getInstance() {
        return sessionManager;
    }

    /**
     * Retrieve the session of the given session ID.
     *
     * @param sessionID session ID of the required session.
     * @return the {@link Session} relates to the given session ID.
     */
    public Session getSession(String sessionID) {
        return sessions.get(sessionID);
    }

    /**
     * Add {@link Session} to session the broadcast group of a given service.
     *
     * @param serviceName name of the service.
     * @param session {@link Session} to add to the broadcast group.
     */
    public void addConnectionToBroadcast(String serviceName, Session session) {
        sessions.put(session.getId(), session);
        if (broadcastSessions.containsKey(serviceName)) {
            broadcastSessions.get(serviceName).add(session.getId());
        } else {
            List<String> sessionList = new LinkedList<>();
            sessionList.add(session.getId());
            broadcastSessions.put(serviceName, sessionList);
        }
    }

    /**
     * Remove {@link Session} from a broadcast group. This should be mostly called when a WebSocket connection is
     * Closed.
     *
     * @param serviceName name of the service.
     * @param session {@link Session} to remove from the broadcast group.
     */
    public void removeConnectionFromBroadcast(String serviceName, Session session) {
        if (broadcastSessions.containsKey(serviceName)) {
            broadcastSessions.get(serviceName).remove(session.getId());
        }
    }

    /**
     * Get a list of Sessions for broadcasting for a given service.
     *
     * @param serviceName name of the service.
     * @return the list of sessions which are connected to a given service.
     */
    public List<Session> getBroadcastConnectionList(String serviceName) {
        if (broadcastSessions.containsKey(serviceName)) {
            return broadcastSessions.get(serviceName).stream()
                    .map(sessionID -> sessions.get(sessionID))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /**
     * Add {@link Session} to session the session group.
     *
     * @param groupName name of the group.
     * @param session {@link Session} to remove from the broadcast group.
     */
    public void addConnectionToGroup(String groupName, Session session) {
        if (connectionGroups.containsKey(groupName)) {
            connectionGroups.get(groupName).add(session.getId());
        } else {
            List<String> sessionList = new LinkedList<>();
            sessionList.add(session.getId());
            connectionGroups.put(groupName, sessionList);
        }
    }

    /**
     * Remove {@link Session} from a session group. This should be mostly called when a WebSocket connection is
     * Closed.
     *
     * @param groupName name of the broadcast.
     * @param session {@link Session} to remove from the group.
     * @return true if the connection name was found and connection is removed.
     */
    public boolean removeConnectionFromGroup(String groupName, Session session) {
        if (connectionGroups.containsKey(groupName)) {
            connectionGroups.get(groupName).remove(session.getId());
            return true;
        }
        return false;
    }

    /**
     * Remove the whole group from the groups map.
     *
     * @param groupName name of the group.
     * @return true if connection group name exists and connection group is removed successfully.
     */
    public boolean removeConnectionGroup(String groupName) {
        if (connectionGroups.containsKey(groupName)) {
            connectionGroups.remove(groupName);
            return true;
        }
        return false;
    }

    /**
     * Get the list of the connections which belongs to a specific group.
     *
     * @param groupName name of the connection group.
     * @return a list of connections belongs to the mentioned group name.
     */
    public List<Session> getConnectionGroup(String groupName) {
        if (connectionGroups.containsKey(groupName)) {
            return connectionGroups.get(groupName).stream()
                    .map(sessionID -> sessions.get(sessionID))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /**
     * Store connection with the name given by the user for future usages.
     *
     * @param connectionName name of the connection given by the user.
     * @param session {@link Session} to store.
     */
    public void storeConnection(String connectionName, Session session) {
        connectionStore.put(connectionName, session.getId());
    }

    /**
     * Remove connection from the connection store.
     *
     * @param connectionName connection name which should be removed from the store.
     * @return true if connection name was found in connection store and removed successfully.
     */
    public boolean removeConnectionFromStore(String connectionName) {
        if (connectionStore.containsKey(connectionName)) {
            connectionStore.remove(connectionName);
            return true;
        }
        return false;
    }

    /**
     * Get the stored connection from the connection store.
     *
     * @param connectionName name of the connection which should be removed.
     * @return Session of the stored connection if connections is found else return null.
     */
    public Session getStoredConnection(String connectionName) {
        return sessions.get(connectionStore.get(connectionName));
    }

    /**
     * Close the session.
     * @param sessionID id of the connection.
     * @throws IOException throws if the closing connection is interrupted.
     */
    public void CloseConnection(String sessionID) throws IOException {
        Session session = sessions.get(sessionID);
        session.close();
        removeConnectionFromAll(session);
    }

    public void CloseConnection(String sessionID, String closeReason, int closeCode) throws IOException {
        Session session = sessions.get(sessionID);
        session.close(new CloseReason(
                () -> closeCode,
                closeReason
        ));
        removeConnectionFromAll(session);
    }

    /**
     * Connections can be saved in multiple places according to there need of use.
     * Once the connection is closed or because of the reason if it has to be removed from all the places
     * that it is referred to use this method.
     *
     * @param session {@link Session} which should be removed from all the places.
     */
    public void removeConnectionFromAll(Session session) {
        String sessionID = session.getId();

        // Remove session from session map
        sessions.remove(sessionID);

        // Removing session from broadcast sessions map
        broadcastSessions.entrySet().forEach(
                entry -> entry.getValue().remove(sessionID));
        //Removing session from groups map
        connectionGroups.entrySet().forEach(
                entry -> entry.getValue().remove(sessionID));
        // Removing session from connection store
        connectionStore.entrySet().removeIf(
                entry -> entry.getValue().equals(sessionID)
        );
    }
}
