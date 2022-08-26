package day11.task2;

public class Task2 {
    public static void main(String[] args) {
        Magician mag = new Magician();
        Paladin pal = new Paladin();
        Shaman sham = new Shaman();
        Warrior warr = new Warrior();

        warr.physicalAttack(pal);
        System.out.println(pal);
        pal.physicalAttack(mag);
        System.out.println(mag);
        sham.healTeammate(mag);
        System.out.println(mag);
        mag.magicalAttack(pal);
        System.out.println(pal);
        sham.physicalAttack(warr);
        System.out.println(warr);
        pal.healHimself();
        System.out.println(pal);
        System.out.println();
        for (int i=0; i<5; i++) {
            warr.physicalAttack(mag);
            System.out.println(mag);
        }

    }
}
