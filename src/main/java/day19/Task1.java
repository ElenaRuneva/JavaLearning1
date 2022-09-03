package day19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
    //Чичиков - 601

    File file = new File("D:\\dushi.txt");
    countWords(file);
    }
    public static void countWords(File file){
        Map<String, Integer> wordsMap = new HashMap<>();

        try{
            Scanner sc = new Scanner(file);
            if (! sc.hasNextLine()){
                throw new IOException();
            }
            sc.useDelimiter("[.,:;()?!\"\\s–]+");
            //заполнить соответствие слово<->количество
            while (sc.hasNext()){
                String word = sc.next();
                if(wordsMap.containsKey(word))
                    wordsMap.put(word, wordsMap.get(word)+1);
                else
                    wordsMap.put(word, 1);
            }
            //взять значения, отсортировать в порядке убывания;
            //сортировку вроде бы не проходили в видео, если надо было сделать другим способом, сообщите, каким
            List<Integer> numbers = new ArrayList<>(wordsMap.values());
            numbers.sort(Comparator.reverseOrder());

            //записываю дополнительно в файл, т.к. в консоль снова выводит знаки вопроса
            File file_out = new File("D:\\dushi_100words.txt");
            PrintWriter pw = new PrintWriter(file_out);

            //для каждой пары ключ-значение узнать, какую позицию в отсортированном массиве
            //всех количеств слов занимает количество из этой пары (количество=значение):
            //если позиция меньше 100 -> это одно из 100 наиболее частых слов.
            //(вывод без сортировки, в задании не требовалось)
            for(Map.Entry<String, Integer> word_number: wordsMap.entrySet()){
                if(numbers.indexOf(word_number.getValue())<100) {
                    System.out.printf("%-20s %d \n", word_number.getKey(), word_number.getValue());
                    pw.println(" "+word_number.getKey() +"  "+ word_number.getValue());
                }
            }
            pw.close();
            sc.close();
        } catch (
        FileNotFoundException e) {
            System.out.println("The file is not found");
        } catch (IOException e) {
            System.out.println("The file is empty");
        }
    }
}
