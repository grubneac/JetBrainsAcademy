package generic;

public class PackingBackeries {
}

/**
 This packer has too much freedom and could repackage stuff in wrong direction.
 Fix method types in signature and add implementation.
 */
class Packer {

    public Box2 repackage(Box2<? super Bakery1> to, Box2<? extends Bakery1> from) {
        // Implement repackaging
        to.put(from.get());
        return to;
    }

}

// Don't change classes below
class Box3<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }

}

class Goods {}

class Food extends Goods {}

class Bakery1 extends Food {}

class Cake1 extends Bakery1 {}

class Pie extends Bakery1 {}

class Tart extends Bakery1 {}
