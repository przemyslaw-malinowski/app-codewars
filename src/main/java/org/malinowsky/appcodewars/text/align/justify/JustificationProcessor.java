package org.malinowsky.appcodewars.text.align.justify;

import org.malinowsky.appcodewars.text.align.justify.jpa.JustifyHistory;
import org.malinowsky.appcodewars.text.align.justify.jpa.JustifyHistoryDao;
import org.malinowsky.appcodewars.text.align.justify.xml.input.Justify;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestScoped
public class JustificationProcessor {
    @Inject
    @ComplexProcessing
    private Event<Map.Entry<String, Justify>> processJustify;

    @Inject
    JustifyHistoryDao dao;

    public String process(Justify justify){
        String uuid = UUID.randomUUID().toString();
        processJustify.fireAsync(new AbstractMap.SimpleEntry<>(uuid, justify));
        return uuid;
    }

    public List<JustifyHistory> getByUuid(String uuid) {
        return dao.getByUuid(uuid);
    }
}

