package org.malinowsky.appcodewars.humming.numbers;

import lombok.SneakyThrows;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class JMSHammingClient {
    @Resource(name = "java:/jms/topics/HammingProcessorListener")
    private Topic hammingTopic;

    @Inject
    @JMSConnectionFactory(value = "java:/ConnectionFactory")
    private JMSContext context;

    @SneakyThrows
    public String send(List<Integer> payload){
        String id = "ID"+UUID.randomUUID().toString();
        JMSProducer producer = context.createProducer();
        ObjectMessage message = context.createObjectMessage();
        message.setObject(new ArrayList<>(payload));
        message.setJMSCorrelationID(id);
        producer.send(hammingTopic, message);
        return id;
    }
}
