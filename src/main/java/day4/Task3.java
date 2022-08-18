package day4;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[][] arr = new int[12][8];
        Random rnd = new Random();
        int max_index = 0;
        int index = 0;
        int max_sum = 0;
        int sum = 0;
        for(int[] ar_1:arr){
            sum = 0;
            for (int ar:ar_1){
                ar = rnd.nextInt(50);
                sum += ar;
            }
            if (sum >= max_sum){
                max_sum = sum;
                max_index = index;
            }
            index++;
        }
        System.out.print(max_index);
    }
}
