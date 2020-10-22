package inheritancePolymorphism.runTimeTypeCheching;

class Counter {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Shape(),
                new Shape2D(),
                new Shape3D(),
                new Circle(),
                new Shape2DSub1(),
                new Shape2DSub2(),
                new Cube(),
                new Shape3DSub1(),
                new Shape3DSub2()};

        System.out.println(count2DShapes(shapes));

    }

    public static int count2DShapes(Shape[] shapes) {
        int count = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Shape2D && shape.getClass() != Shape2D.class) {
                count++;
            }
        }

        return count;
    }
}

// Don't change the code below

class Shape {
}

class Shape2D extends Shape {
}

class Shape3D extends Shape {
}


class Circle extends Shape2D {
}

class Shape2DSub1 extends Shape2D {
}

class Shape2DSub2 extends Shape2D {
}


class Cube extends Shape3D {
}

class Shape3DSub1 extends Shape3D {
}

class Shape3DSub2 extends Shape3D {
}
