package org.malinowsky.isograms;

import java.util.Locale;
import java.util.stream.Collectors;

public class Isogram {
    public static boolean isIsogram(String str) {
        return str.toLowerCase().chars().mapToObj(i -> (char) i).collect(Collectors.toSet()).size() == str.length();
    }
}
