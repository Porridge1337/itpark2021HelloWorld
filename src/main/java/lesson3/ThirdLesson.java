package lesson3;

import java.util.Scanner;

public class ThirdLesson {

    public static void main(String[] args) {
        System.out.println(factorial(6));
        quadraticEquation(8, 5, 1);
    }

    public static void quadraticEquation(double a, double b, double c) {
        double discriminant;
        double x1;
        double x2;

        if (a == 0) {
            System.out.println("Первый коэффициент не может быть 0");
            return;
        }
        discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            System.out.println(discriminant + " < " + 0 + ". \nКорней нет");
            return;
        } else if (discriminant == 0) {
            x1 = -b / (2 * a);
            System.out.println(discriminant + " = " + 0 + "\nx = " + x1);
        } else {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(discriminant + " > " + 0 + "\nx1 = " + x1 + " x2 = " + x2);
            return;
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(--n);
    }
}
