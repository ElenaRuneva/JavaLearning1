package day6;
import java.util.Random;

public class Teacher {
    private String name;
    private String module;

    public Teacher(String name, String module){
        this.name = name;
        this.module = module;
    }
    public void evaluate(Student student){
        Random rnd = new Random();
        int est = rnd.nextInt(4)+2;
        String estStr = "";
        if (est == 2)
            estStr = "Bad";
        else if (est == 3)
            estStr = "Passing";
        else if (est == 4)
            estStr = "Good";
        else
            estStr = "Perfect";
        System.out.println("Teacher "+this.name + " gave to student "+student.getName()+" for the module "+this.module + " the estimation of '"+estStr+"'");
    }
}
