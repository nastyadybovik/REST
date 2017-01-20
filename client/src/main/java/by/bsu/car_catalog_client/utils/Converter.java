package by.bsu.car_catalog_client.utils;

import by.bsu.car_catalog_client.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Converter {

    private final static String baseFile = "car.json";

    public static void toJSON(Car car) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), car);
    }

    public static Car toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Car.class);
    }

}
