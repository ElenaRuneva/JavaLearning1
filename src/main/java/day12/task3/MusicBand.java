package day12.task3;

public class MusicBand {
    private String name;
    private int year;
    public int getYear(){
        return this.year;
    }
    public MusicBand(String name, int year){
        this.name = name;
        this.year = year;
    }
    public String toString(){
        return "{"+this.name+", "+this.year+"}";
    }
}
