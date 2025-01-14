package tests;

import org.junit.jupiter.api.*;

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
    @Disabled("Params")
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
}
