package lesson8.matrix;

public class MatrixRunner {

    public static void main(String[] args) {

        Matrix m = new Matrix();
        m.setIdentityMatrix(MatrixCalculation.fillIdentityMatrix(m.getMatrixSize()));
        m.printMatrix("matrix");
        System.out.println("------------------");
        m.printMatrix("identity");
        m.printSize();
        System.out.println("------------------");

        Matrix n = new Matrix(5);
        n.setIdentityMatrix(MatrixCalculation.fillIdentityMatrix(n.getMatrixSize()));
        n.printMatrix("matrix");
        System.out.println("------------------");
        n.printMatrix("identity");
        n.printSize();
        System.out.println("------------------");

        Matrix x = new Matrix();
        System.out.println("матрица до инвертирования");
        x.printMatrix("matrix");
        System.out.println("после инвертирования");
        x.setMatrix(MatrixCalculation.invertMatrix(x.getMatrix()));
        x.printMatrix("matrix");
        System.out.println("----------------------------------------");

        Matrix n1 = new Matrix(MatrixCalculation.calculation(m.getMatrix(),x.getMatrix(), "multiply"));
        n1.printMatrix("matrix");
        System.out.println("---------------------");
        Matrix n2 = new Matrix(MatrixCalculation.powerMatrix(m.getMatrix(),2));
        n2.printMatrix("matrix");
        System.out.println("---------------------");
        Matrix n3 = new Matrix(MatrixCalculation.multiplyOnNumber(m.getMatrix(), 4));
        n3.printMatrix("matrix");
        n3.setDeterminant(MatrixCalculation.determinant(n3.getMatrix(), n3.getMatrixSize()));
        System.out.println(n3.getDeterminant());


    }

}
