package day9.Task2;

public class Rectangle extends Figure{
    private double width;
    private double height;
    public Rectangle(double width, double height, String color){
        super(color);
        this.width = width;
        this.height = height;
    }
    public double area(){
        return width*height;
    }
    public double perimeter(){
        return 2 * (width+height);
    }
}
