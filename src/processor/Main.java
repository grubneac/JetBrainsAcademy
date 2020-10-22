package processor;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int actionChoose;
        while (true) {
            System.out.println("1. Add matrices\n" +
                    "2. Multiply matrix by a constant\n" +
                    "3. Multiply matrices\n" +
                    "4. Transpose matrix\n" +
                    "5. Calculate a determinant\n" +
                    "6. Inverse matrix\n" +
                    "0. Exit");

            System.out.print("Your choice: ");
            actionChoose = scanner.nextInt();
            switch (actionChoose) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    multiplyMatricesByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 4:
                    boolean returnFlag = transposeMatrices();
                    if (returnFlag) {
                        return;
                    }
                    break;
                case 5:
                    calcDeterminant();
                    break;
                case 6:
                    inverseMatrix();
                    break;
                default:
                    return;
            }
        }
    }

    private static void inverseMatrix() {
        Matrix a = new Matrix();
        a.initArray("");
        a.fillMatrix("");

        Matrix result = Matrix.inverseMatrix(a);

        if (result == null) {
            System.out.println("This matrix doesn't have an inverse.\n");
        } else {
            System.out.println(result);
        }
    }

    private static void calcDeterminant() {
        Matrix a = new Matrix();
        a.initArray("");
        a.fillMatrix("");

        double result = Matrix.calcDeterminant(a);
        System.out.println("The result is:");
        if (result == 0) {
            System.out.println("The operation cannot be performed.\n");
        } else {
            System.out.println(Matrix.convertDouble(result));
            System.out.println();
        }
    }

    private static boolean transposeMatrices() {
        System.out.printf("\n1. Main diagonal\n2. Side diagonal\n3. Vertical line\n4. Horizontal line%n");
        System.out.print("Your choice: ");
        int action = scanner.nextInt();

        Matrix a = new Matrix();
        Matrix result;
        switch (action) {
            case 1:
                a.initArray("");
                a.fillMatrix("");
                result = Matrix.mainDiagonal(a);
                break;
            case 2:
                a.initArray("");
                a.fillMatrix("");
                result = Matrix.sideDiagonal(a);
                break;
            case 3:
                a.initArray("");
                a.fillMatrix("");
                result = Matrix.verticalLine(a);
                break;
            case 4:
                a.initArray("");
                a.fillMatrix("");
                result = Matrix.horizontalLine(a);
                break;
            default:
                return true;
        }
        if (result == null) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println(result);
        }
        return false;
    }

    private static void multiplyMatrices() {
        Matrix a = new Matrix();
        a.initArray(" first");
        a.fillMatrix(" first");

        Matrix b = new Matrix();
        b.initArray(" second");
        b.fillMatrix(" second");

        Matrix result = Matrix.multiplyMatrix(a, b);
        if (result == null) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println(result);
        }
    }

    private static void multiplyMatricesByConstant() {
        Matrix a = new Matrix();
        a.initArray("");
        a.fillMatrix("");

        System.out.print("Enter constant: ");
        int b = scanner.nextInt();

        Matrix result = Matrix.multiplicationByNumber(a, b);
        System.out.println(result);
    }


    private static void addMatrices() {
        Matrix a = new Matrix();
        a.initArray(" first");
        a.fillMatrix(" first");

        Matrix b = new Matrix();
        b.initArray(" second");
        b.fillMatrix(" second");

        Matrix result = Matrix.addMatrix(a, b);
        if (result == null) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println(result);
        }
    }
}

class Matrix {
    private final Scanner scanner = new Scanner(System.in);

    private Double[][] arr;
    private Integer row;
    private Integer column;

    public Matrix() {
    }

    public static double calcDeterminant(Matrix a) {
        double determinant = 0;

        if (a.row.equals(a.column)) {

            if (a.row == 1) {
                determinant += a.arr[0][0];
            } else if (a.row == 2) {
                determinant += a.arr[0][0] * a.arr[1][1] - a.arr[1][0] * a.arr[0][1];
            } else {
                for (int i = 0; i < a.column; i++) {
                    double sign = Math.pow(-1, i);
                    determinant += a.arr[0][i] * sign * calcDeterminant(getMatrix(a, 0, i));
                }
            }
        }

        return determinant;

    }


    private static Matrix getMatrix(Matrix a, int delRow, int delColumn) {
        Matrix result = new Matrix();
        result.row = a.row - 1;
        result.column = a.column - 1;
        result.initArray("");
        int currRow;
        int currCol;

        for (int i = 0; i < a.row; i++) {
            if (i != delRow) {
                currRow = i;
                if (i > delRow) {
                    currRow = i - 1;
                }
                for (int j = 0; j < a.column; j++) {
                    if (j != delColumn) {
                        currCol = j;
                        if (j > delColumn) {
                            currCol = j - 1;
                        }
                        result.arr[currRow][currCol] = a.arr[i][j];
                    }
                }
            }
        }

        return result;
    }


    public void initDimension(String nameMatrix) {
        if (!"notHeader".equals(nameMatrix)) {
            System.out.println("Enter size of" + nameMatrix + " matrix: ");
        }
        Integer[] dimArray = Arrays.stream(scanner.nextLine()
                .split("\\s"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);

        Integer theRow = dimArray[0];
        Integer theCol = dimArray[1];

        this.row = theRow;
        this.column = theCol;
    }

    public void initArray(String nameMatrix) {
        if (row == null && column == null) {
            initDimension(nameMatrix);
        }
        arr = new Double[row][column];
    }

    public void fillMatrix(String nameMatrix) {
        System.out.println("Enter" + nameMatrix + " matrix:");
        for (int i = 0; i < row; i++) {
            Double[] dimArray = Arrays.stream(scanner.nextLine()
                    .split("\\s"))
                    .map(Double::valueOf)
                    .toArray(Double[]::new);
            if (column >= 0) System.arraycopy(dimArray, 0, arr[i], 0, column);
        }
    }

    public static Matrix inverseMatrix(Matrix a) {
        Matrix result = null;
        double determinant = Matrix.calcDeterminant(a);
        if (determinant != 0) {
            Matrix adjMatrix = adjugate(a);

            result = multiplicationByNumber(adjMatrix, 1 / determinant);
        }

        return result;
    }

    private static Matrix adjugate(Matrix a) {
        Matrix result = new Matrix();
        result.row = a.row;
        result.column = a.column;
        result.initArray("notHeader");
        for (int i = 0; i < a.column; i++) {
            for (int j = 0; j < a.column; j++) {
                double sign = Math.pow(-1, i + j);
                double minor = sign * calcDeterminant(getMatrix(a, j, i));
                result.arr[i][j] = minor;
            }
        }

        return result;
    }

    public static Matrix addMatrix(Matrix a, Matrix b) {
        Matrix result = null;

        if (a.row.equals(b.row) && a.column.equals(b.column)) {
            result = new Matrix();
            result.row = a.row;
            result.column = a.column;
            result.initArray("notHeader");

            for (int i = 0; i < result.row; i++) {
                for (int j = 0; j < result.column; j++) {
                    result.arr[i][j] = a.arr[i][j] + b.arr[i][j];
                }
            }
        }

        return result;
    }

    public static Matrix multiplyMatrix(Matrix a, Matrix b) {
        Matrix result = null;

        if (a.column.equals(b.row)) {
            result = new Matrix();
            result.row = a.row;
            result.column = b.column;
            result.initArray("notHeader");

            for (int i = 0; i < result.row; i++) {
                for (int j = 0; j < result.column; j++) {
                    int arrLen = a.arr[i].length;
                    result.arr[i][j] = 0.0;
                    for (int k = 0; k < arrLen; k++) {
                        result.arr[i][j] += a.arr[i][k] * b.arr[k][j];
                    }
                }
            }
        }
        return result;
    }

    public static Matrix multiplicationByNumber(Matrix a, double b) {
        for (int i = 0; i < a.row; i++) {
            for (int j = 0; j < a.column; j++) {
                a.arr[i][j] *= b;
            }
        }

        return a;
    }

    public static Matrix mainDiagonal(Matrix a) {
        Matrix result = null;

        if (a.row.equals(a.column)) {
            result = new Matrix();
            result.row = a.row;
            result.column = a.column;
            result.initArray("notHeader");

            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.column; j++) {
                    result.arr[j][i] = a.arr[i][j];
                }

            }

        }
        return result;
    }

    public static Matrix sideDiagonal(Matrix a) {
        Matrix result = null;

        if (a.row.equals(a.column)) {
            result = new Matrix();
            result.row = a.row;
            result.column = a.column;
            result.initArray("notHeader");

            for (int i = 0; i < a.row; i++) {
                for (int j = 0; j < a.column; j++) {
                    result.arr[a.row - 1 - j][a.column - 1 - i] = a.arr[i][j];
                }

            }

        }
        return result;
    }

    public static Matrix verticalLine(Matrix a) {
        Matrix result;

        result = new Matrix();
        result.row = a.row;
        result.column = a.column;
        result.initArray("notHeader");

        for (int i = 0; i < a.row; i++) {
            for (int j = 0; j < a.column; j++) result.arr[i][a.column - 1 - j] = a.arr[i][j];

        }
        return result;
    }

    public static Matrix horizontalLine(Matrix a) {
        Matrix result;

        result = new Matrix();
        result.row = a.row;
        result.column = a.column;
        result.initArray("notHeader");

        for (int i = 0; i < a.row; i++) {
            if (a.column >= 0) System.arraycopy(a.arr[i], 0, result.arr[a.row - 1 - i], 0, a.column);

        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("The result is:").append("\n");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.append(convertDouble(arr[i][j])).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static String convertDouble(Double inDouble) {
        if (!(0 > inDouble) && !(0 < inDouble)) return "0";  // for -0.00
        int tempInt;
        Double tempDouble;
        tempInt = inDouble.intValue();
        tempDouble = (double) tempInt;
        if (tempDouble.equals(inDouble)) {
            return String.format("%.0f ", inDouble);
        } else {
            return String.format("%.2f ", inDouble);
        }
    }

}
