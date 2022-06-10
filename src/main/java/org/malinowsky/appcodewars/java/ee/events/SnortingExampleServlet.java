package org.malinowsky.appcodewars.java.ee.events;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "SnortingExampleServlet", value = "/snorting-example-servlet", asyncSupported = true)
public class SnortingExampleServlet extends HttpServlet {
    @Inject
    private CallerExample example;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        AsyncContext ac = request.startAsync();

//        ac.start(() -> {
//            ServletRequest sr = ac.getRequest();
            String id = request.getParameter("id");
            System.out.println(id.toUpperCase(Locale.ROOT));
            example.call(id);
//            ac.complete();
//        });
    }
}
