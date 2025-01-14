package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SimpleTests {

    private Integer param1;
    private Integer param2;

    @Test
    @DisplayName("Сравнение двух раномно сгенерированных параметров")
    public void testCompareTwoInteger() {

        Random random = new Random();


        param1 = random.nextInt(10);
        param2 = random.nextInt(10);

        Assertions.assertTrue(param1<param2, "Тест не пройден, великий рандом не помог");

    }
}
