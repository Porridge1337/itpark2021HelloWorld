package lesson8.matrix;

public class Matrix {

    private int[][] matrix;
    private int[][] identityMatrix;
    int determinant;

    public Matrix() {
        this.matrix = new int[2][2];
        this.identityMatrix = new int[2][2];
        matrix = fillArray(matrix);
    }

    public Matrix(int size) {
        this.matrix = new int[size][size];
        this.identityMatrix = new int[size][size];
        matrix = fillArray(matrix);
    }

    public Matrix(int[][] matrix, int[][] identityMatrix) {
        this.matrix = matrix;
        this.identityMatrix = identityMatrix;
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        this.identityMatrix = new int[matrix.length][matrix.length];
    }

    public void printSize() {
        System.out.println(matrix.length + " " + matrix[0].length + " - размер матрицы");
    }

    public void printMatrix(String choose) { // при неверном выборе типа вывода - в консоль ничго не поступит
        while (choose.equals("matrix") || choose.equals("identity")) {
            for (int i = 0; i <= matrix.length - 1; i++) {
                for (int j = 0; j <= matrix[i].length - 1; j++) {
                    if (choose.equals("matrix")) {
                        System.out.print(matrix[i][j] + " | ");
                    } else if (choose.equals("identity")) {
                        System.out.print(identityMatrix[i][j] + " | ");
                    }
                }
                System.out.println();
            }
            choose = "stop";
        }
    }

    private int[][] fillArray(int[][] array) {
        for (int i = 0; i <= matrix.length - 1; i++) {
            for (int j = 0; j <= matrix[i].length - 1; j++) {
                matrix[i][j] = (int) Math.round((Math.random() * 21) - 11);
            }
        }
        return array;
    }

    public int getDeterminant() {
        return determinant;
    }

    public void setDeterminant(int determinant) {
        this.determinant = determinant;
    }

    public int getMatrixSize() {
        return matrix.length;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getIdentityMatrix() {
        return identityMatrix;
    }

    public void setIdentityMatrix(int[][] identityMatrix) {
        this.identityMatrix = identityMatrix;
    }
}
