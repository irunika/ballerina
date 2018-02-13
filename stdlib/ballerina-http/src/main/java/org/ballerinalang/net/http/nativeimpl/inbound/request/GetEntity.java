/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.net.http.nativeimpl.inbound.request;

import org.ballerinalang.bre.Context;
import org.ballerinalang.mime.util.Constants;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.Receiver;
import org.ballerinalang.natives.annotations.ReturnType;
import org.ballerinalang.net.http.HttpUtil;

/**
 * Get the 'Entity' of the inbound request with the body.
 *
 * @since 0.96.0
 */
@BallerinaFunction(packageName = "ballerina.net.http",
                   functionName = "getEntity",
                   receiver = @Receiver(type = TypeKind.STRUCT,
                                        structType = "InRequest",
                                        structPackage = "ballerina.net.http"),
                   returnType = { @ReturnType(type = TypeKind.STRUCT),
                                  @ReturnType(type = TypeKind.STRUCT, structType = "EntityBodyError",
                                              structPackage = Constants.PROTOCOL_PACKAGE_MIME) },
                   isPublic = true)
public class GetEntity extends AbstractNativeFunction {
    @Override
    public BValue[] execute(Context context) {
        return getBValues(HttpUtil.getEntity(context, this, true, true));
    }
}
