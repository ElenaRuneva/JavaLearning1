package day12.task5;
import java.util.List;
public class Task5 {
    public static void main(String[] args) {
        MusicBand mb1 = new MusicBand("Muz band 1", 2015);
        MusicBand mb2 = new MusicBand("Muz band 2", 2017);
        mb1.addMember(new MusicArtist("Member 1-1", 2000));
        mb1.addMember(new MusicArtist("Member 1-2", 2001));
        mb2.addMember(new MusicArtist("Member 2-1", 1995));
        mb2.addMember(new MusicArtist("Member 2-2", 1990));
        mb2.addMember(new MusicArtist("Member 2-3", 1999));

        System.out.println(mb1);
        mb1.printMembers();
        System.out.println();
        System.out.println(mb2);
        mb2.printMembers();
        System.out.println();
        System.out.println("Member 2-2 was removed from the band 2");
        mb2.removeMember("Member 2-2"); //строкой; хотя может быть корректно искать всегда по всем полям?
        mb2.printMembers();
        System.out.println();
        System.out.println("Member 2-3 was removed from the band 2");
        mb2.removeMember(mb2.findMember("Member 2-3", 1999)); //элементом;
        //точно не разъяснено, как принято реализовывать метод удаления - что передавать на вход,
        //принято ли переопределять equal, как по умолчанию сравниваются объекты и элементы коллекций...

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
