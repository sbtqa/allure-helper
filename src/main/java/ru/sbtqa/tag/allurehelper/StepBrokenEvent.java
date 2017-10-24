package ru.sbtqa.tag.allurehelper;

import ru.yandex.qatools.allure.events.AbstractStepFailureEvent;
import ru.yandex.qatools.allure.model.Status;
import ru.yandex.qatools.allure.model.Step;

/**
 * Using to mark current step as broken
 */
public class StepBrokenEvent extends AbstractStepFailureEvent {

    /**
     * Change step status to {@link ru.yandex.qatools.allure.model.Status#BROKEN}
     *
     * @param step which will be changed
     */
    @Override
    public void process(Step step) {
        step.setStatus(Status.BROKEN);
    }
}
