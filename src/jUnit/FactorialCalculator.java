package jUnit;

public class FactorialCalculator {
    public static void main(String[] args) {
        FactorialCalculator fc = new FactorialCalculator();
        System.out.println(fc.get(2));
    }

    public long get(int x) {
        long result;
        if (x < 0) {
            result = -1;
        } else if (x == 0 || x == 1) {
            result = 1;
        } else {
            result = x * get(x - 1);
        }

        return result;
    }
}
