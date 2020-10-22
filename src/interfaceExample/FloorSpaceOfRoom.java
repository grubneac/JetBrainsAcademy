package interfaceExample;

import java.util.Scanner;

public class FloorSpaceOfRoom {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String typeFloor = scanner.nextLine();
        if (typeFloor.equals("triangle")) {
            Triangle floor = new Triangle();
            floor.setA(scanner.nextDouble());
            floor.setB(scanner.nextDouble());
            floor.setC(scanner.nextDouble());
            System.out.println(floor.SpaceArea());
        }
        if (typeFloor.equals("rectangle")) {
            Rectangle2 floor = new Rectangle2();
            floor.setHeight(scanner.nextDouble());
            floor.setWidth(scanner.nextDouble());
            System.out.println(floor.SpaceArea());
        }
        if (typeFloor.equals("circle")) {
            Circle2 floor = new Circle2();
            floor.setRadius(scanner.nextDouble());
            System.out.println(floor.SpaceArea());
        }
    }
}

interface Floor {
    double SpaceArea();
}

class Triangle implements Floor {
    double a;
    double b;
    double c;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double SpaceArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class Rectangle2 implements Floor {
    double width;
    double height;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double SpaceArea() {
        return width * height;
    }
}

class Circle2 implements Floor {
    double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double SpaceArea() {
        return (3.14 * Math.pow(radius, 2));
    }
}