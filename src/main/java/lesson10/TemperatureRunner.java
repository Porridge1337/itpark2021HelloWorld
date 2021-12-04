package lesson10;

import lesson10.converter.CelsiusConverter;
import lesson10.converter.FahrenheitConverter;
import lesson10.converter.KelvinConverter;
import lesson10.converter.TemperatureConverter;

public class TemperatureRunner {

    public static void main(String[] args) {
        TemperatureValue t1 = new TemperatureValue(100, TemperatureScales.CELSIUS);
        TemperatureValue t2 = new TemperatureValue(273,TemperatureScales.FAHRENHEIT);
        TemperatureValue t3 = new TemperatureValue(150, TemperatureScales.KELVIN);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        TemperatureConverter celsiusConverter = new CelsiusConverter();
        TemperatureConverter fahrenheitConverter = new FahrenheitConverter();
        TemperatureConverter kelvinConverterConverter = new KelvinConverter();

        TemperatureValue t1CelsiusConverted = celsiusConverter.convert(t1);
        TemperatureValue t2CelsiusConverted = celsiusConverter.convert(t2);
        TemperatureValue t3CelsiusConverted = celsiusConverter.convert(t3);

        TemperatureValue t1FahrenheitConverted = fahrenheitConverter.convert(t1);
        TemperatureValue t2FahrenheitConverted = fahrenheitConverter.convert(t2);
        TemperatureValue t3FahrenheitConverted = fahrenheitConverter.convert(t3);

        TemperatureValue t1KelvinConverted = kelvinConverterConverter.convert(t1);
        TemperatureValue t2KelvinConverted = kelvinConverterConverter.convert(t2);
        TemperatureValue t3KelvinConverted = kelvinConverterConverter.convert(t3);


        System.out.println(t1CelsiusConverted);
        System.out.println(t2CelsiusConverted);
        System.out.println(t3CelsiusConverted);

        System.out.println(t1FahrenheitConverted);
        System.out.println(t2FahrenheitConverted);
        System.out.println(t3FahrenheitConverted);

        System.out.println(t1KelvinConverted);
        System.out.println(t2KelvinConverted);
        System.out.println(t3KelvinConverted);
    }


}
