package day4;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] arr = new int[100];
        for (int i=0; i<100; i++)
            arr[i] = rnd.nextInt(1000);

        int min = arr[0];
        int max = arr[0];
        int qty_end_0=0;
        int sum_end_0=0;
        for (int ar:arr){
            if(ar%10 == 0){
                qty_end_0++;
                sum_end_0 += ar;
            }
            if(ar>max)
                max = ar;
            if(ar<min)
                min = ar;
        }
        System.out.println("Min element = "+min);
        System.out.println("Max element = "+max);
        System.out.println("Quantity of elements ended with 0 = "+qty_end_0);
        System.out.println("Sum of elements ended with 0 = "+sum_end_0);
    }
}
