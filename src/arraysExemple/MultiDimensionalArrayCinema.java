package arraysExemple;

import java.util.Scanner;

public class MultiDimensionalArrayCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] seatsArr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                seatsArr[i][j] = scanner.nextInt();
            }
        }

        int seatsInRow = scanner.nextInt();
        System.out.println(getRowWithFreeSeats(seatsArr, seatsInRow));


    }

    private static int getRowWithFreeSeats(int[][] seatsArr, int seatsInRow) {
        int currSeatsInRow = 0;
        for (int i = 0; i < seatsArr.length; i++) {
            for (int j = 0; j < seatsArr[i].length; j++) {
                if (seatsArr[i][j] == 0){
                    currSeatsInRow++;
                    if (currSeatsInRow >= seatsInRow){
                        return (i+1);
                    }
                } else {
                    currSeatsInRow = 0;
                }
            }
            currSeatsInRow = 0;
        }
        return 0;
    }
}
