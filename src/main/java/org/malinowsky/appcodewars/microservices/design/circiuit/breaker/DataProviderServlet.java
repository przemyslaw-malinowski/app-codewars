package org.malinowsky.appcodewars.microservices.design.circiuit.breaker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "DataProviderServlet", value = "/DataProviderServlet")
public class DataProviderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(Math.ceil(Math.random() * 1000) % 2 == 0){
            request.setAttribute("value", null);
            System.out.println("System failed down");
            return;
        }
        request.setAttribute("value", "Calculated data" + new Date().getTime());
    }
}
