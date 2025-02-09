package org.example.listener;

import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.example.Settings;
import org.example.yamlConfig.YamlConfig;
import org.example.yamlConfig.YamlConfig.Config;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class RetryListener implements TestExecutionExceptionHandler, AfterTestExecutionCallback {

    private final int MaxRetries = YamlConfig.getMaxRetries();

    private static final Set<String> failedTestNames = new HashSet<>();

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        for (int i = 0; i < MaxRetries; i++){
            try {
                extensionContext.getRequiredTestMethod().invoke(extensionContext.getRequiredTestInstance());
                return;
            } catch (Throwable ex){
                throwable = ex;
            }
        }
        throw throwable;
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Method method = extensionContext.getRequiredTestMethod();
        String testClass = extensionContext.getRequiredTestClass().getName();
        String testName = method.getName();
        String testToWrite = String.format("--test %s.%s*", testClass, testName);

        extensionContext.getExecutionException().ifPresent(x->failedTestNames.add(testToWrite));
    }

    public static void saveResultToFile() throws IOException {
        String output = System.getProperty("user.dir") + "/src/test/resources/FailedTestsList.txt";

        String result = String.join(" ", failedTestNames);

        FileUtils.writeStringToFile(new File(output), result);
    }
}
