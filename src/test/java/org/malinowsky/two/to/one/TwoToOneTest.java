package org.malinowsky.two.to.one;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoToOneTest {
    @Test
    public void shouldWorkEasyScenario() {
        //GIVEN
        String a = "xxxxxdddddd";
        String b = "xdxdxdxdxdxd";

        //WHEN
        String longest = TwoToOne.longest(a, b);

        //THEN
        assertEquals("Are not equals: ", longest, "dx");
    }

    @Test
    public void shouldWorkSunnyDayScenario() {
        //GIVEN
        String a = "xyaabbbccccdefww";
        String b = "xxxxyyyyabklmopq";

        //WHEN
        String longest = TwoToOne.longest(a, b);

        //THEN
        assertEquals("Are not equals: ", longest, "abcdefklmopqwxy");
    }

    @Test
    public void shouldWorkWhenTwoElementsAreEquals() {
        //GIVEN
        String a = "abcdefghijklmnopqrstuvwxyz";

        //WHEN
        String longest = TwoToOne.longest(a, a);

        //THEN
        assertEquals("Are not equals: ", longest, "abcdefghijklmnopqrstuvwxyz");
    }
}