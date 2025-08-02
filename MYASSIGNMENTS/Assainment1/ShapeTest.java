package Assainment1;

public class ShapeTest {
    public static void main(String[] args) {

        // Create objects
        Drawable d;
        Fillable f;

        System.out.println("== Line ==");
        d = new Line();
        f = new Line();
        d.drawingColor();
        d.thickness();
        f.fillingColor();
        f.size();

        System.out.println("\n== Circle ==");
        d = new Circle();
        f = new Circle();
        d.drawingColor();
        d.thickness();
        f.fillingColor();
        f.size();

        System.out.println("\n== Square ==");
        d = new Square();
        f = new Square();
        d.drawingColor();
        d.thickness();
        f.fillingColor();
        f.size();
    }
}
