package skillvalue;

import java.util.Optional;


public class Question14 {
    public static void main(String[] args) {
        System.out.println(new One().name);
        System.out.println(new Two().getTwo().get().name);


        /// This not compile
//        System.out.println(new Three().getTwo().flatMap(Two::getTwo).map(One::getName).orElse("N/A"));
    }
}

class One {
    String name = "John";
    public Optional<String> getName() {
        return Optional.of(name);
    }
}

class Two {
    One one = new One();
    public Optional<One> getTwo() {
        return Optional.of(one);
    }
}

class Three {
    Two two = new Two();
    public Optional<Two> getTwo() {
        return Optional.ofNullable(two);
    }
}
