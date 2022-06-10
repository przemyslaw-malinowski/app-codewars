package org.malinowsky.appcodewars.jms.bowing;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@LocalBean
@Singleton
public class JmsRetriever {
    List<String> elements = new ArrayList<>();

    public void add(String message) {
        elements.add(message);
    }
    public String get() {
        return elements.stream().reduce("", (q, p) -> q + p + "<br/>");
    }
}
