package day12.task4;
import java.util.List;
public class Task4 {
    public static void main(String[] args) {
        MusicBand mb1 = new MusicBand("Muz band 1", 2000);
        MusicBand mb2 = new MusicBand("Muz band 2", 2010);
        mb1.addMember("Member 1-1");
        mb1.addMember("Member 1-2");
        mb2.addMember("Member 2-1");
        mb2.addMember("Member 2-2");
        mb2.addMember("Member 2-3");
        System.out.println(mb1);
        mb1.printMembers();
        System.out.println();
        System.out.println(mb2);
        mb2.printMembers();
        System.out.println();
        System.out.println("Member 2-2 and 2-3 was removed from the band 2");
        mb2.removeMember("Member 2-2");
        mb2.removeMember("Member 2-3");
        mb2.printMembers();
        System.out.println();
        System.out.println("Members from the band 1 were transferred to the band 2");
        MusicBand.transferMembers(mb1, mb2);
        System.out.println(mb1);
        System.out.println(mb1.getMembers());
        System.out.println(mb2);
        System.out.println(mb2.getMembers());
    }
}
