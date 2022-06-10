package org.malinowsky.appcodewars.microservices.design.api.gateway;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApiGatewayServlet", value = "/ApiGatewayServlet", asyncSupported = true)
public class ApiGatewayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AsyncContext asyncContext = request.startAsync();
        asyncContext.start( () -> {
            try {
                RequestDispatcher requestDispatcher = asyncContext.getRequest().getRequestDispatcher("/ServiceAServlet");
                RequestDispatcher requestDispatcher2 = asyncContext.getRequest().getRequestDispatcher("/ServiceBServlet");
                requestDispatcher.include(request, response);
                requestDispatcher2.include(request, response);
                asyncContext
                        .getResponse()
                        .getWriter()
                        .printf("Response: %s, %s",
                                request.getAttribute("returnA"),
                                request.getAttribute("returnB"));
                asyncContext.complete();
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
