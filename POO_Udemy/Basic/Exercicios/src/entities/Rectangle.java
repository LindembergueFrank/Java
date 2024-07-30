package entities;

public class Rectangle {
    public double width;
    public double height;

    public double area(double width, double height) {
        return width * height;
    }

    public double perimeter(double width, double height) {
        return 2*(width + height);
    }

    public double diagonal(double width, double height) {
        return Math.sqrt(width * width + height * height);
    }
}
