/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.rest.api.service;

import io.gravitee.rest.api.service.impl.configuration.flow.FlowServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Guillaume CUSNIEUX (guillaume.cusnieux at graviteesource.com)
 * @author GraviteeSource Team
 */
@RunWith(MockitoJUnitRunner.class)
public class FlowServiceTest {

    private FlowServiceImpl flowService = new FlowServiceImpl();

    @Test
    public void shouldGetSchema() {
        assertNotNull(flowService.getSchema());
        assertEquals("{\n" +
            "  \"type\": \"object\",\n" +
            "  \"id\": \"apim\",\n" +
            "  \"properties\": {\n" +
            "    \"name\": {\n" +
            "      \"title\": \"Name\",\n" +
            "      \"description\": \"The name of flow. If empty, the name will be generated with the path and methods\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"description\": {\n" +
            "      \"title\": \"Description\",\n" +
            "      \"description\": \"The description of flow\",\n" +
            "      \"type\": \"string\"\n" +
            "    },\n" +
            "    \"path-operator\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"operator\": {\n" +
            "          \"title\": \"Operator path\",\n" +
            "          \"description\": \"The operator path\",\n" +
            "          \"type\": \"string\",\n" +
            "          \"enum\": [\n" +
            "            \"EQUALS\",\n" +
            "            \"STARTS_WITH\"\n" +
            "          ],\n" +
            "          \"default\": \"STARTS_WITH\"\n" +
            "        },\n" +
            "        \"path\": {\n" +
            "          \"title\": \"Path\",\n" +
            "          \"description\": \"The path of flow (must start by /)\",\n" +
            "          \"type\": \"string\",\n" +
            "          \"pattern\": \"^/\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"required\": [\n" +
            "        \"path\",\n" +
            "        \"operator\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"methods\": {\n" +
            "      \"title\": \"Methods\",\n" +
            "      \"description\": \"The HTTP methods of flow (ALL if empty)\",\n" +
            "      \"type\": \"array\",\n" +
            "      \"enum\": [\n" +
            "        \"CONNECT\",\n" +
            "        \"DELETE\",\n" +
            "        \"GET\",\n" +
            "        \"HEAD\",\n" +
            "        \"OPTIONS\",\n" +
            "        \"PATCH\",\n" +
            "        \"POST\",\n" +
            "        \"PUT\",\n" +
            "        \"TRACE\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"condition\": {\n" +
            "      \"title\": \"Condition\",\n" +
            "      \"description\": \"The condition of flow\",\n" +
            "      \"type\": \"string\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"required\": [],\n" +
            "  \"disabled\": []\n" +
            "}\n", flowService.getSchema());
    }

}
