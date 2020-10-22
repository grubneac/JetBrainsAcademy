import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.println(convertDouble(a));
//        double b = scanner.nextDouble();
//        double c = scanner.nextDouble();
//        double d = Math.pow(b, 2) - 4 * a * c;
//        System.out.println(d);
//        double[] arr = new double[2];
//
//
//        arr[0] = (-b + Math.sqrt(d)) / 2.0 / a;
//        arr[1] = (-b - Math.sqrt(d)) / 2.0 / a;
//
//        Arrays.stream(arr).sorted().forEach(s -> System.out.print(convertDouble(s)));


    }

    private static String convertDouble(Double inDouble) {
        int tempInt;
        Double tempDouble;
        tempInt = inDouble.intValue();
        tempDouble = (double) tempInt;
        if (!(0 > inDouble) && !(0 < inDouble) ) return "0";
        if (tempDouble.equals(inDouble)) {
            return String.format("%.0f ", inDouble);
        } else {
            DecimalFormat d = new DecimalFormat("0.0#");
            d.setRoundingMode(RoundingMode.DOWN);

            return d.format(inDouble);
        }
    }
}
