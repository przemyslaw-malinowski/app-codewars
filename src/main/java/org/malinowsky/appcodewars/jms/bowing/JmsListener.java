package org.malinowsky.appcodewars.jms.bowing;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/LolQueue"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
        },
        mappedName = "java:/jms/queue/LolQueue"
)
public class JmsListener implements MessageListener {
    @EJB
    JmsRetriever retriever;

    @Override
    public void onMessage(Message message) {
        try {
            String body = message.getBody(String.class);
            System.out.println("Incoming message" + body);
            retriever.add(new Date() + ": " + body);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
