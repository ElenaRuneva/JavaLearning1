package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<MusicArtist> members;

    public int getYear(){
        return this.year;
    }
    public MusicBand(String name, int year){
        this.name = name;
        this.year = year;
        this.members = new ArrayList<>();
    }
    public String toString(){
        return "{"+this.name+", "+this.year+", "+this.members.size()+" members}";
    }

    public void addMember(MusicArtist member){
        this.members.add(member);
    }

    //2 метода удаления - по имени и по объекту
    public void removeMember(String member){
        for (MusicArtist bandMember : this.members) {
            if (bandMember.getName().equals(member)) {
                this.members.remove(bandMember);
                break;
            }
        }
    }
    public void removeMember(MusicArtist member){
        if (this.members.contains(member))
            this.members.remove(member);
    }

    public MusicArtist findMember(String name, int age){
        for (MusicArtist member : this.members){
            if(member.getName().equals(name) && member.getAge()==age)
                return member;
        }
        return null;    //что корректно возвращать, если элемент не найден?
    }
    public static void transferMembers(MusicBand musicBand_From, MusicBand musicBand_To){
        musicBand_To.members.addAll(musicBand_From.members);
        musicBand_From.members.clear();
    }
    public void printMembers(){
        System.out.println(this.members);   //members.toString() перебирает элементы
                                // и для каждого применяет свой toString, в MusicArtist toString переопределен.
    }
    public List<MusicArtist> getMembers(){
        return this.members;
    }
}
