package lesson9;

public class Car extends Automobile {

    private String brand;
    private final static String CAR_TYPE = "Легковая машина";

    public Car(int distance, String brand) {
        super(distance, CAR_TYPE);
        this.brand = brand;
    }

    @Override
    public void move() {
        if (getDistance() > 500) {
            System.out.println(getCarType() + " " + brand + " не может преодолеть дистанцию больше 500 км " +
                    "на одном баке.Предложенное расстояние равняется " + getDistance() + " км");
        } else {
            System.out.println(getCarType() + " " + brand + " преодолевает " + getDistance() + " км");
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
