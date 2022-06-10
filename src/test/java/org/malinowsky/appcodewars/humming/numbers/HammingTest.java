package org.malinowsky.appcodewars.humming.numbers;

import org.junit.Test;

import javax.json.Json;
import javax.json.stream.JsonGenerator;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class HammingTest {

    @Test
    public void name() {
        StringWriter writer = new StringWriter();
        JsonGenerator g = Json.createGenerator(writer);
        g.writeStartObject();
        g.writeEnd();
        g.flush();
        System.out.println(writer);
    }

    @Test
    public void Test1() {
        assertEquals("hamming(1) should be 1", 1, new DefaultHamming().hamming(1));
        assertEquals("hamming(2) should be 2", 2, new DefaultHamming().hamming(2));
        assertEquals("hamming(3) should be 3", 3, new DefaultHamming().hamming(3));
        assertEquals("hamming(4) should be 4", 4, new DefaultHamming().hamming(4));
        assertEquals("hamming(5) should be 5", 5, new DefaultHamming().hamming(5));
        assertEquals("hamming(6) should be 6", 6, new DefaultHamming().hamming(6));
        assertEquals("hamming(7) should be 8", 8, new DefaultHamming().hamming(7));
        assertEquals("hamming(8) should be 9", 9, new DefaultHamming().hamming(8));
        assertEquals("hamming(9) should be 10", 10, new DefaultHamming().hamming(9));
        assertEquals("hamming(10) should be 12", 12, new DefaultHamming().hamming(10));
        assertEquals("hamming(11) should be 15", 15, new DefaultHamming().hamming(11));
        assertEquals("hamming(12) should be 16", 16, new DefaultHamming().hamming(12));
        assertEquals("hamming(13) should be 18", 18, new DefaultHamming().hamming(13));
        assertEquals("hamming(14) should be 20", 20, new DefaultHamming().hamming(14));
        assertEquals("hamming(15) should be 24", 24, new DefaultHamming().hamming(15));
        assertEquals("hamming(16) should be 25", 25, new DefaultHamming().hamming(16));
        assertEquals("hamming(17) should be 27", 27, new DefaultHamming().hamming(17));
        assertEquals("hamming(18) should be 30", 30, new DefaultHamming().hamming(18));
        assertEquals("hamming(19) should be 32", 32, new DefaultHamming().hamming(19));
    }

}