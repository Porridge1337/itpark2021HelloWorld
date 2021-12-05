package lesson10.converter;

import lesson10.TemperatureScales;
import lesson10.TemperatureValue;

public class FahrenheitConverter implements TemperatureConverter {

    private final static TemperatureScales CURRENT_SCALE = TemperatureScales.FAHRENHEIT;
    private double convertedValue;

    public FahrenheitConverter() {
    }

    @Override
    public TemperatureValue convert(TemperatureValue temperatureValue) {
        switch (temperatureValue.getScale()) {
            case CELSIUS:
                convertedValue = (temperatureValue.getValue() * 1.8) + 32;
                return new TemperatureValue(convertedValue, CURRENT_SCALE);
            case FAHRENHEIT:
                return temperatureValue;
            case KELVIN:
                convertedValue = (temperatureValue.getValue() - 273.15) * 1.8 + 32;
                return new TemperatureValue(convertedValue, CURRENT_SCALE);
            default:
                return new TemperatureValue();
        }
    }
}
