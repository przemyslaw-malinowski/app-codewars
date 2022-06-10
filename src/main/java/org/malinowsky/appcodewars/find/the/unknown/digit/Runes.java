package org.malinowsky.appcodewars.find.the.unknown.digit;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

@RequestScoped
public class Runes implements Serializable {

    public int solveExpression( final String expression ) {
        return getNumbers(expression)
                .filter(el -> matches(expression, el))
                .min()
                .orElse(-1);
    }

    private boolean matches(String expression, int el) {
        String replaced = expression.replaceAll("\\?", String.valueOf(el));
        Pattern compile = Pattern.compile("(-?[?\\d]{1,7})([+*\\-])(-?[?\\d]{1,7})=(-?[?\\d]{1,7})");
        Matcher matcher = compile.matcher(replaced);
        matcher.find();

        int n1 = Integer.parseInt(matcher.group(1));
        String op = matcher.group(2);
        int n2 = Integer.parseInt(matcher.group(3));
        int res = Integer.parseInt(matcher.group(4));
        switch (op) {
            case "+": return n1 + n2 == res;
            case "-": return n1 - n2 == res;
            case "*": return n1 * n2 == res;
        }
        throw new IllegalStateException("Given string is illegal: " + expression);
    }

    private IntStream getNumbers(final String expression){
        Set<Integer> allNumbers =
            IntStream
                .range(0, expression.matches("(^|.*[+*\\-=])(-?\\?[?\\d]{1,6}).*") ? 9 : 10)
                .map(i -> (i + 1) % 10)
                .boxed()
                .collect(toSet());
        Set<Integer> inExpression =
            expression
                .replaceAll("\\D", "")
                .chars()
                .mapToObj(c -> (char) c)
                .map(Character::getNumericValue)
                .collect(toSet());
        allNumbers.removeAll(inExpression);
        return allNumbers.stream().mapToInt(i -> i);
    }
}
