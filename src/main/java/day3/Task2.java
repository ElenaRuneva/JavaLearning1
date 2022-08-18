package day3;

import java.util.Scanner;

//ВОПРОС
//как правильно очищать сканер? например, если внесено "фываыв фыав" или только "фуц" без второго значения
//каждый раз заново создавать new Scanner наверно неправильно.

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Put in 2 double numbers   ");
            if (!(sc.hasNextDouble())) {
                sc = new Scanner(System.in);
                continue;
            }
            double dividend = sc.nextDouble();
            if (!(sc.hasNextDouble())) {    //почему-то при вводе одной цифры и Enter проверка второго значения не срабатывает
                sc = new Scanner(System.in);
                continue;
            }
            double denominator = sc.nextDouble();
            if (denominator == 0) {
                System.out.println("The denominator can't be 0");
                break;
            }
            System.out.println(dividend / denominator);
        }
        sc.close();
    }
}