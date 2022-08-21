package day7;

public class Task1 {
    public static void main(String[] args) {
        Airplane ap1 = new Airplane("Boing", 2018, 60, 100);
        Airplane ap2 = new Airplane("Airbus", 2020, 50, 120);
        Airplane.compareAirplanes(ap1, ap2);
    }
}