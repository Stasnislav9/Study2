interface Shape {
    String getBorderColor();
    String getFillColor();

    default double getPerimeter() {return 0;}
    default double getArea(){return 0;}
    default void printInfo(){
        System.out.println("Периметр " + getPerimeter());
        System.out.println("Площадь " + getArea());
        System.out.println("Граница " + getBorderColor());
        System.out.println("Заливка " + getFillColor());
    }
}

class Circle implements Shape {
    private double radius;
    private String borderColor;
    private String fillColor;

    public Circle (double radius, String borderColor, String fillColor){
        this.radius = radius;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public String getBorderColor() {return borderColor;}
    public String getFillColor(){return  fillColor;}

    public double getPerimeter(){return 2 * 3.14 * radius;}
    public double getArea(){return  3.14 * radius * radius;}
}

class Rectangle implements Shape{
    private double width;
    private double height;
    private String borderColor;
    private String fillColor;

    public Rectangle(double width, double height, String borderColor, String fillColor){
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public String getBorderColor() { return borderColor; }
    public String getFillColor() { return fillColor; }

    public double getPerimeter() { return 2 * (width + height); }
    public double getArea() { return width * height; }
}

class Triangle implements Shape{
    private double side1, side2, side3;
    private String borderColor;
    private String fillColor;

    public Triangle(double side1, double side2, double side3, String borderColor, String fillColor){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }
    public String getBorderColor() { return borderColor; }
    public String getFillColor() { return fillColor; }

    public double getArea() {
        double p = getPerimeter() / 2; // полупериметр
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}

public class GeometryApp {
    public static void main(String[] args){
        Shape circle = new Circle(5, "Синий", "Желтый");
        Shape rectangle = new Rectangle(5, 5, "Синий", "Зеленый");
        Shape triangle = new Triangle(5,3,4,"Красный", "Синий");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();

    }
}