package lesson10;

public class TemperatureValue {

    private double value;
    private TemperatureScales scale;

    public TemperatureValue() {
    }

    public TemperatureValue(double value, TemperatureScales scale) {
        this.value = value;
        this.scale = scale;
    }

    public double getValue() {
        return value;
    }

    public TemperatureScales getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return  value + " " + scale;
    }
}
