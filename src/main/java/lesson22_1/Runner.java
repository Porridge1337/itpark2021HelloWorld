package lesson22_1;

import lesson22_1.json.WeatherInfoProvider;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        WeatherInfoProvider provider = new WeatherInfoProvider();
        String[] cities = printCities();
        provider.getWeatherForecast(cities);
    }

    public static String[] printCities() {
        Scanner sc = new Scanner(System.in);
        List<String> cities = new ArrayList<>();
        do {
            System.out.print("Введите название города: ");
            String city = sc.nextLine();
            cities.add(city);
            System.out.println("Нажмите 'q' для остановки ввода, для продолжения любой символ.");
        } while (!sc.nextLine().equals("q"));

        return cities.toArray(new String[0]);
    }
}
