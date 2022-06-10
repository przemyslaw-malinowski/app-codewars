package org.malinowsky.appcodewars.http.api.greed.is.good;

import org.malinowsky.appcodewars.beans.greed.is.good.Greed;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Path("/greed-is-good")
public class GreedIsGoodApi {

    @Inject
    private Greed greed;

    @GET
    @Path("/{deck}")
    public Response get(@PathParam("deck") PathSegment ps) {
        int[] ints = ps
                .getMatrixParameters()
                .values()
                .stream()
                .reduce(new ArrayList<>(), (e1, e2) -> {
                    List<String> list = new ArrayList<>();
                    list.addAll(e1);
                    list.addAll(e2);
                    return list;
                })
                .stream()
                .mapToInt(Integer::valueOf)
                .toArray();

        StringWriter sw = new StringWriter();
        generateReturnString(ints, sw);
        return Response.ok(sw.toString()).build();
    }

    private void generateReturnString(int[] ints, StringWriter sw) {
        JsonGenerator generator = Json.createGenerator(sw);
        generator
            .writeStartObject()
                .write("status", "ok")
                .write("result", greed.greedy(ints))
                .writeStartArray("deck");

        IntStream.of(ints).forEach(generator::write);

        generator
                .writeEnd()
                .writeEnd();

        generator.flush();
    }
}
