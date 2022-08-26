package day12.task4;
import java.util.List;
import java.util.ArrayList;

public class MusicBand {
    private String name;
    private int year;
    private List<String> members;

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
    public void addMember(String member){
        this.members.add(member);
    }
    public void removeMember(String member){
        for (String bandMember : this.members) {
            if (bandMember.equals(member)) {
                this.members.remove(bandMember);
                break;
            }
        }
    }
    public static void transferMembers(MusicBand musicBand_From, MusicBand musicBand_To){
        musicBand_To.members.addAll(musicBand_From.members);
        musicBand_From.members.clear();
    }
    public void printMembers(){
        System.out.println(this.members);
    }
    public List<String> getMembers(){
        return this.members;
    }
}
