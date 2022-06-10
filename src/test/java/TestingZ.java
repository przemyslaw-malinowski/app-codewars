import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestingZ {
    @Data
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    class Ludź {
        Integer age;
    }
    @Test
    public void name() {
        List<Ludź> list = Arrays.asList(new Ludź(7), new Ludź(2), new Ludź(6), new Ludź(4), new Ludź(null), new Ludź(5), new Ludź(1), new Ludź(1));
        list
                .stream()
                .sorted(Comparator.comparing(Ludź::getAge, Comparator.nullsFirst(Comparator.naturalOrder())))
                .forEach(System.out::println);

        Ludź ludź = list
                .stream()
                .min(Comparator.comparing(Ludź::getAge, Comparator.nullsLast(Comparator.naturalOrder())))
                .get();

        System.out.println(ludź);
    }
}

