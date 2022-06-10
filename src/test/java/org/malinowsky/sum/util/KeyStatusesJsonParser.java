package org.malinowsky.sum.util;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.StringReader;

import static javax.json.stream.JsonParser.Event.KEY_NAME;

public class KeyStatusesJsonParser {
    public KeysStatuses retrieve(String json) {
        if(json != null && json.isEmpty()){
            throw new IllegalArgumentException("JSON is null or empty");
        }

        KeysStatuses ks = new KeysStatuses();
        StringReader reader = new StringReader(json);
        JsonParser pr = Json.createParser(reader);
        int i = 1;
        while(pr.hasNext()){
            JsonParser.Event next = pr.next();
            if (next == KEY_NAME) {
                String label = pr.getString();
                switch (label) {
                    case "activeGck":
                    case "activeGsko":
                    case "activeTmSck":
                        while (pr.hasNext()) {
                            JsonParser.Event ev = pr.next();
                            if (KEY_NAME.equals(ev) && "currency".equals(pr.getString())) {
                                pr.next();
                                System.out.printf("(%s): %s\n", label, pr.getString());
                                ks.set(label, pr.getInt());
                                break;
                            }
                        }
                        break;
                    case "dmScks":
                        while (pr.hasNext()) {
                            JsonParser.Event ev = pr.next();
                            if (KEY_NAME.equals(ev) && "currency".equals(pr.getString())) {
                                pr.next();
                                System.out.printf("(%s): %s\n", label, pr.getString());
                                ks.set(label, pr.getInt());
                                if (i >= 3) {
                                    break;
                                } else {
                                    i += 1;
                                }
                            }
                        }
                        break;
                }
            }
        }
        return ks;
    }
}
