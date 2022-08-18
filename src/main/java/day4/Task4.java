package day4;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[100];
        for (int i=0; i<100; i++)
            arr[i] = rnd.nextInt(10000);
        int max_sum3 = 0;
        int index_frst = 0;
        int sum3 = 0;
        for (int i=1; i<arr.length-1; i++) {
            sum3 = arr[i-1]+arr[i]+arr[i+1];
            if (sum3 > max_sum3){
                max_sum3 = sum3;
                index_frst = i-1;
            }
        }
        System.out.println("Max sum of 3 near elements = "+max_sum3);
        System.out.println("Index of the 1st element = "+index_frst);
    }
}
