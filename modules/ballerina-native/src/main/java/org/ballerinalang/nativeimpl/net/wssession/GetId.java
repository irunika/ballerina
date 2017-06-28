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
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.Attribute;
import org.ballerinalang.natives.annotations.BallerinaAnnotation;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

/**
 * Retrieve the ID of the session.
 */
@BallerinaFunction(
        packageName = "ballerina.net.wssession",
        functionName = "getId",
        args = {@Argument(name = "session", type = TypeEnum.STRUCT, structType = "Session",
                          structPackage = "ballerina.net.wssession")},
        returnType = {@ReturnType(type = TypeEnum.STRING)},
        isPublic = true
)
@BallerinaAnnotation(annotationName = "Description",
                     attributes = { @Attribute(name = "value", value = "Give the ID of the required client")})
@BallerinaAnnotation(annotationName = "Param",
                     attributes = {@Attribute(name = "session", value = "WebSocket Session")})
@BallerinaAnnotation(annotationName = "Return",
                     attributes = {@Attribute(name = "string", value = "ID of the given session") })
public class GetId extends AbstractWsSessionNativeFunction {
    @Override
    public BValue[] execute(Context context) {
        BStruct sessionStruct  = ((BStruct) getRefArgument(context, 0));
        return new BValue[]{new BString(getSessionID(sessionStruct))};
    }
}
