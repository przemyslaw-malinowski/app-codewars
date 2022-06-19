package org.malinowsky.strip.comments;

import org.junit.Test;

import static org.junit.Assert.*;

public class StripCommentsTest {
    @Test
    public void stripComments() throws Exception {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );
    }

    @Test
    public void stripComments2() throws Exception {
//        assertEquals(
//                "apples, pears\ngrapes\nbananas",
//                StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
//        );
//
//        assertEquals(
//                "a\nc\nd",
//                StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
//        );
        System.out.println(StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } ));
    }
}