package org.malinowsky.appcodewars.text.align.justify;

import org.malinowsky.appcodewars.text.align.justify.jpa.JustifyHistory;
import org.malinowsky.appcodewars.text.align.justify.xml.input.Justify;
import org.malinowsky.appcodewars.text.align.justify.xml.output.ResponseWrapper;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("align-justify")
public class AlignJustifyApi {

    @Inject
    JustificationProcessor processor;

    @POST
    @Consumes("application/xml")
    public Response postXml(Justify justify, @CookieParam("keyyy") Cookie cookie) {
        if(cookie != null) {
            System.out.println("Ok, I went there few days ago");
        }

        String id = processor.process(justify);

        return Response
                .ok()
                .entity(id)
                .build();
    }

    @GET
    @Produces("application/xml")
    public Response get(@QueryParam("id") String uuid) {
        List<JustifyHistory> elements = processor.getByUuid(uuid);

        return Response
                .ok()
                .entity(new ResponseWrapper().wrap(elements))
                .build();
    }
}
