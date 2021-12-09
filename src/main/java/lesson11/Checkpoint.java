package lesson11;

import lesson11.cars.Сars;
import lesson11.exception.ExcessiveDimensionsException;
import lesson11.exception.ToBigweightException;

public class Checkpoint {

    private Сars car;

    public Checkpoint(Сars car) {
        this.car = car;
    }

    public String speedTest() {
        if (car.getSpeed() > 80.0) {
            throw new IllegalArgumentException("Не допускается превышение скорости в 80км/ч");
        }
        return "автомобиль двигается со скоростью " + car.getSpeed();
    }

    public String carChecking() {
        if (car.getWeight() > 8.0) {
            throw new ToBigweightException("Объём автомобиля превышает 8 тон: " + car.getWeight());
        } else if (car.getHeight() > 4.0 || car.getWidth() > 2.5) {
            throw new ExcessiveDimensionsException("Габариты превышают 4м и 2,5м. Указанные габариты " +
                    "равны: высота - " + car.getHeight() + " ширина - " + car.getWidth());
        }
        return "Габариты равны: высота - " + car.getHeight() + " ширина - " + car.getWidth() +
                ". Номер машины " + car.getCarNumber() + " Тип машины " + car.getCurrentCar();
    }

    public Сars getCar() {
        return car;
    }

    public void setCar(Сars car) {
        this.car = car;
    }
}
