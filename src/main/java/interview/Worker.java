/*
 * Worker
 *
 * © 2022 MOTOROLA SOLUTIONS INC., ALL RIGHTS RESERVED
 *
 * The copyright to the computer program(s) herein is the property of Motorola Inc.
 * The programs may be used or copied only with the written permission of Motorola Inc.
 *
 * Motorola Internal Use Only
 */
package interview;

import java.util.Random;
import java.util.concurrent.Callable;

public class Worker implements Callable<String> {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    private static Object obj;

    @Override
    public String call() throws Exception {
        Thread.currentThread().setName(name);
        Random random = new Random();
        int timeout = (random.nextInt(3) + 1) * 1000;
        synchronized (obj) {
            System.out.printf("%s: Przycupnę sobie tutaj na tym kamieniu: %s\n", Thread.currentThread().getName(), timeout);
            Thread.sleep(timeout);
        }
        return String.valueOf(timeout);
    }

    public void doSomething() {
        System.out.println("Wypisz mienia");
    }

    public static Worker create(String name) {
        return new Worker(name);
    }
}
