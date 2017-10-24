package ru.sbtqa.tag.allurehelper;

import ru.yandex.qatools.allure.events.TestCaseStatusChangeEvent;
import ru.yandex.qatools.allure.model.Status;

/**
 * Using to change testCase status to BROKEN
 *
 * @see TestCaseStatusChangeEvent
 */
public class TestCaseBrokenEvent extends TestCaseStatusChangeEvent {

    private String message = "Test broken with unknown reason";

    /**
     * Returns the status BROKEN
     *
     * @return the status
     */
    @Override
    protected Status getStatus() {
        return Status.BROKEN;
    }

    /**
     * Returns default message
     *
     * @return default message
     */
    @Override
    protected String getMessage() {
        return message;
    }

    /**
     * Sets the default message
     *
     * @param message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets throwable
     *
     * @param value to set
     * @return modified instance
     */
    public TestCaseBrokenEvent withThrowable(Throwable value) {
        setThrowable(value);
        return this;
    }
}