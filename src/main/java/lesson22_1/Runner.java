package lesson22_1;

import lesson22_1.json.WeatherInfoProvider;

import java.io.IOException;
import java.net.URISyntaxException;

public class Runner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        WeatherInfoProvider provider = new WeatherInfoProvider();
        String[] cities = new String[]{"Arkhangelsk", "Severodvinsk", "fdgdsgsdhsfdh"};
        provider.getWeatherForecast(cities);
    }

}
