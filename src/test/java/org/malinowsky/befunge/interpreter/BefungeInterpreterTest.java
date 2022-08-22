package org.malinowsky.befunge.interpreter;

import org.junit.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class BefungeInterpreterTest {
    @Test
    public void shouldWork() {
        //GIVEN
        //WHEN
        System.out.println(new BefungeInterpreter().interpret(">987v>.v\nv456<  :\n>321 ^ _@"));
        //THEN
    }

    @Test
    public void shouldWorkHelloWorld() {
        //GIVEN
        String code =
                ">25*\"!dlroW olleH\":v\n" +
                "                v:,_@\n" +
                "                >  ^";
        //WHEN
        System.out.println(new BefungeInterpreter().interpret(code));
        //THEN
    }

    @Test
    public void shouldWorkFactorial() {
        //GIVEN
        String code =
                "08>:1-:v v *_$.@ \n" +
                "  ^    _$>\\:^  ^    _$>\\:^";
        //WHEN
        System.out.println(new BefungeInterpreter().interpret(code));
        //THEN
    }

    @Test
    public void shouldWorkRandomDirection() {
        //GIVEN
        String code =
                "v@.<\n" +
                " >1^\n" +
                ">?<^\n" +
                " >2^";
        //WHEN
        System.out.println(new BefungeInterpreter().interpret(code));
        //THEN
    }

    @Test
    public void shouldWorkQuine() {
        //GIVEN
        String code = "01->1# +# :# 0# g# ,# :# 5# 8# *# 4# +# -# _@";
        //WHEN
        System.out.println(new BefungeInterpreter().interpret(code));
        //THEN
    }

    @Test
    public void shouldWorkSieve() {
        //GIVEN
        String code =
                "2>:3g\" \"-!v\\  g30          <\n" +
                " |!`\"&\":+1_:.:03p>03g+:\"&\"`|\n" +
                " @               ^  p3\\\" \":<";
        //WHEN
        System.out.println(new BefungeInterpreter().interpret(code));
        //THEN
    }

    @Test
    public void name() {
        Random rand = new Random();
        IntStream.range(1, 30).forEach(t -> System.out.println(rand.nextInt(4)));
    }
}