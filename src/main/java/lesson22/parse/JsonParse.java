package lesson22.parse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson22.dto.CityTemperatureInformation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class JsonParse {

    private String city;
    private final URI uri;

    public JsonParse(String city) throws URISyntaxException {
        this.city = city;
        uri = new URI("http://api.openweathermap.org/data/2.5/weather?q=" + city +
                ",ru&appid=" + getAPIKey() + "&units=metric");

    }

    public CityTemperatureInformation getCityInfo() throws URISyntaxException, IOException {
        JsonNode mapper = new ObjectMapper().readTree(uri.toURL());
        Map<String, String> info = new LinkedHashMap<>();
        for (Iterator<String> fieldsIterator = mapper.fieldNames(); fieldsIterator.hasNext(); ) {
            String fieldName = fieldsIterator.next();
            switch (fieldName) {
                case "weather", "main", "wind", "name" -> {
                    info.putAll(getParameterFromField(fieldName, mapper.get(fieldName)));
                }
            }
        }

        return fill(info);
    }

    private Map<String, String> getParameterFromField(String fieldName, JsonNode mapper) {
        Map<String, String> result = new LinkedHashMap<>();
        if (mapper.size() != 0) {
            if (mapper.isArray()) {
                for (JsonNode node : mapper) {
                    result.put(fieldName, node.get("main").toString());
                }
            }
            for (Iterator<String> iterator = mapper.fieldNames(); iterator.hasNext(); ) {
                String param = iterator.next();
                switch (param) {
                    case "temp", "deg", "speed", "humidity", "feels_like" -> {
                        result.put(param, mapper.get(param).toString());
                    }
                }
            }
        } else if (fieldName.equals("name")) {
            result.put(fieldName, mapper.toString());
        }
        return result;
    }

    private CityTemperatureInformation fill(Map<String, String> info) {
        CityTemperatureInformation citiInfo = new CityTemperatureInformation();
        for (Map.Entry<String, String> entry : info.entrySet()) {
            switch (entry.getKey()) {
                case "weather" -> citiInfo.setWeather(entry.getValue());
                case "temp" -> citiInfo.setTemperature(Double.valueOf(entry.getValue()));
                case "feels_like" -> citiInfo.setFeelsLike(Double.valueOf(entry.getValue()));
                case "humidity" -> citiInfo.setHumidity(Integer.valueOf(entry.getValue()));
                case "speed" -> citiInfo.setWindSpeed(Double.valueOf(entry.getValue()));
                case "deg" -> citiInfo.setWindDegree(Integer.valueOf(entry.getValue()));
                case "name" -> citiInfo.setCityName(entry.getValue());
            }
        }
        return citiInfo;
    }

    private String getAPIKey() {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream("./src/main/resources/lesson22/APIKey.properties")) {
            prop.load(inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return prop.getProperty("weather.api");
    }
}
