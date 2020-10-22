package generic;

public class PetsInBoxes {
}

class BoxInside {

    // Complete this method
    public static void showAnimal(Box4<? extends Animal> box) {
        System.out.println(box.getAnimal().toString());
    }
}

// Don't change the code below
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Box4<T> {

    private T animal;

    void setAnimal(T animal) {
        this.animal = animal;
    }

    T getAnimal() {
        return animal;
    }
}
