package org.malinowsky.appcodewars.pagination.helper;

import lombok.SneakyThrows;
import org.xml.sax.InputSource;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.UNSUPPORTED_MEDIA_TYPE;

@WebServlet(name = "PaginationHelperServlet", value = "/pagination-helper-servlet")
public class PaginationHelperServlet extends HttpServlet {
    @Inject
    JmsPaginationHelperClient jmsClient;

    @Inject
    ResponseHolder responseHolder;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getContentType().equals("application/xml")){
            response.setStatus(UNSUPPORTED_MEDIA_TYPE.getStatusCode());
            return;
        }
        String body =
                request
                        .getReader()
                        .lines()
                        .collect(Collectors.joining(System.lineSeparator()));

        long timestmap = new Date().getTime();
        jmsClient.sendData(getElements(body), timestmap);
        response.setStatus(200);
        response.getWriter().println("Request processed on: " + timestmap);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        if(!responseHolder.isResponse(id)){
            resp.setStatus(200);
            resp.getWriter().println("Request is not done yet");
            return;
        }
        String xml = responseHolder.get(id);
        resp.setStatus(200);
        resp.setContentType("application/xml;charset=UTF-8");
        resp.getWriter().println(xml);
    }

    @SneakyThrows
    private Elements getElements(String body) {
        Elements elements = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ElementsHandler dh = new ElementsHandler();
        parser.parse(new InputSource(new StringReader(body)), dh);
        elements = dh.getElements();
        return elements;
    }
}
