package day5;
public class Task2 {
    public static void main(String[] args) {
        Motorbike mbike = new Motorbike("Ural", "Pink", 1966);
        System.out.println("The model is "+mbike.GetModel());
        System.out.println("The color is "+mbike.GetColor());
        System.out.println("The year of manufacture is "+mbike.GetYearOM());
    }
}
