package org.malinowsky.sum.util;

import java.util.Objects;

import static java.util.Arrays.asList;

public class KeyStatusesUtil {
    public static boolean isFullyValid(KeysStatuses incoming) {
        KeysStatuses expected = new KeysStatuses();
        expected.setActiveGsko(100);
        expected.setActiveTmSck(100);
        expected.setActiveGck(100);
        expected.setDmSck(asList(100, 100, 0));
        return isValid(incoming, expected);
    }

    public static boolean isValid(KeysStatuses incoming, KeysStatuses expected) {
        return Objects.deepEquals(expected, incoming);
    }
}
