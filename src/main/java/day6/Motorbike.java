package day6;
public class Motorbike {
    private String model;
    private String color;
    private int yearOM=0;

    public Motorbike(String model, String color, int yearOM){
        this.color = color;
        this.model = model;
        if (yearOM>=1900 && yearOM<=2050)
            this.yearOM = yearOM;
    }
    public String GetModel() { return model; }
    public String GetColor(){
        return color;
    }
    public int GetYearOM(){
        return yearOM;
    }
    void info(){
        System.out.println("This is a motorbike");
    }
    int yearDifference(int inputYear){
        if (yearOM>inputYear)
            return yearOM - inputYear;
        else
            return inputYear - yearOM;
    }
}
