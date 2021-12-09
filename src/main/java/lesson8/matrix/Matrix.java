package lesson8.matrix;

public class Matrix {

    private int[][] array;
    private final int size;

    public Matrix() {
        this(2);
    }

    public Matrix(int size) {
        this.size = size;
        this.array = new int[size][size];
    }

    public void printSize() {
        System.out.println(this.array.length + " " + this.array[0].length + " - размер матрицы");
    }

    public void printMatrix() {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j <= array[i].length - 1; j++) {
                System.out.print(array[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void fillArray() {
        for (int i = 0; i <= this.array.length - 1; i++) {
            for (int j = 0; j <= this.array[i].length - 1; j++) {
                this.array[i][j] = (int) Math.round((Math.random() * 21) - 11);
            }
        }
    }

    public Matrix calculation(Matrix matrix, String action) throws Exception {
        if (this.size != matrix.size) throw new Exception("Matrix size is not equal ");
        Matrix result = new Matrix(matrix.array.length);
        for (int i = 0; i <= this.array.length - 1; i++) {
            for (int j = 0; j <= this.array[i].length - 1; j++) {
                switch (action) {
                    case ("sum"):
                        result.array[i][j] = this.array[i][j] + matrix.array[i][j];
                        break;
                    case ("sub"):
                        result.array[i][j] = this.array[i][j] - matrix.array[i][j];
                        break;
                    case ("multiply"):
                        for (int k = 0; k <= this.array.length - 1; k++) {
                            result.array[i][j] += this.array[i][k] * matrix.array[k][j];
                        }
                        break;
                    default: //если неправильно указано действие,то возвращается нулевая матрица
                        return result;
                }
            }
        }
        return result;
    }

    public Matrix multiplyOnNumber(int coefficient) {
        Matrix result = new Matrix(array.length);
        for (int i = 0; i <= this.array.length - 1; i++) {
            for (int j = 0; j <= this.array[i].length - 1; j++) {
                array[i][j] *= coefficient;
            }
        }
        return result;
    }

    public Matrix identityMatrix() {
        Matrix result = new Matrix(array.length);
        for (int i = 0; i <= this.array.length - 1; i++) {
            for (int j = 0; j <= this.array[i].length - 1; j++) {
                array[i][j] = i == j ? 1 : 0;
            }
        }
        return result;
    }

    public static Matrix identityMatrixStatic(int dimension) {
        Matrix result = new Matrix(dimension);
        for (int i = 0; i <= dimension - 1; i++) {
            for (int j = 0; j <= dimension - 1; j++) {
                result.array[i][j] = i == j ? 1 : 0;
            }
        }
        return result;
    }

    public static int determinant(int[][] arr, int n) {
        if (n == 1) {
            return arr[0][0];
        }
        if (n == 2) {
            return arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0]; // ad-bc
        }
        int d = 0;
        int sign = -1;
        for (int skipCol = 0; skipCol < n; ++skipCol) {
            int[][] matrix = new int[n - 1][n - 1];
            for (int row = 0; row < n - 1; ++row) {
                int matrixCol = 0;
                for (int col = 0; col < n; ++col)
                    if (col != skipCol) {
                        matrix[row][matrixCol++] = arr[row + 1][col];
                    }
            }
            d += (sign *= -1) * arr[0][skipCol] * determinant(matrix, n - 1);
        }
        return d;
    }
    public Matrix invertMatrix() {
        Matrix result = new Matrix(this.array.length);
        for (int i = 0; i <= this.array.length - 1; i++) {
            for (int j = 0; j <= this.array[i].length - 1; j++) {
                result.array[i][j] = this.array[i][j] * -1;
            }
        }
        return result;
    }

    public Matrix powerMatrix(int degree ) {
        Matrix matrix = new Matrix(this.array.length);
        int [][] matrixArray = this.array;
        for (int i = 1; i < degree; i++) {
            matrixArray = exponentiation(matrixArray);
        }
        matrix.setArray(matrixArray);
        return matrix;
    }

    private  int[][] exponentiation(int[][] matrixArray) {
        int[][] array = new int[this.array.length][this.array.length];
        for (int i = 0; i <= this.array.length - 1; i++) {
            for (int j = 0; j <= this.array[i].length - 1; j++) {
                for (int k = 0; k <= this.array.length - 1; k++) {
                    array[i][j] += this.array[i][k] * matrixArray[k][j];
                }
            }
        }
        return array;
    }

    public int getArraySize() {
        return array.length;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

}
