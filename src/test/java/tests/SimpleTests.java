package tests;

import org.example.account.Account;
import org.example.account.DebitAccount;
import org.example.account.StatusAccount;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

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

    @AfterEach
    public void afterTests(){
        System.out.println(param1);
        System.out.println(param2);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/accounts.csv", delimiter = ',')
    @DisplayName("Сравнение суммы на счетах клиентов с минимумом")
    public void testWithParameter(String number, Double sum, String name){

        DebitAccount account = new DebitAccount(number, name, sum, StatusAccount.ACTIVE);

        System.out.println(account);

        Assertions.assertTrue(account.getSumma() > 600);

    }
}
