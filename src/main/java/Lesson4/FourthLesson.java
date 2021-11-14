package Lesson4;

public class FourthLesson {

    public static void main(String[] args) {
        System.out.println(squareRoot(121));
    }

    public static int squareRoot(int num) {
        int degree = 1;
        if (num < 2) {
            return 0;
        }
        while (degree * degree <= num) {
            if(degree * degree == num){
                return degree;
            }
            degree++;
        }

        return 0;
    }
}
