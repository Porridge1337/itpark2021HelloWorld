package lesson9h;

public abstract class Automobile {

    private int distance;
    private String carType;

    public Automobile() {
    }

    public Automobile(int distance, String carType) {
        this.distance = distance;
        this.carType = carType;
    }

    public abstract void move();

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
