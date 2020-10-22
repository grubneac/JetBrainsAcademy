package inheritancePolymorphism.runTimeTypeCheching.sumofArea;

class Sum {
    public static int sumOfAreas(Shape[] array) {
        // write your code here
        int sumShape = 0;

        for (Shape shape : array) {
            if (shape instanceof Square) {
                Square square = (Square) shape;
                sumShape += square.getSide() * square.getSide();
            }
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                sumShape += rectangle.getHeight() * rectangle.getWidth();
            }
        }

        return sumShape;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
