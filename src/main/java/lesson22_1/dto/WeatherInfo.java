package lesson22_1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {
    private String name;
    private WeatherMain main;
    private List<Weather> weather;

    @Override
    public String toString() {
        return "Город: " + name + "\n"
                + "Температура воздуха: " + main.getTemp() + "\n"
                + "По ощущениям: " + main.getFeels_like() + "\n"
                + "Влажность воздуха: " + main.getHumidity() + "\n"
                + "Тип погода: " + weather.get(0).getMain() + "\n"
                + "Описание погоды: " + weather.get(0).getDescription() + "\n";
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherMain {
    private double temp;
    private double feels_like;
    private double temp_min;
    private double temp_max;
    private double pressure;
    private double humidity;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class Weather {
    private int id;
    private String main;
    private String description;
}
