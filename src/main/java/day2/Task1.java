package day2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Put in a number of floors   ");
        if (!(sc.hasNextInt())){
            System.out.println("The number you have put in is not a integer number.");
            return;
        }
        int flours = sc.nextInt();

        if (flours > 0 && flours <= 4)
            System.out.print("A house of a small number of floors");
        else if (flours > 4 && flours <= 8)
            System.out.print("A house of a middle number of floors");
        else if (flours > 8)
            System.out.print("A house of a big number of floors");
        else
            System.out.print("The number of floors can't be 0 or below the zero");

        sc.close();
        }
    }

