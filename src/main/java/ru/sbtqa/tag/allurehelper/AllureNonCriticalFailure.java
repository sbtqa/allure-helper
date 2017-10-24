package ru.sbtqa.tag.allurehelper;

import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.StepCanceledEvent;
import ru.yandex.qatools.allure.events.StepFailureEvent;
import ru.yandex.qatools.allure.events.TestCaseFailureEvent;
import ru.yandex.qatools.allure.events.TestCasePendingEvent;

import java.util.HashMap;
import java.util.Map;

public class AllureNonCriticalFailure {

    private static final Map<Thread, Throwable> FAILURES_MAP = new HashMap<>();

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
        Allure.LIFECYCLE.fire(new StepBrokenEvent());
        Allure.LIFECYCLE.fire(new TestCaseBrokenEvent().withThrowable(throvv));
    }

    /**
     * Return failures which FAILURES_MAP contains
     *
     * @return all non critical failures
     */
    public static Map<Thread, Throwable> getFailures() {
        return FAILURES_MAP;
    }

    /**
     * Clears FAILURES_MAP
     */
    public static void clearFailures() {
        FAILURES_MAP.clear();
    }
}
