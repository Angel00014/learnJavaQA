package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Settings;
import org.example.cinema.CinemaList;
import org.example.listener.RetryListener;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import utils.Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@Tag("cinema")
@ExtendWith(RetryListener.class)
public class CinemaTests {

    private List<CinemaList> cinemaList;

    private Properties properties;

    private Settings settings;

    private FileInputStream file_properties;


    @BeforeEach
    public void getData() throws IOException {

        properties = new Properties();
        file_properties = new FileInputStream("src/test/resources/cinema.properties");
        properties.load(file_properties);
        String json_properties = Helper.toJson(properties);
        settings = Helper.fromJson(json_properties, Settings.class);


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

        properties.load(file_properties);
        String url = properties.getProperty("url_service");

        System.out.println(url);

    }

    @Test
    public void testPropertiesWithJackson() throws IOException {

        properties.load(file_properties);

        String json_properties = Helper.toJson(properties);

        settings = Helper.fromJson(json_properties, Settings.class);

        System.out.println(settings.getUrlService());

    }

    @Test
    public void testForFailed(){

        String yourUrl = "your_url";


        Assertions.assertEquals(yourUrl, settings.getUrlService());

    }


    @AfterAll
    public static void saveFailed() throws IOException {
        RetryListener.saveResultToFile();
    }
}
