package org.malinowsky.appcodewars.jms.bowing;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/jms/")
public class JmsExample {
    @EJB
    private JmsClient jmsClient;

    @EJB
    private JmsRetriever jmsRetriever;

    @GET
    @Path("/send/{message}")
    public String sendMessage(@PathParam("message") String message){
        jmsClient.send(message);
        return "Message " + message + " is sent";
    }

    @GET
    @Path("/get-list")
    @Produces("text/plain")
    public String getMessages() {
        return jmsRetriever.get();
    }
}
