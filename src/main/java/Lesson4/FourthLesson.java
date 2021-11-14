package Lesson4;

public class FourthLesson {

    public static void main(String[] args) {
        System.out.println(squareRoot(64));
    }

    public static int squareRoot(int num) {
        int degree = 1;
        if (num < 2) {
            return num;
        }
        while (degree * degree <= num) {
            degree++;
        }
        return --degree;
    }
}
