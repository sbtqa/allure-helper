package ru.sbtqa.tag.allurehelper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.datajack.Stash;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.model.Label;

public class AllureRunListener extends ru.yandex.qatools.allure.cucumberjvm.AllureRunListener {

    private static final Logger LOG = LoggerFactory.getLogger(AllureRunListener.class);

    public static final String SuiteLabelsKey = "SuiteLabels";

    @Override
    public void testFailure(Failure failure) {
        LOG.debug("TestFailure:" + failure.getTrace());

        super.testFailure(failure);
        new OnFailureScheduler().processPendings();
    }

    /**
     * Mark test as Failure for Allure report if test failed, but it was not
     * critical
     *
     * @param description - description of test
     * @throws IllegalAccessException TODO
     */
    @Override
    public void testFinished(Description description) throws IllegalAccessException {
        super.testFinished(description);
    }

    @Override
    public void testSuiteFinished(String uid) {
        if (Stash.getInstance().containsKey(SuiteLabelsKey)) {
            Map<String, String> lblsmap = (Map<String, String>) Stash.getInstance().get(SuiteLabelsKey);
            List<Label> labels = lblsmap.entrySet().stream()
                    .map(e -> {
                        Label l = new Label();
                        l.setName(e.getKey());
                        l.setValue(e.getValue());
                        return l;
                    })
                    .collect(Collectors.toList());
            if (labels.size() > 0) {
                Allure.LIFECYCLE.fire(new AllureAddLabelEvent(uid, labels));
            }
        }
        super.testSuiteFinished(uid);
    }

    public static void addVideoParameter(String videoPath) {
        ParamsHelper.addParam("Video url", videoPath);
    }
}
