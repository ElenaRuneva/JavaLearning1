package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("D:\\task1.txt");
        printResult(file);
    }
    public static void printResult(File file){
        try {
            Scanner sc = new Scanner(file);
            if (! sc.hasNextLine()){
                throw new IOException();
            }
            String[] numbers = sc.nextLine().split(" ");
            double sum = 0;
            for(int i=0; i<numbers.length; i++)
                sum += Double.parseDouble(numbers[i]);
            System.out.println(sum/numbers.length);
            System.out.println((double)(Math.round(sum/numbers.length*1000))/1000);

        } catch (FileNotFoundException e) {
            System.out.println("The file is not found");
            //return 0;
        } catch (IOException e) {
            System.out.println("The file is empty");
        }
     }
}

