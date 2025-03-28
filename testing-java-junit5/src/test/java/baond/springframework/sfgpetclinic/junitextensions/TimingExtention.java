package baond.springframework.sfgpetclinic.junitextensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * Created by BaoND on 2025-03-22
 */
public class TimingExtention implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger logger = Logger.getLogger(TimingExtention.class.getName());
    private static final String START_TIME = "start time";


    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        getStore(context).put(START_TIME, System.currentTimeMillis());
        System.out.println("Before test execution");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Method testMethod = context.getRequiredTestMethod();
        long startTime = getStore(context).get(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("After test execution");
        logger.info(() -> String.format("Method [%s] took %s ms.", testMethod.getName(), duration));
    }


    private ExtensionContext.Store getStore(ExtensionContext context) {
        return context.getStore(ExtensionContext.Namespace.create(getClass(), context.getRequiredTestMethod()));
    }
}
