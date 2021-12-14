package lesson12;

import lesson12.exceptions.MyArrayDataException;
import lesson12.exceptions.MyArraySizeException;

public class CalculationRunner {

    public static void main(String[] args) {
        try {
            Matrix matrix = new Matrix(4);
            System.out.println(matrix.getMatrix());
            System.out.println("Сумма всех эллементов матрицы равна: " + matrix.calculate());
            Matrix matrix2 = new Matrix(3);
            System.out.println(matrix2.getMatrix());
            System.out.println("Сумма всех эллементов матрицы равна: " + matrix2.calculate());
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Ошибка в MyArraySizeException");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Ошибка в MyArrayDataException");
        } finally {
            System.out.println("Программа закончила выполнение");
        }
    }


}
