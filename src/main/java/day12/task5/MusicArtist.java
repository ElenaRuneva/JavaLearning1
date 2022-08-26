package day12.task5;

public class MusicArtist {
    private String name;
    private int age;

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

    public String toString(){
        return "{name = "+this.name+", age = "+this.age+"}";
    }
    public MusicArtist(String name, int age){
        this.name = name;
        this.age = age;
    }
}
