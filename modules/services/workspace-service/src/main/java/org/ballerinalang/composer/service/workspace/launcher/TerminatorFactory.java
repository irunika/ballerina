/*
 * Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ballerinalang.composer.service.workspace.launcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Launcher Terminator factory.
 */
public class TerminatorFactory {

    private static final Logger logger = LoggerFactory.getLogger(TerminatorFactory.class);

    public Terminator getTerminator(String os, Command command) {

        if (os.equalsIgnoreCase("unix")) {

            return new TerminatorUnix(command);

        } else if (os.equalsIgnoreCase("windows")) {
            return new TerminatorWindows(command);

        } else {
            logger.error("Unknown Operating System");
        }
        return null;
    }
}
