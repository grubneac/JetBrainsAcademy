public class ShapeHierarchy {

    public static void main(String[] args) {

        Shape circle = new Circle(10);
        System.out.println(circle.getPerimeter() + " : " + circle.getArea());

        Shape triangle = new Triangle(3, 4, 5);
        System.out.println(triangle.getPerimeter() + " : " + triangle.getArea());

        Shape rectangle = new Rectangle(5, 10);
        System.out.println(rectangle.getPerimeter() + " : " + rectangle.getArea());


    }

}

abstract class Shape {

    double getPerimeter() {
        return 0;
    }

    abstract double getArea();
}

class Triangle extends Shape {

    double lenA;
    double lenB;
    double lenC;

    public Triangle(double lenA, double lenB, double lenC) {
        this.lenA = lenA;
        this.lenB = lenB;
        this.lenC = lenC;
    }

    @Override
    double getPerimeter() {
        return lenA + lenB + lenC;
    }

    @Override
    double getArea() {
        double area, resArea;
        area = (lenA + lenB + lenC) / 2.0d;
        resArea = Math.sqrt(area * (area - lenA) * (area - lenB) * (area - lenC));
        return resArea;
    }
}

class Rectangle extends Shape {

    double lenA;
    double lenB;

    public Rectangle(double lenA, double lenB) {
        this.lenA = lenA;
        this.lenB = lenB;
    }

    @Override
    double getPerimeter() {
        return (lenA + lenB) * 2;
    }

    @Override
    double getArea() {
        return lenA * lenB;
    }
}

class Circle extends Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

