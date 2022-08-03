package org.malinowsky.two.to.one;

import static java.util.stream.Collectors.joining;

public class TwoToOne {
    public static String longest (String s1, String s2) {
        return (s1 + s2)
                .chars()
                .distinct()
                .sorted()
                .mapToObj(c -> (char) c)
                .map(Object::toString)
                .collect(joining(""));
    }
}
