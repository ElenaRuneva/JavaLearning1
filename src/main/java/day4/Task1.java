package day4;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i=0; i<size; i++)
            arr[i] = rnd.nextInt(10);

        int qty_m_8=0;
        int qty_e_1=0;
        int qty_even=0;
        int sum=0;

        System.out.print("The array was generated: ");
        for (int ar : arr){
            System.out.print(ar+" ");
            if (ar>8)
                qty_m_8 ++;
            else if (ar == 1)
                qty_e_1 ++;

            if (ar%2 == 0)
                qty_even ++;

            sum += ar;
        }
        System.out.println("\nThe array length: "+arr.length);
        System.out.println("The quantity of numbers more than 8: "+qty_m_8);
        System.out.println("The quantity of numbers equal 1: "+qty_e_1);
        System.out.println("The quantity of even numbers: "+qty_even);
        System.out.println("The quantity of uneven numbers: "+ (size - qty_even));
        System.out.println("The sum of array elements: "+ sum);

        sc.close();
    }
}
