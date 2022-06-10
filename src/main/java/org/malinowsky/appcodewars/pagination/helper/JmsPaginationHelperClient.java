package org.malinowsky.appcodewars.pagination.helper;

import lombok.SneakyThrows;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;
import java.util.List;

@ApplicationScoped
public class JmsPaginationHelperClient {
    @Resource(mappedName="java:/jms/queue/PaginationHelperQueue")
    private Queue messaging;

    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext context;

    @SneakyThrows
    public void sendData(Elements elements, long timestamp) {
        JMSProducer producer = context.createProducer();
        ObjectMessage msg = context.createObjectMessage(List.class);
        msg.setLongProperty("startTimestamp", timestamp);
        msg.setIntProperty("size", elements.getSize());
        msg.setIntProperty("pageSize", elements.getPageSize());
        msg.setObject(elements);
        producer.send(messaging, msg);
    }
}
