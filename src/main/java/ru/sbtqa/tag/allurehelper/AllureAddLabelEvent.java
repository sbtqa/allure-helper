package ru.sbtqa.tag.allurehelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import ru.yandex.qatools.allure.events.AbstractTestSuiteFinishedEvent;
import ru.yandex.qatools.allure.model.Label;
import ru.yandex.qatools.allure.model.TestSuiteResult;

public class AllureAddLabelEvent extends AbstractTestSuiteFinishedEvent {

    private final List<Label> labels = new ArrayList<>();

    public AllureAddLabelEvent(String uid, String name, String value) {
        setUid(uid);
        Label label = new Label();
        label.setName(name);
        label.setValue(value);
        labels.add(label);
    }

    public AllureAddLabelEvent(String uid, List<Label> lbls) {
        setUid(uid);
        labels.addAll(lbls);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)){
            return false;
        }

        AllureAddLabelEvent eqCandidate = (AllureAddLabelEvent) obj;
        return eqCandidate.labels.equals(this.labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.labels);
    }


    @Override
    public void process(TestSuiteResult testSuiteResult) {
        Optional.of(testSuiteResult.getLabels()).ifPresent(l -> l.addAll(labels));
    }
}
