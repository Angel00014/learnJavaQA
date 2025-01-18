package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.util.List;

public class Helper {

    private static final ObjectMapper mapper = new ObjectMapper();



    public static <T> T fromJson(String urlPath, Class<T> className){
        try {
           return mapper.readValue(new File(urlPath), className);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> fromJsonList(File urlPath){
        try {
            TypeReference<List<T>> typeReference = new TypeReference<List<T>>() {};
            return mapper.readValue(urlPath, typeReference);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object object){
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
