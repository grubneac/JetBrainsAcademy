package generic;

import java.util.ArrayList;
import java.util.List;

public class Violator {
    public static void main(String[] args) {
        List<Box<? extends Bakery>> testBoxes = defraud();
        System.out.println(NaiveQualityControl.check(testBoxes));
    }


    public static List<Box<? extends Bakery>> defraud() {
        // Add implementation here
        List<Box<? extends Bakery>> listBoxes = new ArrayList<>();
        Paper paper = new Paper();
        Box paperBox = new Box<>();
        paperBox.put(paper);
        listBoxes.add(paperBox);

        return listBoxes;
    }
}

/* This class and its subclasses should pass quality check */
class Bakery {}

class Cake extends Bakery {}

/* This one should not */
class Paper {}

/* These boxes are used to pack stuff */
class Box<T> {
    private T element;
    void put(T item) {
        element = item;
    }
    T get() {
        return element;
    }
}

/* This quality checker ensures that boxes for sale contain Bakery and anything else */
class NaiveQualityControl {

    public static boolean check(List<Box<? extends Bakery>> boxes) {
    /* Method signature guarantees that all illegal
       calls will produce compile-time error... or not? */
        return true;
    }

}
