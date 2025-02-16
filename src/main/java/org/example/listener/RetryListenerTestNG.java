package org.example.listener;

import org.example.yamlConfig.YamlConfig;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerTestNG implements IRetryAnalyzer {

    private final int MAX_Retry = YamlConfig.getMaxRetries();

    private int count_retry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count_retry < MAX_Retry){
            count_retry++;
            return true;
        }else {
            return false;
        }
    }
}
