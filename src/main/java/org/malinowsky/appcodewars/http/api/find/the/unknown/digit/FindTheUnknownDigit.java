package org.malinowsky.appcodewars.http.api.find.the.unknown.digit;

import org.jboss.logging.Logger;
import org.malinowsky.appcodewars.find.the.unknown.digit.Runes;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;



import static javax.json.stream.JsonParser.Event.KEY_NAME;
import static javax.json.stream.JsonParser.Event.VALUE_STRING;

@Path("/find-the-unknown-digit")
@Produces("application/json")
public class FindTheUnknownDigit {
    private static final Logger logger = Logger.getLogger(FindTheUnknownDigit.class);

    @Inject
    private Runes runes;

    @POST
    @Consumes("application/json")
    public Response doPost(String body) throws IOException {
        logger.debug("Incoming body: " + body);
        StringReader reader = new StringReader(body);
        JsonParser parser = Json.createParser(reader);
        Properties props = new Properties();

        String actualName = null;
        int actualValue = -1;

        while(parser.hasNext()) {
            JsonParser.Event next = parser.next();
            if (KEY_NAME.equals(next)) {
                actualName = parser.getString();
            }
            if (VALUE_STRING.equals(next)) {
                actualValue = runes.solveExpression(parser.getString());
                props.put(actualName+"-result", actualValue);
            }
        }

        StringWriter sw = new StringWriter();
        JsonGenerator generator = Json.createGenerator(sw);
        generator.writeStartObject();
        props.forEach((key, value) -> generator.write(key.toString(), value.toString()));
        generator.writeEnd();
        generator.flush();

        return Response.ok(sw.toString()).build();
    }
}

