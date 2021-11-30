package lesson8.matrix;

public class MatrixRunner {

    public static void main(String[] args) {

        Matrix m = new Matrix();
        m.setIdentityMatrix(MatrixCalculation.fillIdentityMatrix(m.getMatrix().length));
        m.printMatrix("matrix");
        System.out.println("------------------");
        m.printMatrix("identity");
        m.getSize();

        Matrix n = new Matrix();
        n.printMatrix("matrix");
        n.getSize();
        System.out.println("----------------------------------------");

        Matrix x = new Matrix();
        x.printMatrix("matrix");
        x.setMatrix(MatrixCalculation.invertMatrix(x.getMatrix()));
        x.printMatrix("matrix");
        System.out.println("----------------------------------------");

        MatrixCalculation calculation = new MatrixCalculation();
        Matrix n1 = new Matrix(MatrixCalculation.calculation(m.getMatrix(),n.getMatrix(), "multiply"));
        n1.printMatrix("matrix");
        System.out.println("---------------------");
        Matrix n2 = new Matrix(MatrixCalculation.powerMatrix(m.getMatrix(),2));
        n2.printMatrix("matrix");


    }

}
