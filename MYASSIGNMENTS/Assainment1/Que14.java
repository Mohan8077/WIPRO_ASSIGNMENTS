package Assainment1;

public class Que14 {
    
    // Method square
    public void area(int side) {
        int area = side * side;
        System.out.println("Area of Square: " + area);
    }

    // Method rectangle
    public void area(int length, int breadth) {
        int area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    // Method square
    public void perimeter(double side) {
        double perimeter = 4 * side;
        System.out.println("Perimeter of Square: " + perimeter);
    }

    // Method R
    public void perimeter(double length, double breadth) {
        double perimeter = 2 * (length + breadth);
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }

    public static void main(String[] args) {
        Que14 shape = new Que14();

        // Square 
        shape.area(5);
        shape.perimeter(5.0);

        // Rectangle 
        shape.area(6, 4);
        shape.perimeter(6.0, 4.0);
    }
}