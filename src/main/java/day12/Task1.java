package day12;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> listCarBrands = new ArrayList<>();
        listCarBrands.add("Volga");
        listCarBrands.add("BMW");
        listCarBrands.add("Opel");
        listCarBrands.add("Ford");
        listCarBrands.add("Renault");
        System.out.println(listCarBrands);
        listCarBrands.add(3, "Toyota");
        listCarBrands.remove(0);
        System.out.println(listCarBrands);
    }
}
