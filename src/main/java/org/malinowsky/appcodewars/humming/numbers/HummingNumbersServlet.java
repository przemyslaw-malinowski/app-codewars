package org.malinowsky.appcodewars.humming.numbers;

import lombok.SneakyThrows;
import org.xml.sax.InputSource;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.mail.internet.ContentType;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.malinowsky.appcodewars.humming.numbers.HammingImplementation.HammingType.BETTER;
import static org.malinowsky.appcodewars.humming.numbers.HammingImplementation.HammingType.DEFAULT;

@WebServlet(name = "HummingNumbersServlet", value = "/humming-numbers-servlet")
public class HummingNumbersServlet extends HttpServlet {
    public static final String HTTP_WWW_W_3_ORG_1999_XHTML = "http://www.w3.org/1999/xhtml";
    public static final String PREFIX = "h";

    @Inject
    private JMSHammingClient jmsHammingClient;

    @Inject
    private HammingsResponsesHandler responsesHandler;

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(MediaType.APPLICATION_XML.equals(request.getContentType())) {
            XmlHummingHandler handler = new XmlHummingHandler();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            ServletInputStream inputStream = request.getInputStream();
            saxParser.parse(new InputSource(inputStream), handler);

            String msgId = jmsHammingClient.send(handler.getInput());

            response.setContentType(MediaType.TEXT_PLAIN);
            response.setStatus(200);
            response.getWriter().println(msgId);
            return;
        }

//        if(MediaType.APPLICATION_JSON.equals(request.getContentType())) {
//            StringWriter sw = new StringWriter();
//            JsonGenerator jg = Json.createGenerator(sw);
//            jg
//                .writeStartObject()
//                    .writeStartObject("default");
//                    jg.writeEnd()
//                .writeEnd();
//            jg.flush();
//            jg.close();
//            response.setStatus(200);
//            response.setContentType(MediaType.APPLICATION_JSON);
//            response.getWriter().println(sw);
//            return;
//        }

        response.setStatus(415);
        return;
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Map<String, List<Long>> response = responsesHandler.getResponse(id);
        if(response == null) {
            resp.setStatus(404);
            return;
        }
        StringWriter sw = new StringWriter();
        createXmlOutput(response.get("default"), response.get("better"), sw);
        resp.setContentType(MediaType.APPLICATION_XML);
        resp.setStatus(200);
        resp.getWriter().println(sw);
    }

    private void createXmlOutput(List<Long> defaultList, List<Long> betterList, StringWriter sw) throws XMLStreamException {
        XMLOutputFactory streamFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlWriter = streamFactory.createXMLStreamWriter(sw);
        xmlWriter.writeStartDocument();
        xmlWriter.writeStartElement(PREFIX, "body", "http://www.w3.org/1999/xhtml");
        xmlWriter.writeNamespace(PREFIX, HTTP_WWW_W_3_ORG_1999_XHTML);
        xmlWriter.writeStartElement(PREFIX, "h1", HTTP_WWW_W_3_ORG_1999_XHTML);
        xmlWriter.writeCharacters("Default implementation of Hamming numbers:");
        xmlWriter.writeEndElement();
        xmlWriter.writeStartElement(PREFIX, "ul", HTTP_WWW_W_3_ORG_1999_XHTML);
        defaultList.forEach(p -> {
            try {
                xmlWriter.writeStartElement(PREFIX, "li", HTTP_WWW_W_3_ORG_1999_XHTML);
                xmlWriter.writeCharacters(p+"");
                xmlWriter.writeEndElement();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        });
        xmlWriter.writeEndElement();
        xmlWriter.writeStartElement(PREFIX, "h1", HTTP_WWW_W_3_ORG_1999_XHTML);
        xmlWriter.writeCharacters("Better implementation of Hamming numbers:");
        xmlWriter.writeEndElement();
        xmlWriter.writeStartElement(PREFIX, "ul", HTTP_WWW_W_3_ORG_1999_XHTML);
        betterList.forEach(p -> {
            try {
                xmlWriter.writeStartElement(PREFIX, "li", HTTP_WWW_W_3_ORG_1999_XHTML);
                xmlWriter.writeCharacters(p+"");
                xmlWriter.writeEndElement();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        });
        xmlWriter.writeEndElement();
        xmlWriter.writeEndElement();
        xmlWriter.writeEndDocument();
        xmlWriter.flush();
        xmlWriter.close();
    }
}
