package lesson11;

import lesson11.cars.CarType;
import lesson11.cars.Сars;
import lesson11.exception.ExcessiveDimensionsException;
import lesson11.exception.ToBigweightException;


public class Runner {

    public static void main(String[] args) throws IllegalAccessException {
        Сars[] cars = new Сars[]{new Сars(CarType.CAR, "у654оп29", 55, 8, 3.9, 2),
                new Сars(CarType.CAR, "л654ыв11", 78, 3, 3.2, 4),
                new Сars(CarType.CAR, "в227мс41", 99, 8.1, 3, 4.4),
                new Сars(CarType.CAR, "о123ма01", 23, 5, 3.1, 6),
                new Сars(CarType.CAR, "у435ов77", 55, 2, 3.9, 254),
                new Сars(CarType.CAR, "в654оп21", 44, 5, 3.9, 2),
                new Сars(CarType.CAR, "у369оп06", 22, 8, 2.9, 4),
                new Сars(CarType.CAR, "у927рп29", 120, 8, 3.9, 2),
                new Сars(CarType.TRUCK, "у746оп19", 49, 7, 5.4, 2.1),
                new Сars(CarType.TRUCK, "у546ов51", 32, 10, 6.2, 3),
                new Сars(CarType.TRUCK, "а654оп72", 77, 20, 3.9, 1.5)
        };
        Checkpoint checkpoint = new Checkpoint(cars[0]);
        for (int i = 0; i <= cars.length - 1; i++) {
            try {
                System.out.println(checkpoint.speedTest());
                System.out.println(checkpoint.carChecking());
            } catch (IllegalArgumentException e) {
                if (cars[i].getSpeed() > 100) {
                    System.out.println("Скорость превышает 100км/ч, полиции следует задержать нарушителя. " +
                            "Гос. номера " + cars[i].getCarNumber());
                }
                e.printStackTrace();
            } catch (ToBigweightException e) {
                e.printStackTrace();
            } catch (ExcessiveDimensionsException e) {
                e.printStackTrace();
            } finally {
                System.out.println("проверка закончилась");
                checkpoint.setCar(cars[i]);
            }
        }
    }

}
