package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        //файл на диске D, т.к. в адресе проекта есть русские буквы, не работает
        File file = new File("D:\\task1.txt");  //эта команда почему-то не вызывает исключение, если файла нет
        printSumDigits(file);
    }
    public static void printSumDigits(File file) {
        Scanner sc = null;  //переменная за пределами try, чтобы использовать ее дальше
        try {
            sc = new Scanner(file);
            //ВОПРОС по Scanner(file):
            //здесь проверяется наличие файла, при отсутствии вызывается
            // конкретное исключение FileNotFoundException = система создает объект класса FileNotFoundException,
            // наша программа на каждой строке проверяет, не создался ли он уже
            // и если создался --> программа прерывается и ищется соответствующий catch
            // - так это работает?

            //ВОПРОС
            //как узнать, какие конкретно исключения генерят какие методы?
        }
        catch (FileNotFoundException e) {
            //ВОПРОС
            //здесь перехватываем ошибку FileNotFoundException и сами вызываем другую - RuntimeException
            // - зачем?? Чтобы вывести понятное сообщение вместо системного?
            //если нас устраивает системное сообщение, можно же вообще убрать этот try-catch?
            throw new RuntimeException("File is not found");
        }

        if (sc.hasNextLine()) {
            String[] numbers = sc.nextLine().split(" ");
            if (numbers.length != 10) {
                throw new RuntimeException("There are no 10 numbers in the file");
            }
            int sum = 0;
            for (String num : numbers){
                sum += Integer.parseInt(num);
            }
            System.out.println("Sum = "+sum);
        }
    }
}
