package day6;

public class Car {
    private String model;
    private String color;
    private int yearOM=0;

    public void SetModel(String model1){
        model = model1;
    }
    public String GetModel(){
        return model;
    }
    public void SetColor(String color1){
        color = color1;
    }
    public String GetColor(){
        return color;
    }
    public boolean SetYearOM(int yearOM1){
        if (yearOM1<1900 || yearOM1>2050)
            return false;

        yearOM = yearOM1;
        return true;
    }
    public int GetYearOM(){
        return yearOM;
    }
    public void info(){
        System.out.println("This is a car");
    }
    public int yearDifference(int inputYear){
        if (yearOM>inputYear)
            return yearOM - inputYear;
        else
            return inputYear - yearOM;
    }
}
