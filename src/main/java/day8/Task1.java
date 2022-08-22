package day8;
public class Task1 {
    public static void main(String[] args) {
        String str = "0";
        long startTime = System.currentTimeMillis();
        for (int i=1; i<=20000; i++)
            str = str + " "+i;
        long stopTime = System.currentTimeMillis();
       //System.out.println(str);
        System.out.println("Program execution time for String, mc: " + (stopTime - startTime));

        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("0");
        for (int i=1; i<=20000; i++)
            sb.append(" ").append(i);
        //System.out.println(sb);
        stopTime = System.currentTimeMillis();
        System.out.println("Program execution time for StringBuilder, mc: " + (stopTime - startTime));
    }
}
