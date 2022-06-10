package org.malinowsky.appcodewars.text.align.justify;

import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "AlignJustifyServlet", value = "/AlignJustifyServlet")
public class AlignJustifyServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(MediaType.APPLICATION_XML.equals(req.getContentType())){
            String collect = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            JustifySaxParser dh = new JustifySaxParser();
            saxParser.parse(collect, dh);
        }
    }
}
