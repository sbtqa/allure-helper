package ru.sbtqa.tag.allurehelper;

import java.util.HashMap;
import java.util.Map;

public class AllureNonCriticalFailure {

    private static final Map<Thread, Throwable> failureMap = new HashMap<>();

    private AllureNonCriticalFailure() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * Add thread as key and exception as value to failure map, for non
     * CriticalError during test executing
     *
     * @param throvv - throw stack trace
     */
    public static void fire(Throwable throvv) {
        failureMap.put(Thread.currentThread(), throvv);
    }

    /**
     * return failure which failureMap contains
     *
     * @return a {@link ava.util.Map} object.
     */
    public static Map<Thread, Throwable> getFailure() {
        return failureMap;
    }

    /**
     * clear failureMap
     */
    public static void clrFailure() {
        failureMap.clear();
    }
}
