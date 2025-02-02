package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Settings;
import org.example.cinema.CinemaList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class CinemaTests {

    private List<CinemaList> cinemaList;


    @BeforeEach
    public void getJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("src/test/resources/cinemas.json");

        cinemaList = objectMapper.readValue(jsonFile, new TypeReference<List<CinemaList>>() {});

    }

    @Test
    public void testGetJsonWithHelper() throws IOException{
        File jsonFile = new File("src/test/resources/cinemas.json");
        List<CinemaList> cinemaLists1 = Helper.fromJsonList(jsonFile);
        System.out.println(cinemaLists1);
    }

    @Test
    public void testCinemaList(){
        for (CinemaList list : cinemaList) {
            System.out.println(list.getSummaryRating());
        }
    }

    @Test
    public void testHighLimit(){
        boolean result = false;

        for (CinemaList list : cinemaList){
            if (list.getSummaryRating() > 10.0){
                result = true;
            }
        }

        Assertions.assertFalse(result, "Превышающий рейтинг не найден");
    }

    @Test
    public void testProperties() throws IOException {

        Properties properties = new Properties();
        FileInputStream file_properties = new FileInputStream("src/test/resources/cinema.properties");

        properties.load(file_properties);
        String url = properties.getProperty("url_service");

        System.out.println(url);

    }

    @Test
    public void testPropertiesWithJackson() throws IOException {

        Properties properties = new Properties();
        FileInputStream file_properties = new FileInputStream("src/test/resources/cinema.properties");
        properties.load(file_properties);

        String json_properties = Helper.toJson(properties);



        Settings settings = Helper.fromJson(json_properties, Settings.class);

        System.out.println(settings.getUrlService());

    }
}
