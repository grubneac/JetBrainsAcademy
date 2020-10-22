package inheritancePolymorphism;

public class ShapesArea {
    public static void main(String[] args) {
        Shape[] shape = new Shape[4];
        Triangle triangle = new Triangle();
        triangle.base = 10;
        triangle.height = 20;
        shape[0] = triangle;

        Circle circle = new Circle();
        circle.radius = 5;
        shape[1] = circle;

        Square square = new Square();
        square.side = 10;
        shape[2] = square;

        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 10;
        shape[3] = rectangle;

        for (Shape sh : shape) {
            System.out.println(sh.getClass().getName() + " " + sh.area());
        }


    }
}

class Shape {
    public double area() {
        return 0;
    }
}

class Triangle extends Shape {
    double height;
    double base;

    // override the method here
    public double area() {
        return (base * height) / 2;
    }
}

class Circle extends Shape {
    double radius;

    // override the method here
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Square extends Shape {
    double side;

    // override the method here
    public double area() {
        return side * side;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    // override the method here
    public double area() {
        return width * height;
    }
}
