package org.malinowsky.appcodewars.text.align.justify.xml.output;

import org.malinowsky.appcodewars.text.align.justify.jpa.JustifyHistory;

import java.util.List;
import java.util.stream.IntStream;

public class ResponseWrapper {
    public Response wrap(List<JustifyHistory> history) {
        Response response = new Response();
        Results results = new Results();
        List<Result> resultList = results.getResult();
        IntStream
                .range(1, history.size() + 1)
                .boxed()
                .map(nr -> createResult(history, nr - 1))
                .forEach(resultList::add);
        response.setQuantity(history.size());
        response.setResults(results);
        return response;
    }

    private Result createResult(List<JustifyHistory> history, Integer lp) {
        JustifyHistory hist = history.get(lp);
        Result result = new Result();
        result.setValue(hist.getResult());
        result.setNr(lp);
        return result;
    }
}
