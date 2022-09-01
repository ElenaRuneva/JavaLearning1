package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(71777123727L));
    }
    public static long count7(long number){
        if(number < 1)
            return 0;
        if(number%10 == 7)
            return 1 + count7(number/10);
        else
            return count7(number/10);
    }
}
