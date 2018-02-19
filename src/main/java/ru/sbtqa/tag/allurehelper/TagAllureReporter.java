package ru.sbtqa.tag.allurehelper;

import gherkin.formatter.model.Step;
import ru.sbtqa.tag.qautils.i18n.I18N;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;

public abstract class TagAllureReporter extends AllureReporter {
    
    @Override
    public String getStepName(Step step) {
        return step.getName().split(I18N.SECRET_DELIMITER).length > 1
                ? step.getName().split(I18N.SECRET_DELIMITER)[1]
                : step.getName();
    }
}
