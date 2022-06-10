package org.malinowsky.appcodewars.text.align.justify;

import org.malinowsky.appcodewars.text.align.justify.jpa.JustifyHistory;
import org.malinowsky.appcodewars.text.align.justify.jpa.JustifyHistoryDao;
import org.malinowsky.appcodewars.text.align.justify.xml.input.Justify;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class JustificationEventHandler {
    @Inject
    private TextAlignTool textAlignTool;

    @Inject
    JustifyHistoryDao justifyHistoryDao;

    @PostConstruct
    public void createBean() {
        System.out.println(this.getClass().getSimpleName() + ": I AM IN");
    }

    public void handleEventAsync(@ObservesAsync @Priority(100) Map.Entry<String, Justify> e) {
        List<JustifyHistory> histories =
                e.getValue()
                        .getInputs()
                        .getInput()
                        .stream()
                        .map(s -> textAlignTool.justify(s.getContent(), s.getWidth()))
                        .map(string -> new JustifyHistory(e.getKey(), string))
                        .collect(Collectors.toList());

        //justifyHistoryDao.create(histories);
        justifyHistoryDao.createAnother(histories);
    }
}
