package org.malinowsky.appcodewars.text.align.justify;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TextAlignTool {
    public String justify(String text, int width) {
        String[] array = text.split(" ");
        List<String> partitioned = Arrays
                .stream(array)
                .collect(toStringContainerCollector(width, array.length));
        return partitioned
                .stream()
                .collect(toLineFormatterCollector(width, partitioned.size()))
                .stream()
                .reduce("", (a, b) -> a + ((!Objects.equals(a, "")) ? '\n' : "") + b);
    }

    private LineFormatterCollector toLineFormatterCollector(int width, int collectionSize) {
        return new LineFormatterCollector(width, collectionSize);
    }

    private StringContainerCollector toStringContainerCollector(int width, int collectionSize) {
        return new StringContainerCollector(width, collectionSize);
    }

    private class StringContainerCollector implements Collector<String, List<String>, List<String>> {
        private String actualLine = "";
        private int width;
        private int length;
        private int counter;

        public StringContainerCollector(int width, int length) {
            this.width = width;
            this.length = length;
        }

        @Override
        public Supplier<List<String>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<String>, String> accumulator() {
            return (strings, word) -> {
                String tmpLine = actualLine + getSeparator() + word;

                if(tmpLine.length() <= width) {
                    actualLine = tmpLine;
                } else {
                    strings.add(actualLine);
                    actualLine = word;
                }

                if(counter >= length - 1)
                    strings.add(actualLine);

                counter++;
            };
        }

        private String getSeparator() {
            return actualLine.length() > 0 ? " " : "";
        }

        @Override
        public BinaryOperator<List<String>> combiner() {
            return (a, b) -> a;
        }

        @Override
        public Function<List<String>, List<String>> finisher() {
            return f -> f;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.singleton(Characteristics.UNORDERED);
        }
    }

    private class LineFormatterCollector implements Collector<String, List<String>, List<String>> {
        private int width;
        private int collectionSize;

        public LineFormatterCollector(int width, int collectionSize) {
            this.width = width;
            this.collectionSize = collectionSize;
        }

        @Override
        public Supplier<List<String>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<String>, String> accumulator() {
            return (strings, input) -> {
                //One word row
                if(!input.contains(" ")) {
                    strings.add(input);
                    return;
                }

                if(strings.size() == collectionSize - 1){
                    strings.add(input.replaceAll("\\n", ""));
                    return;
                }

                int numberOfSpaces = width - input.length();
                boolean wasSpace = false;
                List<Character> inpList = input.chars().mapToObj(i -> (char) i).collect(Collectors.toList());
                int p = 0;
                while(numberOfSpaces > 0) {
                    if(p >= inpList.size() - 1) {
                        p = 0;
                    }
                    if(!wasSpace && inpList.get(p) == ' ') {
                        wasSpace = true;
                        inpList.add(p, ' ');
                        numberOfSpaces -= 1;
                    }
                    if(wasSpace && inpList.get(p) != ' ') {
                        wasSpace = false;
                    }
                    p += 1;
                }
                strings.add(inpList.stream().map(String::valueOf).reduce("", (x,y) -> x + y));
            };
        }

        @Override
        public BinaryOperator<List<String>> combiner() {
            return (a, b) -> a;
        }

        @Override
        public Function<List<String>, List<String>> finisher() {
            return f -> f;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.singleton(Characteristics.UNORDERED);
        }
    }

}
