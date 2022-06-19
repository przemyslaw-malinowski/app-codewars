package org.malinowsky.reversed.string;

public class Kata {

    public static String solution(String str) {
        // Your code here...
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("dupa"));
    }

}
