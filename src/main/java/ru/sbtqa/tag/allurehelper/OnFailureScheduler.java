package ru.sbtqa.tag.allurehelper;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.cucumberjvm.callback.OnFailureCallback;

/**
 * Helper to add actions in case exceptions are fired
 */
public class OnFailureScheduler implements OnFailureCallback{

    private static final Logger LOG = LoggerFactory.getLogger(OnFailureScheduler.class);

    private static final List<Runnable> runnables = new ArrayList<>();

    public static void addAction(Runnable task) {
        runnables.add(task);
    }

    @Override
    public Object call() {
        for (int i = 0; i < runnables.size(); i++) {
            try {
                Runnable r = runnables.remove(0);
                r.run();
            } catch (Exception | AssertionError t) {
                LOG.warn("Cannot execute failure action", t);
            }
        }
        return null;
    }

}
