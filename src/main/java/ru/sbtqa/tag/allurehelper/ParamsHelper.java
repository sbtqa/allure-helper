package ru.sbtqa.tag.allurehelper;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import static java.util.UUID.randomUUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper to add parameters to allure report
 */
public class ParamsHelper {

    private static final Logger LOG = LoggerFactory.getLogger(ParamsHelper.class);
    private static final String UNNAMED_FIELD = "Unnamed Field";
    private static final String VALUE_TEMPLATE = ": %s";

    /**
     * Add parameter to allure report
     *
     * @param fieldName field name to get title
     * @param value parameter value
     */
    public static void addParam(String fieldName, String value) {
        String safeName = (fieldName == null) ? UNNAMED_FIELD : fieldName;
        addParam(safeName + VALUE_TEMPLATE, new String[]{value});
    }

    /**
     * Add parameter to allure report
     *
     * @param format a format string as described in Format string syntax.
     * @param parameters parameters referenced by the format specifiers in the format string
     */
    public static void addParam(String format, String[] parameters) {
        String name = String.format(format, (Object[]) parameters);
        LOG.info(name);
        Allure.getLifecycle().startStep(randomUUID().toString(), new StepResult().withName(name).withStatus(Status.PASSED));
        Allure.getLifecycle().stopStep();
    }

    /**
     * Add attachment to allure report
     *
     * @param attachment as byte array.
     * @param title title of attachment. Shown at report as name of attachment
     * @param type type of attachment
     */
    public static void addAttachment(byte[] attachment, String title, Type type) {
        Allure.getLifecycle().addAttachment(title, type.toString(), title, attachment);
    }
}
