package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("D:\\people.txt");
        List<Person> people = parseFileToObjList(file);
        if (people != null)
            System.out.println(people);
    }

    public static List<Person> parseFileToObjList(File file) {
        List<Person> people = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found");
            return null;
        }
        while (sc.hasNextLine()) {
            String person = sc.nextLine();
            String[] personData = person.split(" ");

            try{
                if (personData.length != 2 || Integer.parseInt(personData[1]) <= 0)
                    throw new RuntimeException("The file is incorrect");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return null;
            }
            people.add(new Person(personData[0], Integer.parseInt(personData[1])));
        }
        return people;
    }
}
