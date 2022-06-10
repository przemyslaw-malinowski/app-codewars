package org.malinowsky.appcodewars.microservices.design.api.gateway;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ServiceBServlet", value = "/ServiceBServlet", asyncSupported = true)
public class ServiceBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.isAsyncStarted()) {
            getResult(request);
            return;
        }
        AsyncContext asyncContext = request.startAsync();
        asyncContext.start(() -> {
            getResult(asyncContext.getRequest());
            asyncContext.complete();
        });
    }

    private void getResult(ServletRequest request) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        request.setAttribute("returnB", "Service B: " + new Date().getTime());
    }
}
