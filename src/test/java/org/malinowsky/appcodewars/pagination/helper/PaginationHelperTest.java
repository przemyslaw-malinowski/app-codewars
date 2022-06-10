package org.malinowsky.appcodewars.pagination.helper;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PaginationHelperTest {

    @Test
    public void shouldWork() {
        //GIVEN
        List<Character> characters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');

        //WHEN
        PaginationHelper<Character> ph = new PaginationHelper<>(characters, 4);

        //THEN
        assertEquals("Items arent equals:", characters.size(), ph.itemCount());
        assertEquals("Items arent equals:", 2, ph.pageCount());

        assertEquals("Items arent equals:", 4, ph.pageItemCount(0));
        assertEquals("Items arent equals:", 2, ph.pageItemCount(1));
        assertEquals("Items arent equals:", -1, ph.pageItemCount(2));

        assertEquals("Items arent equals:", 1, ph.pageIndex(5));
        assertEquals("Items arent equals:", 0, ph.pageIndex(2));
        assertEquals("Items arent equals:", -1, ph.pageIndex(20));
        assertEquals("Items arent equals:", -1, ph.pageIndex(-10));
    }
}