package org.malinowsky.appcodewars.beans.greed.is.good;

import org.junit.Test;

import static org.junit.Assert.*;


public class GreedTest {
    @Test
    public void shouldWork() {
        Greed greed = new Greed();
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, greed.greedy(new int[]{5,1,3,4,1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, greed.greedy(new int[]{1,1,1,3,1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, greed.greedy(new int[]{2,4,4,5,4}));
    }
}