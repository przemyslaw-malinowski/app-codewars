package org.malinowsky.strip.comments;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        Pattern pattern = Pattern.compile(String.format("(\\s*[%s]{1}.*$)|(\\s*$)", String.join("", commentSymbols)));
        return String.join(
                "\n",
                Stream
                .of(text.split("\n"))
                .map(subtext -> pattern.matcher(subtext).replaceAll(""))
                .collect(Collectors.toList()));
    }
}
