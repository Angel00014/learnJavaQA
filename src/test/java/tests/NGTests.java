package tests;

import dataProvider.CreditAccountDataProvider;
import dataProvider.UserDataProvider;
import org.example.account.CreditAccount;
import org.example.account.DebitAccount;
import org.example.listener.RetryListenerTestNG;
import org.example.user.Users;
import org.example.yamlConfig.YamlConfig;
import org.testng.*;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.UUID;


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

    @Test(dataProviderClass = CreditAccountDataProvider.class, dataProvider = "AccountListCsv", groups = {"checkAccounts"})
    public void testCheckAccount(CreditAccount account) {
        Assert.assertTrue(account.getSumma() > 0);
    }

    @Test(dataProviderClass = UserDataProvider.class, dataProvider = "UserListCsv", groups = {"checkUserUUID"})
    public void testCheckUserUUID(Users users){
        Assert.assertTrue(users.getUuid() instanceof UUID);
    }

    @AfterSuite
    public void saveFailed() throws IOException {
        RetryListenerTestNG.saveResultToFile();
    }

}
