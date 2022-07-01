package org.malinowsky.roman.numerals;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanNumerals {

    private static Map<Integer, String> arabToRoman;
    private static Map<String, Integer> romanToArab;

    static {
        assignMap();
    }

    public static void assignMap() {
        if(arabToRoman != null && romanToArab != null)
            return;

        arabToRoman = new HashMap<>();

        arabToRoman.put(3000, "MMM");
        arabToRoman.put(2000, "MM");
        arabToRoman.put(1000, "M");

        arabToRoman.put(900, "CM");
        arabToRoman.put(800, "DCCC");
        arabToRoman.put(700, "DCC");
        arabToRoman.put(600, "DC");
        arabToRoman.put(500, "D");
        arabToRoman.put(400, "CD");
        arabToRoman.put(300, "CCC");
        arabToRoman.put(200, "CC");
        arabToRoman.put(100, "C");

        arabToRoman.put(90, "XC");
        arabToRoman.put(80, "LXXX");
        arabToRoman.put(70, "LXX");
        arabToRoman.put(60, "LX");
        arabToRoman.put(50, "L");
        arabToRoman.put(40, "XL");
        arabToRoman.put(30, "XXX");
        arabToRoman.put(20, "XX");
        arabToRoman.put(10, "X");

        arabToRoman.put(9, "IX");
        arabToRoman.put(8, "VIII");
        arabToRoman.put(7, "VII");
        arabToRoman.put(6, "VI");
        arabToRoman.put(5, "V");
        arabToRoman.put(4, "IV");
        arabToRoman.put(3, "III");
        arabToRoman.put(2, "II");
        arabToRoman.put(1, "I");
        arabToRoman.put(0, "");

        romanToArab = arabToRoman.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    public static String toRoman(int n) {
        int num = n;
        int[] number = new int[4];
        int p = 0;
        for(int i = 1000; i > 0; i /= 10) {
            number[p] = (num / i) * i;
            num -= number[p];
            p += 1;
        }

        return IntStream
                .of(number)
                .boxed()
                .map(t -> arabToRoman.get(t))
                .collect(Collectors.joining(""));
    }

    public static int fromRoman(String romanNumeral) {
        Deque<String> number = new ArrayDeque<>(Arrays.asList(romanNumeral.split("")));

        String subNumber = "";
        int highestValue = 0;
        int sum = 0;

        while(!number.isEmpty()) {
            subNumber = number.getLast() + subNumber;
            if(romanToArab.containsKey(subNumber)) {
                highestValue = romanToArab.get(subNumber);
                number.pollLast();
            } else {
                sum = sumElements(highestValue, sum);
                subNumber = "";
            }
        }
        return sumElements(highestValue, sum);
    }

    private static int sumElements(int highestValue, int sum) {
        if(highestValue > 0) {
            sum += highestValue;
        }
        return sum;
    }
}
