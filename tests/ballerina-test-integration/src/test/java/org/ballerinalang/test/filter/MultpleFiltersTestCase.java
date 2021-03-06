/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.ballerinalang.test.filter;

import io.netty.handler.codec.http.HttpHeaderNames;
import org.ballerinalang.test.IntegrationTestCase;
import org.ballerinalang.test.context.ServerInstance;
import org.ballerinalang.test.util.HttpClientRequest;
import org.ballerinalang.test.util.HttpResponse;
import org.ballerinalang.test.util.TestConstant;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Test cases for verifying multiple http filters for a service.
 */
public class MultpleFiltersTestCase extends IntegrationTestCase {

    private ServerInstance ballerinaServer;

    @Test(description = "Single filter execution success case")
    public void testMultipleFiltersSuccess() throws Exception {
        try {
            String relativePath = new File("src" + File.separator + "test" + File.separator + "resources"
                    + File.separator + "filter" + File.separator +
                    "multiple-filters-execution-sucess-test.bal").getAbsolutePath();
            startServer(relativePath);
            Map<String, String> headers = new HashMap<>();
            headers.put(HttpHeaderNames.CONTENT_TYPE.toString(), TestConstant.CONTENT_TYPE_TEXT_PLAIN);
            HttpResponse response = HttpClientRequest.doGet(ballerinaServer
                    .getServiceURLHttp("echo/test"), headers);
            Assert.assertNotNull(response);
            Assert.assertEquals(response.getResponseCode(), 200, "Response code mismatched");
        } finally {
            ballerinaServer.stopServer();
        }
    }

    @Test(description = "Single filter execution failure case")
    public void testMultipleFiltersFailureFromLast() throws Exception {
        try {
            String relativePath = new File("src" + File.separator + "test" + File.separator + "resources"
                    + File.separator + "filter" + File.separator +
                    "multipler-filters-execution-failure-from-last-test.bal").getAbsolutePath();
            startServer(relativePath);
            Map<String, String> headers = new HashMap<>();
            headers.put(HttpHeaderNames.CONTENT_TYPE.toString(), TestConstant.CONTENT_TYPE_TEXT_PLAIN);
            HttpResponse response = HttpClientRequest.doGet(ballerinaServer
                    .getServiceURLHttp("echo/test"), headers);
            Assert.assertNotNull(response);
            Assert.assertEquals(response.getResponseCode(), 403, "Response code mismatched");
        } finally {
            ballerinaServer.stopServer();
        }
    }

    @Test(description = "Single filter execution failure case")
    public void testMultipleFiltersFailureFromMiddle() throws Exception {
        try {
            String relativePath = new File("src" + File.separator + "test" + File.separator + "resources"
                    + File.separator + "filter" + File.separator +
                    "multiple-filters-execution-failure-from-middle-test.bal").getAbsolutePath();
            startServer(relativePath);
            Map<String, String> headers = new HashMap<>();
            headers.put(HttpHeaderNames.CONTENT_TYPE.toString(), TestConstant.CONTENT_TYPE_TEXT_PLAIN);
            HttpResponse response = HttpClientRequest.doGet(ballerinaServer
                    .getServiceURLHttp("echo/test"), headers);
            Assert.assertNotNull(response);
            Assert.assertEquals(response.getResponseCode(), 405, "Response code mismatched");
        } finally {
            ballerinaServer.stopServer();
        }
    }

    @Test(description = "Multiple filter attribute sharing test")
    public void testMultipleFiltersContextSharingTest() throws Exception {
        try {
            String relativePath = new File("src" + File.separator + "test" + File.separator + "resources" + File
                    .separator + "filter" + File.separator + "multiple-filters-attribute-share-test.bal")
                    .getAbsolutePath();
            startServer(relativePath);
            Map<String, String> headers = new HashMap<>();
            headers.put(HttpHeaderNames.CONTENT_TYPE.toString(), TestConstant.CONTENT_TYPE_TEXT_PLAIN);
            HttpResponse response = HttpClientRequest.doGet(ballerinaServer
                    .getServiceURLHttp("echo/test"), headers);
            Assert.assertNotNull(response);
            Assert.assertEquals(response.getResponseCode(), 200, "Response code mismatched");
        } finally {
            ballerinaServer.stopServer();
        }
    }

    private void startServer(String balFile) throws Exception {
        ballerinaServer = ServerInstance.initBallerinaServer();
        ballerinaServer.startBallerinaServer(balFile);
    }

}
