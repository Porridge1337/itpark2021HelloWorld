package lesson22;

import lesson22.dto.CityTemperatureInformation;
import lesson22.parse.JsonParse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TemperatureRunner {

    public static void main(String[] args) {
        try {
            CityTemperatureInformation info = new JsonParse("Архангельск").getCityInfo();
            System.out.println(info);
        } catch (FileNotFoundException | URISyntaxException exception) {
            System.out.println("Неверно указан город");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
