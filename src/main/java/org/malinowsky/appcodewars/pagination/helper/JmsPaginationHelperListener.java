package org.malinowsky.appcodewars.pagination.helper;

import lombok.SneakyThrows;
import org.malinowsky.appcodewars.pagination.helper.Elements;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;


@ApplicationScoped
@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/PaginationHelperQueue"),
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
        },
        mappedName = "java:/jms/queue/PaginationHelperQueue"
)
public class JmsPaginationHelperListener implements MessageListener {
    @Inject
    PaginationHelper paginationHelper;

    @Inject
    ResponseHolder responseHolder;

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        long timestamp = message.getLongProperty("startTimestamp");
        int size = message.getIntProperty("size");
        int pageSize = message.getIntProperty("pageSize");
        Elements body = message.getBody(Elements.class);

        paginationHelper.set(body.getElements(), pageSize);

        StringWriter sw = new StringWriter();
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            XMLStreamWriter writer = factory.createXMLStreamWriter(sw);
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("response");
            writer.writeStartElement("collection-size");
            writer.writeCharacters(size + "");
            writer.writeEndElement();
            writer.writeStartElement("page-size");
            writer.writeCharacters(pageSize + "");
            writer.writeEndElement();
            writer.writeStartElement("pages-number");
            writer.writeCharacters(paginationHelper.pageCount() + "");
            writer.writeEndElement();
            writer.writeEndElement();
            writer.flush();
            writer.close();
            Thread.sleep(20 * 1000);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        responseHolder.add(timestamp, sw.toString());
    }
}
