package lesson9h;

public class Truck extends Automobile {

    private String brand;
    private final static String CAR_TYPE = "Грузовая машина";

    public Truck(int distance, String brand) {
        super(distance, CAR_TYPE);
        this.brand = brand;
    }

    @Override
    public void move() {
        System.out.println(getCarType() + " " + brand + " преодолевает " + getDistance() + " км");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
