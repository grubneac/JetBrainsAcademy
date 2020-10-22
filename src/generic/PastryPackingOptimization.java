package generic;

import java.util.ArrayList;
import java.util.Arrays;

public class PastryPackingOptimization {
    public static void main(String[] args) {
        Box2<Cake2> cake = new Box2<>();
        cake.put(new Cake2());

        Box2<Pie2> pieBox2 = new Box2<>();
        pieBox2.put(new Pie2());

        Box2<Tart2> tartBox2 = new Box2<>();
        tartBox2.put(new Tart2());

        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

        for (String name : nameList) {
            System.out.println(name);
        }

    }

}
/**
 Box for cakes
 */
class CakeBox {

    private Cake2 cake;

    public void put(Cake2 cake) {
        this.cake = cake;
    }

    public Cake2 get() {
        return this.cake;
    }
}

/**
 Box for pies
 */
class PieBox {

    private Pie2 pie;

    public void put(Pie2 pie) {
        this.pie = pie;
    }

    public Pie2 get() {
        return this.pie;
    }
}


/**
 Box for tarts
 */
class TartBox {

    private Tart2 tart;

    public void put(Tart2 tart) {
        this.tart = tart;
    }

    public Tart2 get() {
        return this.tart;
    }
}

/*
    Hundred more such boring classes OR ...
    magic class for everything everybody is waiting for
*/
class Box2<T>{
    private T t;

    public T get() {
        return t;
    }

    public void put(T t) {
        this.t = t;
    }
}

// Don't change classes below
class Cake2 { }

class Pie2 { }

class Tart2 { }