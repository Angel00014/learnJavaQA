package tests;

import org.example.listener.RetryListenerTestNG;
import org.example.yamlConfig.YamlConfig;
import org.testng.*;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

import java.io.IOException;


@Listeners(RetryListenerTestNG.class)
public class NGTests {

    @BeforeSuite(groups = {"fail3"})
    public void beforeTests(ITestContext context){
        for (ITestNGMethod testMethod : context.getAllTestMethods()) {
            testMethod.setRetryAnalyzer(new RetryListenerTestNG());
        }
    }


    @Test
    public void testCheckCurrentDiscount(){
        double currentDiscount = YamlConfig.getCurrentDiscount();

        Assert.assertTrue(currentDiscount > 0);
        Assert.assertTrue(currentDiscount <= 100);
    }

    @Test(groups = { "fail3" })
    public void testForFailed(){

        double currentDiscount = YamlConfig.getCurrentDiscount();

        Assert.assertTrue(currentDiscount < 0);
        Assert.assertTrue(currentDiscount >= 100);

    }

    @AfterSuite
    public void saveFailed() throws IOException {
        RetryListenerTestNG.saveResultToFile();
    }

}
