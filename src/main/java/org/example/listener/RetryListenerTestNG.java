package org.example.listener;

import org.apache.commons.io.FileUtils;
import org.example.yamlConfig.YamlConfig;
import org.junit.jupiter.api.Test;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RetryListenerTestNG implements IRetryAnalyzer, ITestListener {

    private final int MAX_Retry = YamlConfig.getMaxRetries();

    private int count_retry = 1;

    private static final Set<String> failedTestNames = new HashSet<>();

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count_retry < MAX_Retry){
            count_retry++;
            return true;
        }else {
            return false;
        }
    }

    private void addToFailedSet(ITestResult result){
        String testToWrite = String.format("--tests %s.%s", result.getTestClass().getName(), result.getName());
        failedTestNames.add(testToWrite);
    }

    public static void saveResultToFile() throws IOException {
        String output = System.getProperty("user.dir") + "/src/test/resources/FailedTestsList.txt";

        String result = String.join(" ", failedTestNames);

        FileUtils.writeStringToFile(new File(output), result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        addToFailedSet(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        addToFailedSet(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
        addToFailedSet(result);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
