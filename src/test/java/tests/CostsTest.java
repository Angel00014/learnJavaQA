package tests;

import io.qameta.allure.Allure;
import org.example.cost.CostClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CostsTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/costs.csv", delimiter = ',')
    public void testFinalCost(double cost) throws RuntimeException{
        double result = CostClass.calculateCost(cost);
        Allure.step("Проверка положительного значения цены", step->{
            Assertions.assertTrue(result > 0);
        });
    }
}
