package day5;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.SetModel("BMW");
        car.SetColor("Blue");
        int yearOM = 2020;
        if(!(car.SetYearOM(yearOM)))
            System.out.printf("The year %d is incorrect\n", yearOM);

        System.out.println("The model is "+car.GetModel());
        System.out.println("The color is "+car.GetColor());
        System.out.println("The year of manufacture is "+car.GetYearOM());
    }
}
