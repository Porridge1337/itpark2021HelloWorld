package Lesson5;

import java.util.Scanner;

public class FifthLesson {

    public static void main(String[] args) {
        System.out.println(recursionFibonacci(enterNumber()));
        System.out.println(fibonacci(enterNumber()));
    }

    public static int fibonacci(int n) {
        int mem = 0;
        int number = 1;

        if (n < 2) return n;
        for (int i = 2; i <= n; i++) {
            number += mem;
            mem = number - mem;
        }
        return number;
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

    public static int enterNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите пожалуйста число: ");
        while (!sc.hasNextInt()) {
            String error = sc.next();
            System.out.println("Ошибка, введено: " + error);
            System.out.print("Введите пожалуйста число: ");
        }
        return sc.nextInt();
    }
}
