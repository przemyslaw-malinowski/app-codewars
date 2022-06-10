package org.malinowsky.appcodewars.humming.numbers;

import lombok.SneakyThrows;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.List;
import java.util.stream.Collectors;

import static org.malinowsky.appcodewars.humming.numbers.HammingImplementation.HammingType.BETTER;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/topics/HammingProcessorListener"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
        },
        mappedName = "java:/jms/topics/HammingProcessorListener"
)
public class JMSBetterHammingProcessorListener implements MessageListener {

    @Inject
    @HammingImplementation(BETTER)
    private Hamming betterHamming;

    @Inject
    private HammingsResponsesHandler responsesHandler;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        String id = message.getJMSCorrelationID();
        List<Integer> body = message.getBody(List.class);
        System.out.println("Melduje się " + this.getClass().getSimpleName() + ": " + body);
        List<Long> elements = body.stream().map(betterHamming::hamming).collect(Collectors.toList());
        responsesHandler.addResponse(id, "better", elements);
        System.out.println("Better: Job done!");
    }
}
