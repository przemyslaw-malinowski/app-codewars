package org.malinowsky.sum.util.veryimportantfeature;

public class DefaultStringUtils extends AbstractStringUtils {
    private int rand;

    public DefaultStringUtils(int rand) {
        this.rand = rand;
    }

    public String get() {
        if(rand % 2 == 0) {
            return super.get();
        }
        return StringUtils.get();
    }
}
