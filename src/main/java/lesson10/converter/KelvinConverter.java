package lesson10.converter;

import lesson10.TemperatureScales;
import lesson10.TemperatureValue;

public class KelvinConverter implements TemperatureConverterable {

    private final static TemperatureScales CURRENT_SCALE = TemperatureScales.KELVIN;
    private double convertedValue;

    public KelvinConverter() {
    }

    @Override
    public TemperatureValue convert(TemperatureValue temperatureValue) {
        switch (temperatureValue.getScale()) {
            case CELSIUS:
                convertedValue = temperatureValue.getValue() + 273.15;
                return new TemperatureValue(convertedValue, CURRENT_SCALE);
            case FAHRENHEIT:
                convertedValue = (temperatureValue.getValue() - 32) / 1.8 + 273.15;
                return new TemperatureValue(convertedValue, CURRENT_SCALE);
            case KELVIN:
                return temperatureValue;
            default:
                return new TemperatureValue();
        }
    }
}
