/*
 * BefungeIntrepreter
 *
 * © 2022 MOTOROLA SOLUTIONS INC., ALL RIGHTS RESERVED
 *
 * The copyright to the computer program(s) herein is the property of Motorola Inc.
 * The programs may be used or copied only with the written permission of Motorola Inc.
 *
 * Motorola Internal Use Only
 */
package org.malinowsky.befunge.interpreter;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class BefungeInterpreter {
    private boolean isStringMode;

    enum Direction {
        RIGHT,
        LEFT,
        UP,
        DOWN,
        EMPTY;

        public static Direction getRandom() {
            Random random = new Random();
            switch(random.nextInt(4)) {
                case 0: return Direction.LEFT;
                case 1: return Direction.RIGHT;
                case 2: return Direction.UP;
                case 3: return Direction.DOWN;
            }
            return null;
        }
    }

    private Deque<Integer> stack = new LinkedList<>();

    private Character[][] commands;
    private Direction direction = Direction.RIGHT;

    private String output = "";
    private int x = 0;
    private int y = 0;

    public String interpret(String code) {
        System.out.println("Input: ");
        System.out.println(code);
        parseInput(code);
        runApplication();
        return output;
    }

    private void runApplication() {

        boolean endProgram = false;
        while(!endProgram) {
            printTable();
            if(isStringMode){
                if(commands[y][x] != '\"') {
                    stack.push((int) commands[y][x]);
                } else {
                    isStringMode = false;
                }
            } else {
                switch (commands[y][x]) {
                    case '\"':
                        stringMode();
                        break;

                    case '>':
                        direction = Direction.RIGHT;
                        break;
                    case '<':
                        direction = Direction.LEFT;
                        break;
                    case '^':
                        direction = Direction.UP;
                        break;
                    case 'v':
                        direction = Direction.DOWN;
                        break;

                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        stack.push(Character.getNumericValue(commands[y][x]));
                        break;

                    case '+':
                        addition();
                        break;

                    case '-':
                        subtraction();
                        break;

                    case '*':
                        multiplication();
                        break;

                    case '/':
                        integerDivision();
                        break;

                    case '%':
                        modulo();
                        break;

                    case '?':
                        randomDirection();
                        break;

                    case '!':
                        logicalNot();
                        break;

                    case '`':
                        greaterThan();
                        break;

                    case '.':
                        popAndOutput();
                        break;

                    case ',':
                        popAndOutputAsASCII();
                        break;

                    case '_':
                        popAndMoveHorizontally();
                        break;

                    case '|':
                        popAndMoveVertically();
                        break;

                    case ':':
                        duplicateTop();
                        break;

                    case '\\':
                        swapTop();
                        break;

                    case 'g':
                        get();
                        break;

                    case '$':
                        discard();
                        break;

                    case '#':
                        skip();
                        break;

                    case '@':
                        endProgram = true;
                        break;
                }
            }
            move(direction);
        }

    }

    private void randomDirection() {
        direction = Direction.getRandom();
    }

    private void stringMode() {
        isStringMode = true;
    }

    private void putCall(){
        Integer y = stack.pop();
        Integer x = stack.pop();
        Integer v = stack.pop();

        commands[y][x] = (char) (int) v;
    }

    private void skip() {
        move(direction);
    }

    private void get() {
        Integer y = stack.pop();
        Integer x = stack.pop();
        stack.push((int) commands[y][x]);
    }

    private void popAndOutputAsASCII() {
        Integer a = stack.pop();
        output += (char)(int) a;
    }

    private void swapTop() {
        Integer a = stack.pop();
        Integer b = !stack.isEmpty() ? stack.pop() : 0;
        stack.push(a);
        stack.push(b);
    }

    private void discard() {
        stack.removeFirst();
    }

    private void printTable() {
        int xToPrint = 0;
        int yToPrint = 0;
        System.out.println("\n\n");
        for(int yi = 0; yi < commands.length; yi++) {
            for(int xi = 0; xi < commands[yi].length; xi++) {
                try {
                    System.out.printf((x != xi || y != yi) ? " %s \t" : "[%s]\t", commands[yi][xi]);
                } catch (Exception e) {
                    System.out.println(yi + " " + xi);
                    e.printStackTrace();
                }
                if(x == xi || y == yi) {
                    xToPrint = x;
                    yToPrint = y;
                }
            }
            System.out.println();
        }
        System.out.printf("Position:\n[%s][%s]\n", yToPrint, xToPrint);
        System.out.printf("Stack:\n[%s]\n\n", stack.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    private void duplicateTop() {
        Integer a = stack.peek();
        stack.push(a == null ? 0 : a);
    }

    private void popAndMoveVertically() {
        Integer value = !stack.isEmpty() ? stack.pop() : 0;
        direction = value == 0 ? Direction.DOWN : Direction.UP;
    }

    private void popAndMoveHorizontally() {
        Integer value = !stack.isEmpty() ? stack.pop() : 0;
        direction = value == 0 ? Direction.RIGHT : Direction.LEFT;
    }

    private void popAndOutput() {
        Integer a = stack.pop();
        output += a;
    }

    private void logicalNot() {
        Integer a = stack.pop();
        stack.push(a == 0 ? 1 : 0);
    }

    private void greaterThan() {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(b > a ? 1 : 0);
    }

    private void modulo() {
        Integer a = stack.pop();
        Integer b = stack.pop();
        if(a == 0) {
            stack.push(0);
        }

        stack.push(b % a);
    }

    private void integerDivision() {
        Integer a = stack.pop();
        Integer b = stack.pop();
        if(a == 0) {
            stack.push(0);
        }

        stack.push(Math.floorDiv(b,a));
    }

    private void multiplication() {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(a * b);
    }

    private void subtraction() {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(b - a);
    }

    private void addition() {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(a + b);
    }

    private void move(Direction direction) {
        switch(direction) {
            case LEFT:
                x -= 1;
                break;
            case RIGHT:
                x += 1;
                break;
            case UP:
                y -= 1;
                break;
            case DOWN:
                y += 1;
                break;
        }
    }

    private void parseInput(String code) {
        commands = Arrays
                .stream(code.split("\\n"))
                .map(t -> t
                        .chars()
                        .mapToObj(i -> (char) i)
                        .toArray(Character[]::new))
                .toArray(Character[][]::new);
    }

}
