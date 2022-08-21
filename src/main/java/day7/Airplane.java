package day7;

public class Airplane {
    private String manufacturer;
    private int year;
    private int length;
    private int weight;
    private int fuel;

    public static void compareAirplanes(Airplane ap1, Airplane ap2){
        if (ap1.getLength()> ap2.getLength())
            System.out.print("The bigger is "+ap1.getManufacturer()+", "+ap1.getLength());
        else
            System.out.print("The bigger is "+ap2.getManufacturer()+", "+ap2.getLength() + ", or they are equal");
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public void setYear(int number){
        year = number;
    }
    public void setLength(int number){
        length = number;
    }
    public void setWeight(int number){
        weight = number;
    }
    public void setFuel(int number){
        fuel = number;
    }
    public int getLength(){
        return length;
    }

    int getFuel(){
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
