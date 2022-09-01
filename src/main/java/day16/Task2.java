package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file1 = new File("D:\\file1.txt");
        File file2 = new File("D:\\file2.txt");

        try {
            PrintWriter pw = new PrintWriter(file1);
            Random rnd = new Random();
            for (int i = 0; i < 1000; i++) {
                pw.println(rnd.nextInt(101));
            }
            pw.close();
            pw = new PrintWriter(file2);
            Scanner sc = new Scanner(file1);
            int i = 0;
            double sum = 0;
            while (sc.hasNextLine()) {
                sum += Double.parseDouble(sc.nextLine());
                if ((++i) % 20 == 0) {
                    pw.println(sum / 20.0);
                    sum = 0;
                }
            }
            pw.close();
            sc.close();
            printResult(file2);
        } catch (FileNotFoundException e) {
            System.out.println("File1 or file2 is absent and can't be created under the current user");
        }
    }
    public static void printResult(File file) {
        double sum = 0;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sum += Double.parseDouble(sc.nextLine());
            }
            System.out.println((int) (sum));
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File "+file.getPath()+" is not found");
        }
    }
}
