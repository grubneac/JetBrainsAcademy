package lambda;

import java.util.function.Function;

public class FunctionLambda {
    private static Function<String, Integer> len= s -> s.length();
    private static final String hello = "Hello, ";

    public static void main(String[] args) {
        FunctionLambda fa = new FunctionLambda();
        fa.printFunctionLambda(len,"Hello lambda world!");
        fa.printFunctionLambda(s -> s.length(), "Text");
        fa.printFunctionLambda(s -> {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    count++;
                }
            }
            return count;
        }, "212 kklj 2323");

        Function<String, String> helloFunction = (name) -> hello + name;

        System.out.println(helloFunction.apply("John"));
        System.out.println(helloFunction.apply("Anastasia"));
    }


    private void  printFunctionLambda(Function<String, Integer> fun, String str){
        System.out.println(fun.apply(str));
    }

}
