package org.malinowsky.appcodewars.pagination.helper;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ResponseHolder {
    private Map<Long, String> responses = new HashMap<>();

    public void add(Long id, String response){
        responses.put(id, response);
    }

    public String get(Long id) {
        return responses.get(id);
    }

    public boolean isResponse(Long id) {
        return responses.containsKey(id);
    }
}
