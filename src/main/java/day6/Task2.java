package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane ap = new Airplane("Boing", 2005, 70, 100);
        //Изменить год выпуска и длину с помощью сеттеров,
        // вызвать метод fillUp(int n) два раза, передав разные значения. Вызвать метод info().
        ap.SetYear(2015);
        ap.SetLength(95);
        ap.fillUp(40);
        ap.info();
    }
}
