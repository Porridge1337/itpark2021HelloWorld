package lesson8.matrix;

public class MatrixRunner {

    public static void main(String[] args) {
        try {
            Matrix a = new Matrix();
            a.fillArray();
            a.printMatrix();
            System.out.println("Определитель матрицы имеет значение: " + Matrix.determinant(a.getArray(),a.getArraySize()));
            System.out.println("----------------------------");

            Matrix b = new Matrix();
            b.fillArray();
            b.printMatrix();
            System.out.println("----------------------------");

            Matrix sum = a.calculation(b, "sum");
            System.out.println("Сложение матрицы на матрицу ");
            sum.printMatrix();
            System.out.println("----------------------------");

            a.multiplyOnNumber(2);
            a.printMatrix();
            System.out.println("Умножение матрицы на 2");
            System.out.println("---------------------");

            a.identityMatrix();
            a.printMatrix();
            System.out.println("---------------------");
            System.out.println("Вывод единичной матрицы 6х6");
            Matrix.identityMatrixStatic(6).printMatrix();
            System.out.println("---------------------");
           Matrix invert = b.invertMatrix();
           invert.printMatrix();
            System.out.println("-----------------------");
            Matrix power = sum.powerMatrix(2);
            power.printMatrix();
            System.out.println("Вывод возведения в степень матрицы");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
