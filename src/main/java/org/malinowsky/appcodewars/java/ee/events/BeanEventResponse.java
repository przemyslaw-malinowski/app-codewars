package org.malinowsky.appcodewars.java.ee.events;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class BeanEventResponse {

    @Produces
    @Resource(mappedName = "java:/jboss/snorting/string")
    private String snortString;

    void getResponse(@ObservesAsync @Januszek SimpleEvent event){
        System.out.printf(snortString, event.getData());
    }

    void getResponse2(@ObservesAsync SimpleEvent event){
        System.out.printf("Twoja stara w piecy jara");
    }
}
