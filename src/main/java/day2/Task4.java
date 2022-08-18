package day2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Put in a number   ");
        if (!(sc.hasNextDouble())){
            System.out.println("The number you have put in is not a double number.");
            return;
        }
        double x = sc.nextDouble();
        double y = 0;
        if (x>=5){
            y = (x*x - 10)/(x+7);
        }
        else if (x<5 && x>-3){
            y = (x+3)*(x*x-2);
        }
        else{
            y = 420;
        }
        System.out.print(y);
        sc.close();
    }
}
