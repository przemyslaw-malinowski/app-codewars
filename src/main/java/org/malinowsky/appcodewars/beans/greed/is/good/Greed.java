package org.malinowsky.appcodewars.beans.greed.is.good;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SessionScoped
public class Greed implements Serializable {
    public int greedy(int[] dice){
        return IntStream
                .of(dice)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()))
                .entrySet()
                .stream()
                .peek(this::processPoints)
                .map(Map.Entry::getValue)
                .map(Long::intValue)
                .reduce(0, Integer::sum);
    }

    private void processPoints(Map.Entry<Integer, Long> e) {
        long sum;
        int key = e.getKey();
        long number = e.getValue();

        if (key == 1) {
            long t1 = number / 3;
            long t2 = number % 3;
            sum = t1 * 1000 + t2 * 100;
            e.setValue(sum);
        }

        if (key == 6) {
            e.setValue(number / 3 * 600);
        }

        if (key == 5) {
            long t1 = number / 3;
            long t2 = number % 3;
            sum = t1 * 500 + t2 * 50;
            e.setValue(sum);
        }

        if (key == 4) {
            e.setValue(number / 3 * 400);
        }

        if (key == 3) {
            e.setValue(number / 3 * 300);
        }

        if (key == 2) {
            e.setValue(number / 3 * 200);
        }
    }
}
