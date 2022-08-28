package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("D:\\people.txt");
        System.out.println(parseFileToStringList(file));
    }
    public static List<String> parseFileToStringList(File file) {
        List<String> people = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            try {
                throw new RuntimeException("The file is not found");
            } catch (RuntimeException ex){
                System.out.println(ex.getMessage());
                return null;
            }
        }
        while (sc.hasNextLine()){
            String person = sc.nextLine();
            String[] personData = person.split(" ");
            if (personData.length != 2 || Integer.parseInt(personData[1])<=0) {
                try {
                    throw new RuntimeException("The file is incorrect");
                } catch (RuntimeException e){
                    System.out.println(e.getMessage());
                    return null;
                }
            }
            people.add(person);
        }
        return people;
    }
}
