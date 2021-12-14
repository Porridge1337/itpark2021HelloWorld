package lesson12;

import lesson12.exceptions.MyArrayDataException;
import lesson12.exceptions.MyArraySizeException;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix {

    private List<List<String>> matrix = new ArrayList<List<String>>();

    public Matrix(int size) {
        if (size != 4) {
            throw new MyArraySizeException("Неверно указана длина массива: " + size + "x" + size + ". Массив строго" +
                    " должен иметь размер: 4х4");
        }
        fillUp(size);
    }

    private List<List<String>> fillUp(int size) {
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                if (j == 0) {
                    matrix.add(new ArrayList<String>());
                }
                matrix.get(i).add(print());
            }
        }
        return matrix;
    }

    private String print() {
        System.out.print("Введите число:");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        return number;
    }

    private boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public int calculate() {
        int result = 0;
        for (int i = 0; i <= this.matrix.size() - 1; i++) {
            for (int j = 0; j <= this.matrix.size() - 1; j++) {
                if (!isNumeric(this.matrix.get(i).get(j))) {
                    throw new MyArrayDataException("В ячейках " + i + "х" + j + " указан символ вместо числа"
                            + "'" + this.matrix.get(i).get(j) + "'");
                }
                result += Integer.valueOf(this.matrix.get(i).get(j));
            }
        }
        return result;
    }

    public List<List<String>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<String>> matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + matrix +
                '}';
    }
}
