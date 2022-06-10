package org.malinowsky.sum.util;

import org.junit.Test;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.StringReader;
import java.util.Objects;

import static javax.json.stream.JsonParser.Event.KEY_NAME;

public class JsonParserTest {
    @Test
    public void name() {
        KeysStatuses status = new KeyStatusesJsonParser().retrieve(invalidJson);
        System.out.println(KeyStatusesUtil.isFullyValid(status));
    }

    @Test
    public void sss() {
        Object[] l11 = new Object[] { 1, 2, new Object[] {1, 2}};
        Object[] lll = new Object[] { 1, 2, new Object[] {1, 2}};

        System.out.println(Objects.deepEquals(l11, lll));
    }

    String validJson = "[\n" +
            "  {\n" +
            "    \"cmgId\": -6197491284442320843,\n" +
            "    \"mobileCount\": 100,\n" +
            "    \"alias\": \"CMG\",\n" +
            "    \"gssi\": 16000000,\n" +
            "    \"gckHandle\": 65010,\n" +
            "    \"tmSckHandle\": 14292,\n" +
            "    \"tmSckOtarEnabled\": true,\n" +
            "    \"dmSckHandle\": 55233,\n" +
            "    \"activeDmSckVersion\": 2,\n" +
            "    \"activeDmSckSubset\": 2,\n" +
            "    \"activeGsko\": {\n" +
            "      \"key\": {\n" +
            "        \"version\": 5,\n" +
            "        \"type\": \"GROUP_OTAR_CK\",\n" +
            "        \"uniqueId\": -6044709591608717825\n" +
            "      },\n" +
            "      \"currency\": 100\n" +
            "    },\n" +
            "    \"inactiveGsko\": {\n" +
            "      \"key\": {\n" +
            "        \"version\": 6,\n" +
            "        \"type\": \"GROUP_OTAR_CK\",\n" +
            "        \"uniqueId\": -6044709590719524612\n" +
            "      },\n" +
            "      \"currency\": 0\n" +
            "    },\n" +
            "    \"activeTmSck\": {\n" +
            "      \"key\": {\n" +
            "        \"number\": 30,\n" +
            "        \"version\": 7,\n" +
            "        \"type\": \"STATIC_CK\",\n" +
            "        \"uniqueId\": -6044709591892901008\n" +
            "      },\n" +
            "      \"currency\": 100\n" +
            "    },\n" +
            "    \"inactiveTmSck\": {\n" +
            "      \"key\": {\n" +
            "        \"number\": 31,\n" +
            "        \"version\": 8,\n" +
            "        \"type\": \"STATIC_CK\",\n" +
            "        \"uniqueId\": -6044709588068457813\n" +
            "      },\n" +
            "      \"currency\": 0\n" +
            "    },\n" +
            "    \"gcks\": {\n" +
            "      \"10\": {\n" +
            "        \"activeGck\": {\n" +
            "          \"key\": {\n" +
            "            \"number\": 10,\n" +
            "            \"version\": 5,\n" +
            "            \"type\": \"GROUP_CK\",\n" +
            "            \"uniqueId\": -6044709591567491550\n" +
            "          },\n" +
            "          \"currency\": 100\n" +
            "        },\n" +
            "        \"inactiveGck\": {\n" +
            "          \"key\": {\n" +
            "            \"number\": 10,\n" +
            "            \"version\": 6,\n" +
            "            \"type\": \"GROUP_CK\",\n" +
            "            \"uniqueId\": -6044709590792120730\n" +
            "          },\n" +
            "          \"currency\": 0\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"kags\": [\n" +
            "      {\n" +
            "        \"sckn\": 0,\n" +
            "        \"dmScks\": [\n" +
            "          {\n" +
            "            \"key\": {\n" +
            "              \"number\": 0,\n" +
            "              \"version\": 2,\n" +
            "              \"type\": \"STATIC_DM_CK\",\n" +
            "              \"uniqueId\": -6044709588474740900\n" +
            "            },\n" +
            "            \"currency\": 100\n" +
            "          },\n" +
            "          {\n" +
            "            \"key\": {\n" +
            "              \"number\": 10,\n" +
            "              \"version\": 2,\n" +
            "              \"type\": \"STATIC_DM_CK\",\n" +
            "              \"uniqueId\": -6044709588262912501\n" +
            "            },\n" +
            "            \"currency\": 100\n" +
            "          },\n" +
            "          {\n" +
            "            \"key\": {\n" +
            "              \"number\": 20,\n" +
            "              \"version\": 2,\n" +
            "              \"type\": \"STATIC_DM_CK\",\n" +
            "              \"uniqueId\": -6044709591077760896\n" +
            "            },\n" +
            "            \"currency\": 0\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]\n";

    String invalidJson = "[\n" +
            "  {\n" +
            "    \"cmgId\": -6197491283915855240,\n" +
            "    \"mobileCount\": 100,\n" +
            "    \"alias\": \"CMG\",\n" +
            "    \"gssi\": 16000000,\n" +
            "    \"gckHandle\": 46341,\n" +
            "    \"tmSckHandle\": 64996,\n" +
            "    \"tmSckOtarEnabled\": true,\n" +
            "    \"dmSckHandle\": 620,\n" +
            "    \"activeDmSckVersion\": 2,\n" +
            "    \"activeDmSckSubset\": 1,\n" +
            "    \"activeGsko\": {\n" +
            "      \"key\": {\n" +
            "        \"version\": 4,\n" +
            "        \"type\": \"GROUP_OTAR_CK\",\n" +
            "        \"uniqueId\": -6044709588736805298\n" +
            "      },\n" +
            "      \"currency\": 0\n" +
            "    },\n" +
            "    \"inactiveGsko\": {\n" +
            "      \"key\": {\n" +
            "        \"version\": 5,\n" +
            "        \"type\": \"GROUP_OTAR_CK\",\n" +
            "        \"uniqueId\": -6044709591863358958\n" +
            "      },\n" +
            "      \"currency\": 0\n" +
            "    },\n" +
            "    \"activeTmSck\": {\n" +
            "      \"key\": {\n" +
            "        \"number\": 31,\n" +
            "        \"version\": 6,\n" +
            "        \"type\": \"STATIC_CK\",\n" +
            "        \"uniqueId\": -6044709589114696625\n" +
            "      },\n" +
            "      \"currency\": 0\n" +
            "    },\n" +
            "    \"inactiveTmSck\": {\n" +
            "      \"key\": {\n" +
            "        \"number\": 30,\n" +
            "        \"version\": 7,\n" +
            "        \"type\": \"STATIC_CK\",\n" +
            "        \"uniqueId\": -6044709591381569215\n" +
            "      },\n" +
            "      \"currency\": 0\n" +
            "    },\n" +
            "    \"gcks\": {\n" +
            "      \"10\": {\n" +
            "        \"activeGck\": {\n" +
            "          \"key\": {\n" +
            "            \"number\": 10,\n" +
            "            \"version\": 4,\n" +
            "            \"type\": \"GROUP_CK\",\n" +
            "            \"uniqueId\": -6044709588801791276\n" +
            "          },\n" +
            "          \"currency\": 0\n" +
            "        },\n" +
            "        \"inactiveGck\": {\n" +
            "          \"key\": {\n" +
            "            \"number\": 10,\n" +
            "            \"version\": 5,\n" +
            "            \"type\": \"GROUP_CK\",\n" +
            "            \"uniqueId\": -6044709590074789308\n" +
            "          },\n" +
            "          \"currency\": 0\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"kags\": [\n" +
            "      {\n" +
            "        \"sckn\": 0,\n" +
            "        \"dmScks\": [\n" +
            "          {\n" +
            "            \"key\": {\n" +
            "              \"number\": 0,\n" +
            "              \"version\": 2,\n" +
            "              \"type\": \"STATIC_DM_CK\",\n" +
            "              \"uniqueId\": -6044709590872395754\n" +
            "            },\n" +
            "            \"currency\": 0\n" +
            "          },\n" +
            "          {\n" +
            "            \"key\": {\n" +
            "              \"number\": 10,\n" +
            "              \"version\": 2,\n" +
            "              \"type\": \"STATIC_DM_CK\",\n" +
            "              \"uniqueId\": -6044709587930429431\n" +
            "            },\n" +
            "            \"currency\": 0\n" +
            "          },\n" +
            "          {\n" +
            "            \"key\": {\n" +
            "              \"number\": 20,\n" +
            "              \"version\": 1,\n" +
            "              \"type\": \"STATIC_DM_CK\",\n" +
            "              \"uniqueId\": -6044709590700646956\n" +
            "            },\n" +
            "            \"currency\": 0\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]\n";
}


