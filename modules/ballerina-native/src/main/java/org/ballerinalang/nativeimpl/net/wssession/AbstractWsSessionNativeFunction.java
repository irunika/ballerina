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

package org.ballerinalang.nativeimpl.net.wssession;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.services.dispatchers.ws.Constants;
import org.ballerinalang.services.dispatchers.ws.WebSocketConnectionManager;
import org.ballerinalang.util.codegen.PackageInfo;
import org.ballerinalang.util.codegen.StructInfo;

import javax.websocket.Session;

/**
 * Common abstract class for WebSocket session native functions.
 */
public abstract class AbstractWsSessionNativeFunction extends AbstractNativeFunction {

    protected BStruct createSessionStruct(Context context, Session session) {
        String sessionID = session.getId();
        PackageInfo sessionPackageInfo = context.getProgramFile().getPackageInfo(Constants.WS_SESSION_PACKAGE);
        StructInfo sessionStructInfo = sessionPackageInfo.getStructInfo(Constants.STRUCT_SESSION);

        //create session struct
        BStruct bStruct = new BStruct(sessionStructInfo.getType());
        bStruct.setFieldTypes(sessionStructInfo.getFieldTypes());
        bStruct.init(sessionStructInfo.getFieldCount());

        //Add session Id to the struct as a string
        bStruct.setStringField(0, sessionID);

        return bStruct;
    }

    protected String getSessionID(BStruct sessionStruct) {
        return sessionStruct.getStringField(0);
    }

    protected Session getSession(BStruct sessionStruct) {
        String sessionID = getSessionID(sessionStruct);
        return WebSocketConnectionManager.getInstance().getSession(sessionID);
    }
}
