package ru.sbtqa.tag.allurehelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.events.AddParameterEvent;

/**
 * Helper to add parameters to allure report
 */
public class ParamsHelper {

    private static final Logger log = LoggerFactory.getLogger(ParamsHelper.class);

    /**
     * Add parameter to allure report
     *
     * @param fieldName field name to get title
     * @param value - parameter value
     */
    public static void addParam(String fieldName, String value) {
        String name = (fieldName == null) ? "Unnamed Field" : fieldName;
        Allure.LIFECYCLE.fire(new AddParameterEvent(name, value));
    }

    Parameter getParameterAnnotation(final String value) {
        return new Parameter() {

            @Override
            public String value() {
                return value;
            }

            @Override
            public Class<Parameter> annotationType() {
                return Parameter.class;
            }
        };
    }
}
