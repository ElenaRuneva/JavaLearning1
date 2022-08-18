package day2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Put in 2 integer numbers   ");
        if (!(sc.hasNextInt())){
            System.out.println("The first number you have put in is not an integer number.");
            return;
        }
        int a = sc.nextInt();
        if (!(sc.hasNextInt())){
            System.out.println("The second number you have put in is not an integer number.");
            return;
        }
        int b = sc.nextInt();
        if (a>=b){
            System.out.println("The 2nd number should be more than the 1st.");
            return;
        }

        int first = 0;
        if (a % 10 == 0)
            first = a+5;
        else if (a % 10 <= 5)
            first = a - a%10 + 5;
        else   //от 6 до 9
            first = a - a%10 + 15;

        for (int currentNum = first; currentNum < b; currentNum = currentNum + 10)
            System.out.println(currentNum);

        sc.close();
    }
}
