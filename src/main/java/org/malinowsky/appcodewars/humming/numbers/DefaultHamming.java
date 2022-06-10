package org.malinowsky.appcodewars.humming.numbers;

import java.util.function.Supplier;
import java.util.stream.LongStream;

import static org.malinowsky.appcodewars.humming.numbers.HammingImplementation.HammingType.DEFAULT;

@HammingImplementation(value = DEFAULT)
public class DefaultHamming implements Hamming {
    private long[] elements;

    private long[] initialize() {
        Supplier<LongStream> int2 = () -> LongStream.range(0, 64).map(i -> (long) Math.pow(2, i));
        Supplier<LongStream> int3 = () -> LongStream.range(0, 64).map(i -> (long) Math.pow(3, i));
        Supplier<LongStream> int5 = () -> LongStream.range(0, 64).map(i -> (long) Math.pow(5, i));

        return int2.get()
                .flatMap(i -> int3.get().flatMap(j -> int5.get().map(k -> i * j * k)))
                .filter(p -> p > 0)
                .distinct()
                .sorted()
                .toArray();
    }

    public long hamming(int n) {
        if(elements == null) {
            elements = initialize();
        }
        return elements[n-1];
    }
}
