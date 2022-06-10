package org.malinowsky.sum.util.veryimportantfeature;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VeryImportantFeatureTest {
    @Test
    public void test() {
        //INPUT
        int rand = 5;

        //THIS IS TEST UTIL PART
        String valueExpected = new VeryImportantFeatureTestUtil(rand).get();

        //THIS IS VERY IMPORTANT FEATURE
        String valueAssigned = new DefaultStringUtils(rand).get();

        System.out.println(valueExpected);
        System.out.println(valueAssigned);
        assertTrue(valueExpected.equals(valueAssigned));
    }

    class VeryImportantFeatureTestUtil {
        private int rand;

        public VeryImportantFeatureTestUtil(int rand) {
            this.rand = rand;
        }

        public  String get() {
            return rand % 2 == 0 ?
                    "Even number" :
                    "Odd number";
        }
    }
}
