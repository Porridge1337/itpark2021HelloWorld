package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class SixthLessonSecondTask {

    public static void main(String[] args) {
        int[] cache = new int[10];
        String proceed = "y";
        while (proceed.equals("y")) {
            int num = printNumber() - 1;
            cache = isExceed(cache, num + 1);
            if (getArrayIndex(cache, num) != num) {
                putInCash(cache, num, recursionFibonacci(num + 1));
            }
            System.out.println("Результат = " + cache[num]);
            System.out.println("Если хотите продолжить - нажмите 'y', если остановиться - любую другую кнопку");
            proceed = printLetter();
        }
        System.out.println("Программа закончила выполнение");
    }

    public static int recursionFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursionFibonacci(n - 1) + recursionFibonacci(n - 2);
        }
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
            if (array[i] == array[number]) {
                return i;
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
        return sc.nextInt();
    }

    public static String printLetter() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
