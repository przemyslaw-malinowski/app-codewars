package org.malinowsky.appcodewars.humming.numbers;

import static org.malinowsky.appcodewars.humming.numbers.HammingImplementation.HammingType.BETTER;

@HammingImplementation(value = BETTER)
public class BetterHamming implements Hamming{
    @Override
    public long hamming(int n) {
        long[] h = new long[n];
        h[0] = 1;
        long x2 = 2, x3 = 3, x5 = 5;
        int i = 0, j = 0, k = 0;

        for (int index = 1; index < n; index++) {
            h[index] = Math.min(x2, Math.min(x3, x5));
            if (h[index] == x2) x2 = 2 * h[++i];
            if (h[index] == x3) x3 = 3 * h[++j];
            if (h[index] == x5) x5 = 5 * h[++k];
        }

        return h[n - 1];
    }
}
