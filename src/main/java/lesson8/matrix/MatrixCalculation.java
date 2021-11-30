package lesson8.matrix;

public class MatrixCalculation {

    private int[][] a;
    private int[][] b;

    public MatrixCalculation() {
    }

    public static int[][] calculation(int[][] a, int[][] b, String action) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= b[i].length - 1; j++) {
                switch (action) {
                    case ("sum"):
                        res[i][j] = a[i][j] + b[i][j];
                        break;
                    case ("minus"):
                        res[i][j] = a[i][j] - b[i][j];
                        break;
                    case ("multiply"):
                        for (int k = 0; k <= a.length - 1; k++) {
                            res[i][j] += a[i][k] * b[k][j];
                        }
                        break;
                    default: //если неправильно указано действие,то возвращается пустая матрица
                        return res;
                }
            }
        }
        return res;
    }

    public static int[][] powerMatrix(int[][] a, int p) {
        int[][] result = a;
        for (int n = 1; n < p; n++) {
            result = exponentiation(result, a);
        }
        return result;
    }

    private static int[][] exponentiation(int[][] a, int[][] b) {
        int[][] array = new int[a.length][b.length];
        for (int i = 0; i <= a.length - 1; i++) {
            for (int j = 0; j <= b[i].length - 1; j++) {
                for (int k = 0; k <= a.length - 1; k++) {
                    array[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return array;
    }

    public static int[][] multiplyOnNumber(int[][] array, int number) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j <= array[i].length - 1; j++) {
                array[i][j] *= number;
            }
        }
        return array;
    }

    public static int[][] invertMatrix(int[][] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++) {
                arr[i][j] *= -1;
            }
        }
        return arr;
    }

    public static int[][] fillIdentityMatrix(int length) {
        int array[][] = new int[length][length];
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j <= array[i].length - 1; j++) {
                array[i][j] = i == j ? 1 : 0;
            }
        }
        return array;
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

}
