package Lesson2;

public class SecondProgram {

    public static void main(String[] args) {
        System.out.println("деление " + divide(10,8));
        System.out.println("вычитание " + subtract(5,88));
        System.out.println("умножение " + multiply(5,5));
        System.out.println("деление " + sum(36, 6));
        System.out.println( formula(20.22,5,"I"));
    }


    public static int sum (int arg1, int arg2){
        return arg1+arg2;
    }
    public static int subtract(int arg1, int arg2){
        return arg1-arg2;
    }
    public static int multiply (int arg1, int arg2){
        return arg1*arg2;
    }
    public static double divide(int arg1, int arg2){
        return arg1/arg2;
    }

    /**
     *аргументы указывать в зависимости от формулы:
     * I=V/R - вычисление силы тока,
     * V=I*R - вычисление напряжения,
     * R=V/I - вычисление сопротивления
     * @param arg1 первый аргумент
     * @param arg2  второй аргумент
     * @param type тип вычисляемой формулы:
     *             I-сила тока;
     *             V- напряжение;
     *             R-сопротивление;
     * @return возвращает результат формулы в зависимости от выбранного типа, если неправильно указан тип -
     * возвращает 0
     */
    public static double formula(double arg1, double arg2, String type){
        switch (type){
            case "I":
                System.out.print("I = ");
                return arg1/arg2;
            case "V":
                System.out.print("V = ");
                return arg1*arg2;
            case "R":
                System.out.print("R = ");
                return arg1/arg2;
            default:
                System.out.print("неверно указан тип рассчитываемой формулы ");
                return 0;
        }
    }
}

