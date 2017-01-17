package ru.sbtqa.tag.allurehelper;

import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.events.AddParameterEvent;

/**
 * Helper to add parameters to allure report
 */
public class ParamsHelper {

    /**
     * Add parameter to allure report
     *
     * @param paramName parameter name
     * @param value - parameter value
     */
    public static void addParam(String paramName, String value) {
        String name = (paramName == null) ? "Unnamed Parameter" : paramName;
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
