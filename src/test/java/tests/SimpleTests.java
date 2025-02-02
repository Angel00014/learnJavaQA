package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.account.CreditAccount;
import org.example.account.DebitAccount;
import org.example.account.StatusAccount;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Helper;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SimpleTests {

    private Integer param1;
    private Integer param2;


    @BeforeEach
    public void beforeTests(){

        Random random = new Random();

        param1 = random.nextInt(10);
        param2 = random.nextInt(10);

    }

    @Test
    @Disabled("Требуется переписать")
    @DisplayName("Сравнение двух раномно сгенерированных параметров")
    public void testCompareTwoInteger() {



        int constant = 5;
        int constant2 = 10;

        int sum = constant2 + constant;

        Assertions.assertTrue(param1<param2, "Тест не пройден, великий рандом не помог");
        Assertions.assertEquals(15, sum, "Что-то пошло не так :-)");
    }


    @Test
    @Disabled("Требуется переписать")
    @DisplayName("Тест для проверки строки")
    public void testCompareString(){
        String myString = "Какая то строчка";

        Assertions.assertTrue(myString instanceof String);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/accounts.csv", delimiter = ',')
    @DisplayName("Сравнение суммы на счетах клиентов с минимумом")
    public void testWithParameter(String number, Double sum, String name){

        DebitAccount account = new DebitAccount(number, name, sum, StatusAccount.ACTIVE);

        System.out.println(account);

        Assertions.assertTrue(account.getSumma() > 100);

    }

    @Test
    public void testReadJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/test/resources/account.json");

        CreditAccount newCreditAccounts = objectMapper.readValue(jsonFile, CreditAccount.class);

        System.out.println(newCreditAccounts.getOwner() + " " + newCreditAccounts.getSumma());

        CreditAccount newCreditAccount2 = Helper.fromJson("src/test/resources/account.json", CreditAccount.class);
        System.out.println(newCreditAccount2);

        System.out.println(Helper.toJson(newCreditAccount2));


    }

    @AfterEach
    public void afterTests(){
        System.out.println(param1);
        System.out.println(param2);
    }
}
