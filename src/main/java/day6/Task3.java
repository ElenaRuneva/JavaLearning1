package day6;

public class Task3 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Ivanov", "Economics");
        Student student = new Student("Petrov");
        teacher.evaluate(student);
    }
}
