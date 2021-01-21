package lambda;

import java.util.function.Function;

public class GettingFieldsOfClasses {

    public static void main(String[] args) {

        Function<Integer, Clazz> newClazz = Clazz::new;
        Clazz instance = newClazz.apply(3);
        System.out.println("Clazz::new ");

        Function<Integer, Integer> inst = Clazz::staticMethod;
        System.out.println("Clazz::staticMethod " + inst.apply(5));

        Function<Integer, Integer> ttt = instance::instanceMethod;
        System.out.println("instance::instanceMethod " + ttt.apply(10));

        Function<Clazz, Integer> ttt2 = s -> s.magic ;





    }
}

class Clazz {
    int magic;

    public Clazz(int magic) {
        this.magic = magic;
    }

    public static int staticMethod(int a) {
        return a + a;
    }

    public int instanceMethod(int b) {
        return b * magic;
    }
}