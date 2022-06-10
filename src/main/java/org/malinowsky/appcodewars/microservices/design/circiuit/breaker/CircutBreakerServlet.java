package org.malinowsky.appcodewars.microservices.design.circiuit.breaker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CircutBreakerServlet", value = "/circut-breaker-servlet")
public class CircutBreakerServlet extends HttpServlet {
    Map<String, String> returns = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DataProviderServlet");
        requestDispatcher.include(request, response);
        String value = (String) request.getAttribute("value");
        String id = request.getParameter("id");
        if(value != null) {
            returns.put(id, value);
            System.out.printf("Value has changed in map into: %s", value);
        }
        response.getWriter().printf(returns.get(id));
    }
}
