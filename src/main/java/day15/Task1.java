package day15;
import day14.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("D:\\shoes.csv");
        Fill_Missing_shoes_File (file);
    }
    public static void Fill_Missing_shoes_File(File file){
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found");
            return;
        }
        if (! sc.hasNextLine()) {
            System.out.println("The file does not contain any data");
            return;
        }
        File file_out = new File("D:\\missing_shoes.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file_out);
        } catch (FileNotFoundException e) {
            //это throw добавляет IntelliJ сам при вызове контекстного меню на PrintWriter (предлагает Surround with Try-catch)
            //и появляется и перехват ошибки и генерация другой ошибки, поэтому возник вопрос, зачем)
            //throw new RuntimeException(e); - это добавил IntelliJ
            System.out.println("Output file "+file_out.getPath()+" is absent and can't be created under the current user");
            return;
        }
        do {
            String shoes_str = sc.nextLine();
            String[] shoes_data = shoes_str.split(";");
            try{
                if (shoes_data.length != 3 || Integer.parseInt(shoes_data[2]) < 0)
                    throw new RuntimeException("The file is incorrect");
                else if (Integer.parseInt(shoes_data[2]) == 0)
                    pw.println(shoes_str);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return;
            }
        } while(sc.hasNextLine());
        pw.close();
    }
}
