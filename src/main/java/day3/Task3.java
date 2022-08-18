package day3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double frst = 0;
        double scnd = 0;
        for (int i=0; i<5; i++){
            frst = sc.nextDouble();
            scnd = sc.nextDouble();
            if(scnd == 0){
                System.out.println("Divide by 0");
                continue;
            }
            System.out.println(frst / scnd);
        }
        sc.close();
    }
}
