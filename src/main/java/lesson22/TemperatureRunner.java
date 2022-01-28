package lesson22;

import lesson22.dto.CityTemperatureInformation;
import lesson22.parse.JsonParse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

public class TemperatureRunner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        try {
            CityTemperatureInformation info = new JsonParse("Архангельск").getCityInfo();
            System.out.println(info);
        } catch (FileNotFoundException exception) {
            System.out.println("Неверно указан город");
        }
    }


}
