package org.malinowsky.appcodewars.java.ee.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@ApplicationScoped
public class CallerExample {

    @Inject
    @Januszek
    private Event<SimpleEvent> event;

    public void call(String id) {
        event.fireAsync(new SimpleEvent(id));
    }
}
