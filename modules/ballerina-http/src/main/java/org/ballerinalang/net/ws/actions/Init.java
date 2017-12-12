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
package org.ballerinalang.net.ws.actions;


import org.ballerinalang.bre.Context;
import org.ballerinalang.connector.api.ConnectorFuture;
import org.ballerinalang.connector.impl.ServerConnectorRegistry;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.nativeimpl.actions.ClientConnectorFuture;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaAction;
import org.ballerinalang.net.ws.Constants;
import org.ballerinalang.util.codegen.ServiceInfo;

/**
 * {@code Init} is the Init action implementation of the SQL Connector.
 *
 * @since 0.94
 */
@BallerinaAction(
        packageName = "ballerina.net.ws",
        actionName = "<init>",
        connectorName = Constants.CONNECTOR_NAME,
        args = {@Argument(name = "c", type = TypeKind.CONNECTOR)
        },
        connectorArgs = {
                @Argument(name = "url", type = TypeKind.STRING),
                @Argument(name = "config", type = TypeKind.STRUCT, structType = "ClientConnectorConfig",
                          structPackage = "ballerina.net.ws")
        })
public class Init extends AbstractNativeWsAction {

    @Override
    public ConnectorFuture execute(Context context) {
        // Basically this code block will only run in the main since
        // if a service is run these steps will be already done
        if (context.getProgramFile().getServerConnectorRegistry() == null) {
            ServerConnectorRegistry serverConnectorRegistry = new ServerConnectorRegistry();
            serverConnectorRegistry.initServerConnectors(); // Initializing server connectors
            // Registering service which are need for the client connector to work.
            for (ServiceInfo serviceInfo : context.getProgramFile().getEntryPackage().getServiceInfoEntries()) {
                serverConnectorRegistry.registerService(serviceInfo);
            }
            context.getProgramFile().setServerConnectorRegistry(serverConnectorRegistry);
        }
        ClientConnectorFuture ballerinaFuture = new ClientConnectorFuture();
        ballerinaFuture.notifySuccess();
        return ballerinaFuture;
    }
}
