package day3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String city = "";
        boolean notStop = true;
        while (notStop == true) {
            if (!(sc.hasNextLine())) {
                // System.out.println("The number you have put in is not a double number.");
                continue;
            }
            city = sc.nextLine();
            switch (city) {
                case "Stop":
                case "stop":
                    notStop = false;
                    break;
                case "Moscow":
                case "Vladivostok":
                case "Rostov":
                    System.out.println("Russia");
                    break;
                case "Rome":
                case "Milan":
                case "Turin":
                    System.out.println("Italy");
                    break;
                case "Liverpool":
                case "Manchester":
                case "London":
                    System.out.println("England");
                    break;
                case "Berlin":
                case "Munich":
                case "Cologne":
                    System.out.println("Germany");
                    break;
                default:
                    System.out.println("Unknown country");
            }
        }
        sc.close();
    }
}
