package recursion;

import java.util.Scanner;

public class NumberOfDecompositionsVerOlga {
//    static int contor = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countTo = scanner.nextInt();
        for (int i = 1; i < countTo; i++) {
            makeLInes(i + " ", i, countTo - i);
        }
        System.out.println(countTo);
//        System.out.println(++contor);
    }

    public static void makeLInes(String strInit, int nrMax, int countTo) {
        for (int nrStart = 1; nrStart <= nrMax; nrStart++) {
            if (nrStart == 1) {
                String repeated = new String(new char[countTo]).replace("\0", "1 ");
                System.out.println(strInit + repeated);
//                contor++;
            }
            if (nrMax >= nrStart + 1 && countTo > nrStart) {
                makeLInes(strInit + (nrStart + 1) + " ", nrStart + 1, countTo - nrStart - 1);
            }
        }
    }
}

