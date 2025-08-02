package Assainment1;

public class Circle implements Drawable, Fillable {

    @Override
    public void drawingColor() {
        System.out.println("Circle drawing color: Red");
    }

    @Override
    public void thickness() {
        System.out.println("Circle thickness: 3px");
    }

    @Override
    public void fillingColor() {
        System.out.println("Circle filling color: Blue");
    }

    @Override
    public void size() {
        System.out.println("Circle size: Radius is 50 units.");
    }
}
