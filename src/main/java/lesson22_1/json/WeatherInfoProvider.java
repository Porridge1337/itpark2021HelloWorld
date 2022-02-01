package lesson22_1.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson22_1.dto.WeatherInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WeatherInfoProvider {

    private final String weatherURL = "http://api.openweathermap.org/data/2.5/weather?";
    private final String keyParameter = "appid=";
    private final String unitsParameter = "units=metric";

    private List<WeatherInfo> weatherInfos = new ArrayList<>();

    private ObjectMapper mapper;


    public void getWeatherForecast(List<String> cities) throws IOException, URISyntaxException {
        fillWeatherInfos(cities);
        for (WeatherInfo info : weatherInfos) {
            System.out.println(info + "\n");
        }
    }

    private void fillWeatherInfos(List<String> cities) {
        for (String city : cities) {
            try {
                WeatherInfo info = getWeather(getURL(city));
                weatherInfos.add(info);
            } catch (IOException | URISyntaxException exception) {
                System.out.println("Неверный город: " + city + "\n");
            }
        }
    }

    private WeatherInfo getWeather(URL weatherURL) throws IOException {
        mapper = new ObjectMapper();
        WeatherInfo weatherInfo = mapper.readValue(weatherURL, WeatherInfo.class);
        return weatherInfo;
    }

    private URL getURL(String city) throws URISyntaxException, MalformedURLException {
        String URL = weatherURL + "q=" + city + "&" + keyParameter + getAPIKey() + "&" + unitsParameter;
        return new URL(URL);
    }

    private String getAPIKey() {
        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream("./src/main/resources/APIKey.properties")) {
            prop.load(inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return prop.getProperty("weather.api");
    }
}
