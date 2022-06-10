package org.malinowsky.appcodewars.humming.numbers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class HammingsResponsesHandler {
    private Map<String, Map> responses;

    @PostConstruct
    private void init() {
        System.out.println("Tworzone z RiGCZem");
        responses = new HashMap<>();
    }

    public void addResponse(String id, String alg, List<Long> values){
        if(!responses.containsKey(id)){
            Map<String, List> map = new HashMap<>();
            map.put(alg, values);
            responses.put(id, map);
            return;
        }
        responses.get(id).put(alg, values);
    }

    public Map getResponse(String id) {
        return responses.get(id);
    }
}
