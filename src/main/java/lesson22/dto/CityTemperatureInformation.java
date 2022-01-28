package lesson22.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityTemperatureInformation {

    private String weather;
    private double temperature;
    private double feelsLike;
    private int humidity;
    private double windSpeed;
    private int windDegree;
    private String cityName;

}
