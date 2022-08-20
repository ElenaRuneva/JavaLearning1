package day6;
public class Task1 {
    public static void main(String[] args) {
        Motorbike mbike = new Motorbike("Ural", "Pink", 1966);
        mbike.info();
        System.out.println("year difference is "+mbike.yearDifference(2022));
    }
}
