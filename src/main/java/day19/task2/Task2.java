package day19.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file = new File("D:\\taxi_cars.txt");
        Map<Integer, Point> taxis = new HashMap<>();

        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String[] taxiData = sc.nextLine().split(" "); //проверка корректности данных не проводится
                taxis.put(Integer.parseInt(taxiData[0]), new Point(Integer.parseInt(taxiData[1]), Integer.parseInt(taxiData[2])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file is not found");
        }

        System.out.println("Insert 4 coordinates - (x1,y1) and (x2,y2)");
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int count = 0;

        if(x1>=x2 || y1>=y2 || x1<-1 || x2<-1 || y1<-1 || y2<-1 || x1>100 || x2>100 || y1>100 || y2>100){
            System.out.println("Coordinates are not correct");
            return;
        }
        System.out.println("Car IDs in the square:");
        for (Map.Entry<Integer, Point> taxi_entry : taxis.entrySet()){
            Point taxi = taxi_entry.getValue();
            if (taxi.getX()>x1 && taxi.getY()>y1 && taxi.getX()<x2 && taxi.getY()<y2) {
                count++;
                System.out.println(taxi_entry.getKey());
            }
        }
        System.out.println("Total cars = "+count);
    }
}

