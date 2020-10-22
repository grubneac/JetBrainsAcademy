import java.util.List;

public class SortOutTheClasses {
}
class Sort {
    public static void sortShapes(Shape1[] array,
                                  List<Shape1> shapes,
                                  List<Polygon1> polygons,
                                  List<Square1> squares,
                                  List<Circle1> circles) {
        // write your code here
        for (Shape1 shape : array) {

            if (shape.getClass() == Shape1.class) {
                shapes.add(shape);
            } else if (shape.getClass() == Polygon1.class) {
                polygons.add((Polygon1) shape);
            } else if (shape.getClass() == Square1.class) {
                squares.add((Square1) shape);
            } else if (shape.getClass() == Circle1.class) {
                circles.add((Circle1) shape);
            }
        }
    }
}

//Don't change classes below
class Shape1 { }
class Polygon1 extends Shape1 { }
class Square1 extends Polygon1 { }
class Circle1 extends Shape1 { }
