package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeBounds {
    public static void main(String[] args) {
        Brochure brochure = new Brochure("NewBrochure");
        Shelf<Brochure> shelf = new Shelf<>();
        shelf.setElement(brochure);
        System.out.println(shelf.getElement().getName());

        Brochure2 brochure2 = new Brochure2("NewBrochure2");
        Shelf<Brochure2> shelf2 = new Shelf<>();
        shelf2.setElement(brochure2);
        System.out.println(shelf2.getElement().getName());
    }
}

class Shelf<T extends Book> {
    private T element;

    void setElement(T theElement) {
        this.element = theElement;
    }

    T getElement() {
        return element;
    }
}


class Book {
}

class Brochure extends Book {

    private String name;

    Brochure(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}

class Brochure2 extends Book {

    private String name;

    Brochure2(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}

class Box1<T extends Animal1> {
    private List<T> arrr = new ArrayList<>();

    void add(T theElement) {
        arrr.add(theElement);
    }
} //...finish the code of the class

// Don't change the code below
class Animal1 {}