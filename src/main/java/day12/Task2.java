package day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        fillTheList(0,30, list1);
        fillTheList(300,350, list1);
        System.out.println(list1);
    }
    private static void fillTheList(int from, int to, List<Integer> list){
        if (!(from%2 == 0))
            from = from +1;

        for (int i = from; i<=to; i+=2)
            list.add(i);
    }
}
