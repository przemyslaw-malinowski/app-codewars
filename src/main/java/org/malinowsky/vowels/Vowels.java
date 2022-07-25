package org.malinowsky.vowels;

import java.util.stream.Collectors;

public class Vowels {

    public static int getCount(String str) {
        return str
                .chars()
                .filter(
                        "aeiou"
                                .chars()
                                .boxed()
                                .collect(Collectors.toSet())::contains)
                .toArray()
                .length;
    }

}
