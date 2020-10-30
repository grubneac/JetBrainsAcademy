package arraysExemple;
/*
Output the matrix of size n×n, filled by the integers from 1 to n*n  in a spiral,
coming from the top left corner and twisted clockwise, as shown in the example (here n=5).
Sample Input 1:

5
Sample Output 1:

1 2 3 4 5
16 17 18 19 6
15 24 25 20 7
14 23 22 21 8
13 12 11 10 9
 */

import java.util.Scanner;

public class MultiDimensionalArraySpiral {

    static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        arr = new int[size][size];

//        printArr();
        int counter = 1;
        int maxSize = (int) Math.pow(size, 2);

        Posision curPosision = new Posision(0, 0, Direction.RIGHT);
        while (counter <= maxSize) {
            curPosision = nextStep(curPosision, counter);

            counter++;
        }
//        System.out.println("-----------------------");
        printArr();
    }

    private static Posision nextStep(Posision cp, int counter) {
        arr[cp.getRow()][cp.getCol()] = counter;
        int nextCol;
        int nextRow;
        if (cp.getDist().equals(Direction.RIGHT)) {
            nextCol = cp.getCol() + 1;
            nextRow = cp.getRow() + 1;
            if (nextCol < arr.length && arr[cp.getRow()][nextCol] == 0) {
                cp.setCol(nextCol);
            } else {
                cp.setDist(Direction.DOWN);
                cp.setRow(nextRow);
            }
            return cp;
        }

        if (cp.getDist().equals(Direction.DOWN)) {
            nextCol = cp.getCol() - 1;
            nextRow = cp.getRow() + 1;
            if (nextRow < arr.length && arr[nextRow][cp.getCol()] == 0) {
                cp.setRow(nextRow);
            } else {
                cp.setDist(Direction.LEFT);
                cp.setCol(nextCol);
            }
            return cp;
        }

        if (cp.getDist().equals(Direction.LEFT)) {
            nextCol = cp.getCol() - 1;
            nextRow = cp.getRow() - 1;
            if (nextCol > -1 && arr[cp.getRow()][nextCol] == 0) {
                cp.setCol(nextCol);
            } else {
                cp.setDist(Direction.UP);
                cp.setRow(nextRow);
            }
            return cp;
        }

        if (cp.getDist().equals(Direction.UP)) {
            nextCol = cp.getCol() + 1;
            nextRow = cp.getRow() - 1;
            if (nextRow > -1 && arr[nextRow][cp.getCol()] == 0) {
                cp.setRow(nextRow);
            } else {
                cp.setDist(Direction.RIGHT);
                cp.setCol(nextCol);
            }
            return cp;
        }
        return cp;
    }

    private static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

enum Direction {LEFT, RIGHT, UP, DOWN}

class Posision {
    private int row;
    private int col;
    private Direction dist;

    public Posision(int row, int col, Direction dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }

    public Direction getDist() {
        return dist;
    }

    public void setDist(Direction dist) {
        this.dist = dist;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}