package org.malinowsky.roman.numerals;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RomanNumerals {
    public static String toRoman(int n) {
        int num = n;
        int[] number = new int[4];
        int p = 0;
        for(int i = 1000; i > 0; i /= 10) {
            number[p] = num / i;
            num -= i * number[p];
            p += 1;
            System.out.println(num);
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 4; i++) {
            if(i == 0) {
                if(number[i] == 0) {
                    continue;
                }
                
            }
        }

        return "I";
    }

    public static int fromRoman(String romanNumeral) {
        return 1;
    }
}
