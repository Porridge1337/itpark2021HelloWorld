package lesson11.cars;

public class Сars {

    private final CarType currentCar;
    private String carNumber;
    private double speed;
    private double weight;
    private double width;
    private double height;

    public Сars(CarType currentCar, String carNumber, double speed, double weight, double height, double width) {
        this.currentCar = currentCar;
        this.carNumber = carNumber;
        this.speed = speed;
        this.weight = weight;
        this.height = height;
        this.width = width;

    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public CarType getCurrentCar() {
        return currentCar;
    }


}
