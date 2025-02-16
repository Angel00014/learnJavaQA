package org.example.yamlConfig;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

@Data
public class YamlConfig {

    @Getter
    private static Config config;

    @Data
    @NoArgsConstructor
    public static class AppConfig {
        private int maxRetries;

        public AppConfig(int maxRetries) {
            this.maxRetries = maxRetries;
        }
    }

    @Data
    @NoArgsConstructor
    public static class CostConfig {
        @JsonProperty("current_discount")
        private double currentDiscount;

        public CostConfig(double currentDiscount) {
            this.currentDiscount = currentDiscount;
        }
    }

    @Data
    public static class Config {
        private AppConfig app;
        private CostConfig cost;
    }

    static {
        loadConfig();
    }

    private static void loadConfig() throws RuntimeException{

        InputStream inputStream = YamlConfig.class.getClassLoader().getResourceAsStream("application.yaml");
        Yaml yaml = new Yaml();
        config = yaml.loadAs(inputStream, Config.class);
    }

    public static int getMaxRetries() {
        if (config == null || config.getApp() == null) {
            throw new RuntimeException("Конфигурация не была загружена или отсутствует поле 'app'.");
        }
        return config.getApp().getMaxRetries();
    }

    public static double getCurrentDiscount() {
        if (config == null || config.getCost() == null) {
            throw new RuntimeException("Конфигурация не была загружена или отсутствует поле 'cost'.");
        }
        return config.getCost().getCurrentDiscount();
    }

}
