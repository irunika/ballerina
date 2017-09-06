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

package org.ballerinalang.nativeimpl.net.ws;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.Attribute;
import org.ballerinalang.natives.annotations.BallerinaAnnotation;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.services.dispatchers.ws.Constants;
import org.ballerinalang.util.exceptions.BallerinaException;

import java.nio.ByteBuffer;
import javax.websocket.Session;

/**
 * Send text to the same client who sent the message to the given WebSocket Upgrade Path.
 */

@BallerinaFunction(
        packageName = "ballerina.net.ws",
        functionName = "pushBinary",
        args = {@Argument(name = "session", type = TypeEnum.STRUCT, structType = "Connection",
                          structPackage = "ballerina.net.ws"),
                @Argument(name = "binaryData", type = TypeEnum.BLOB)},
        isPublic = true
)
@BallerinaAnnotation(annotationName = "Description",
                     attributes = { @Attribute(name = "value", value = "This pushes binary data from server to the " +
                             "the same client who sent the message.") })
@BallerinaAnnotation(annotationName = "Param",
                     attributes = { @Attribute(name = "binaryData", value = "Binary data which should be sent") })
public class PushBinary extends AbstractNativeFunction {

    @Override
    public BValue[] execute(Context context) {

        if (context.getServiceInfo() == null ||
                !context.getServiceInfo().getProtocolPkgPath().equals(Constants.WEBSOCKET_PACKAGE_PATH)) {
            throw new BallerinaException("This function is only working with WebSocket services");
        }

        try {
            BStruct wsConnection = (BStruct) getRefArgument(context, 0);
            Session session = (Session) wsConnection.getNativeData(Constants.WEBSOCKET_SESSION);
            byte[] binaryData = getBlobArgument(context, 0);
            session.getBasicRemote().sendBinary(ByteBuffer.wrap(binaryData));
        } catch (Throwable e) {
            throw new BallerinaException("Cannot send the message. Error occurred.");
        }
        return VOID_RETURN;
    }
}
