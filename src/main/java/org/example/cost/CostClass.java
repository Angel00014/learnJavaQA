package org.example.cost;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.example.yamlConfig.YamlConfig;

import java.util.concurrent.atomic.AtomicReference;

public class CostClass {

    private static final double currentDiscount = YamlConfig.getCurrentDiscount();

    @Step("Расчёт конечной цены с учётом скидки {currentDiscount}")
    public static double calculateCost(double beginCost) throws RuntimeException {
        AtomicReference<Double> result = new AtomicReference<>();
        Allure.step("Получение текущей скидки: " + currentDiscount);
        Allure.step("Расчёт финальной цены",step ->{
            result.set((beginCost / 100) * currentDiscount);
        });
        return result.get();
    }
}
