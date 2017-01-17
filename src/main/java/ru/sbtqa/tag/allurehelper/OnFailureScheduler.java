package ru.sbtqa.tag.allurehelper;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper to add actions in case exceptions are fired
 */
public class OnFailureScheduler {

    private static final Logger LOG = LoggerFactory.getLogger(OnFailureScheduler.class);

    private static final List<Runnable> RUNNABLES = new ArrayList<>();

    public static void addAction(Runnable task) {
        RUNNABLES.add(task);
    }

    public void processPendings() {

        while (!RUNNABLES.isEmpty()) {
            try {
                Runnable r = RUNNABLES.remove(0);
                r.run();
            } catch (Exception | AssertionError t) {
                LOG.warn("Cannot execute failure action", t);
            }
        }
    }

}
