package ru.sbtqa.tag.allurehelper;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.datajack.Stash;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.model.Label;

public class TagAllureRunListener extends ru.yandex.qatools.allure.cucumberjvm.AllureRunListener {

    private static final Logger LOG = LoggerFactory.getLogger(TagAllureRunListener.class);
    private static final String SUITE_LABELS_KEY = "SuiteLabels";
    private final String uuid = UUID.randomUUID().toString();


    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        TagAllureRunListener eqCandidate = (TagAllureRunListener) obj;
        return eqCandidate.uuid.equals(this.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.uuid);
    }


    @Override
    public void testFailure(Failure failure) {
        LOG.debug("TestFailure:" + failure.getTrace());

        super.testFailure(failure);
        new OnFailureScheduler().processPendings();
    }

    @Override
    public void testSuiteFinished(String uid) {
        if (Stash.asMap().containsKey(SUITE_LABELS_KEY)) {
            Map<String, String> lblsmap = (Map<String, String>) Stash.asMap().get(SUITE_LABELS_KEY);
            List<Label> labels = lblsmap.entrySet().stream()
                    .map(e -> {
                        Label l = new Label();
                        l.setName(e.getKey());
                        l.setValue(e.getValue());
                        return l;
                    })
                    .collect(Collectors.toList());
            if (!labels.isEmpty()) {
                Allure.LIFECYCLE.fire(new AllureAddLabelEvent(uid, labels));
            }
        }
        super.testSuiteFinished(uid);
    }

    public static void addVideoParameter(String videoPath) {
        ParamsHelper.addParam("Video url", videoPath);
    }
}
