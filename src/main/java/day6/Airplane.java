package day6;

public class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public void SetManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public void SetYear(int number){
        year = number;
    }
    public void SetLength(int number){
        length = number;
    }
    public void SetWeight(int number){
        weight = number;
    }
    public void SetFuel(int number){
        fuel = number;
    }
    int GetFuel(){
        return fuel;
    }
    void info(){
        System.out.println("Manufacturer: "+manufacturer+", year of manufacture: "+year+", length: "+length+", weight: "+weight+", fuel balance: "+fuel);
    }
    void fillUp(int n){
        fuel += n;
    }
    public Airplane(String manufacturer, int year, int length, int weight){
        this.manufacturer = manufacturer;
        this.weight = weight;
        this.length = length;
        this.year = year;
        this.fuel = 0;
    }
}
