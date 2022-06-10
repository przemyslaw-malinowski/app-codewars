package org.malinowsky.appcodewars.jms.bowing;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;

@LocalBean
@Singleton
public class JmsClient {
    @Resource(mappedName="java:/jms/queue/LolQueue")
    private Queue messaging;

    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext context;

    public void send(String message) {
        TextMessage textMessage = context.createTextMessage("Bowing with message: " + message);
        context.createProducer().send(messaging, textMessage);
    }
}
