package day2;

import java.util.Scanner;

public class Task3 {
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

        int currentNum = a/5;   //дробная часть отбрасывается
        currentNum *= 5;
        currentNum += 5;
        if (currentNum % 10 == 0){
            currentNum += 5;
        }
        while (currentNum < b){
            System.out.println(currentNum);
            currentNum = currentNum + 10;
        }
        sc.close();
    }
}
