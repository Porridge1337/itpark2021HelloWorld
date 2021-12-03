package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class SixthLessonSecondTask {

    public static void main(String[] args) {
        int[] cache = new int[10];
        String proceed = "y";
        while (proceed.equals("y")) {
            int num = printNumber();
            cache = isExceed(cache, num);
            if (getArrayIndex(cache, num) != num) {
                cache = fibonacci(num, cache);
            }
            System.out.println("Результат = " + cache[num - 1]);
            System.out.println("Если хотите продолжить - нажмите 'y', если остановиться - любую другую кнопку");
            proceed = printLetter();
        }
        System.out.println("Программа закончила выполнение");
    }

    public static int[] fibonacci(int n, int[] array) {
        int mem = 0;
        int number = 1;
        for (int i = 0; i <= n - 1; i++) {
            number += mem;
            array[i] = number;
            mem = number - mem;
        }
        return array;
    }

    public static int[] isExceed(int[] cache, int index) {
        if (cache.length < index) {
            cache = resizeCache(cache, index);
        }
        return cache;
    }

    public static int[] resizeCache(int[] cache, int newSize) {
        return Arrays.copyOf(cache, newSize);
    }

    public static void putInCash(int cache[], int index, int num) {
        cache[index] = num;
    }

    public static int getArrayIndex(int[] array, int number) {
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] == array[number - 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int printNumber() {
        System.out.print("Введите число: ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            String error = sc.next();
            System.out.println("Ошибка, введено: " + error);
            System.out.print("Введите пожалуйста число: ");
        }
        int length = sc.nextInt();
        if (length <= 0) {
            System.out.println("Указано отрицательное число, введите заного");
            return printNumber();
        }
        return length;
    }

    public static String printLetter() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
