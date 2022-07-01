package org.malinowsky.roman.numerals;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void shouldWork() {
//        System.out.println(RomanNumerals.toRoman(1666));
        System.out.println(RomanNumerals.fromRoman("MMVIII"));
        System.out.println(RomanNumerals.fromRoman("MCMXC"));
    }
}