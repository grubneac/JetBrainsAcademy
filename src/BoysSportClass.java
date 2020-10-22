import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BoysSportClass {

    Integer[] sportClass = new Integer[3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BoysSportClass boysSportClass = new BoysSportClass();

        for (int i = 0; i < boysSportClass.sportClass.length; i++) {
            boysSportClass.sportClass[i] = scanner.nextInt();
        }
        boolean sortAsc = boysSportClass.isSortAsc();
        boolean sortDes = boysSportClass.isSortDesc();

        if (sortAsc && !sortDes || !sortAsc && sortDes || boysSportClass.allEqual()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    private boolean allEqual() {
        if (sportClass[0].equals(sportClass[1]) && sportClass[1].equals(sportClass[2])) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isSortDesc() {
        Integer[] boysDesc = new Integer[sportClass.length];
        for (int i = 0; i < sportClass.length; i++) {
            boysDesc[i] = sportClass[i];
        }
        Arrays.sort(boysDesc, Collections.reverseOrder());

        for (int i = 0; i < boysDesc.length; i++) {
            if (sportClass[i] != boysDesc[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean isSortAsc() {
        Integer[] boysAsc = new Integer[sportClass.length];
        for (int i = 0; i < sportClass.length; i++) {
            boysAsc[i] = sportClass[i];
        }
        Arrays.sort(boysAsc);

        for (int i = 0; i < boysAsc.length; i++) {
            if (sportClass[i] != boysAsc[i]) {
                return false;
            }
        }

        return true;
    }
}
