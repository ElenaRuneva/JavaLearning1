package day9.Task1;

public class Teacher extends Human{
    private String subjectName;
    public Teacher(String name, String subjectName){
        super(name);
        this.subjectName = subjectName;
    }
    public String getSubjectName(){
        return subjectName;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("This is a teacher with the name of "+this.getName());
    }
}
