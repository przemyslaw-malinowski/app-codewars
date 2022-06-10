package org.malinowsky.appcodewars.humming.numbers;

import lombok.SneakyThrows;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.List;
import java.util.stream.Collectors;

import static org.malinowsky.appcodewars.humming.numbers.HammingImplementation.HammingType.DEFAULT;


@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topics/HammingProcessorListener"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
        },
        mappedName = "java:/jms/topics/HammingProcessorListener"
)
public class JMSDefaultHammingProcessorListener implements MessageListener {

    @Inject
    @HammingImplementation(DEFAULT)
    private Hamming defaultHamming;

    @Inject
    private HammingsResponsesHandler responsesHandler;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        String id = message.getJMSCorrelationID();
        List<Integer> body = message.getBody(List.class);
        System.out.println("Melduje się " + this.getClass().getSimpleName() + ": " + body);
        List<Long> elements = body.stream().map(defaultHamming::hamming).collect(Collectors.toList());
        responsesHandler.addResponse(id, "default", elements);
        System.out.println("Default: Job done!");
    }
}
