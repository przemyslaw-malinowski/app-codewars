package org.malinowsky.appcodewars.find.the.unknown.digit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunesTest {

    @Test
    public void testSample() {
        Runes runes = new Runes();
        assertEquals( "Answer for expression '1+1=?' " , 2 , runes.solveExpression("1+1=?") );
        assertEquals( "Answer for expression '123*45?=5?088' " , 6 , runes.solveExpression("123*45?=5?088") );
        assertEquals( "Answer for expression '-5?*-1=5?' " , 0 , runes.solveExpression("-5?*-1=5?") );
        assertEquals( "Answer for expression '19--45=5?' " , -1 , runes.solveExpression("19--45=5?") );
        assertEquals( "Answer for expression '??*??=302?' " , 5 , runes.solveExpression("??*??=302?") );
        assertEquals( "Answer for expression '??+??=??' " , -1 , runes.solveExpression("??+??=??") );
        assertEquals( "Answer for expression '?*11=??' " , 2 , runes.solveExpression("?*11=??") );
        assertEquals( "Answer for expression '??*1=??' " , 2 , runes.solveExpression("??*1=??") );
    }

}