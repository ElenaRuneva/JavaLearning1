package day9.Task1;
public class Task1 {
    public static void main(String[] args) {
        Student student = new Student("Victor", "CoolGuys");
        Teacher teacher = new Teacher("Valentina", "Corporate Finance");
        System.out.println("Student's group is " +student.getGroupName());
        System.out.println("Teacher's subject is " +teacher.getSubjectName());
        student.printInfo();
        teacher.printInfo();
    }
}
