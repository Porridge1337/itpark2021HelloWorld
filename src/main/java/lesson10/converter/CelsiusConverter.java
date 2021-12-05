package lesson10.converter;

import lesson10.TemperatureScales;
import lesson10.TemperatureValue;

public class CelsiusConverter implements TemperatureConverterable {

    private final static TemperatureScales CURRENT_SCALE = TemperatureScales.CELSIUS;
    private double convertedValue;

    public CelsiusConverter() {
    }

    @Override
    public TemperatureValue convert(TemperatureValue temperatureValue) {
        switch (temperatureValue.getScale()) {
            case CELSIUS:
                return temperatureValue;
            case FAHRENHEIT:
                convertedValue = (temperatureValue.getValue() - 32) / 1.8;
                return new TemperatureValue(convertedValue, CURRENT_SCALE);
            case KELVIN:
                convertedValue = temperatureValue.getValue() - 273.15;
                return new TemperatureValue(convertedValue, CURRENT_SCALE);
            default:
                return new TemperatureValue();
        }
    }
}
