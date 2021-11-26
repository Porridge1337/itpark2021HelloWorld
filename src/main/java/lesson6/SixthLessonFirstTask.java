package lesson6;

import java.util.Scanner;

public class SixthLessonFirstTask {
    public static void main(String[] args) {
        double[] numbers = fillArray(printNumber());
        System.out.println("--------------------------");
        System.out.println(maxNumber(numbers) + " - максимальное значение");
        System.out.println(minNumber(numbers) + " - минимальное значение");
        System.out.println(average(numbers) + " - среднее значение");

    }

    public static double maxNumber(double[] array) {
        double num = array[0];

        for (int i = 0; i <= array.length - 1; i++) {
            if (num < array[i]) num = array[i];
        }
        return num;
    }

    public static double minNumber(double[] array) {
        double num = array[0];

        for (int i = 0; i <= array.length - 1; i++) {
            if (num > array[i]) num = array[i];
        }
        return num;
    }

    public static double average(double[] array) {
        double num = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            num += array[i];
        }
        return num / array.length;
    }

    public static int printNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Укажите размер массива: ");
        while (!sc.hasNextInt()) {
            String error = sc.next();
            System.out.println("Ошибка, введено: " + error);
            System.out.print("Введите пожалуйста число: ");
        }
        return sc.nextInt();
    }

    public static double[] fillArray(int size) {
        double numbers[] = new double[size];
        for (int i = 0; i <= numbers.length - 1; i++) {
            numbers[i] = Math.round(Math.random() * 1000.0) / 1000.0;
            System.out.println(numbers[i]);
        }
        return numbers;
    }
}
