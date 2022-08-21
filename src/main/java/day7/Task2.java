package day7;
import java.util.Random;
public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Player pl1 = new Player(rnd.nextInt(11)+90);
        Player pl2 = new Player(rnd.nextInt(11)+90);
        Player pl3 = new Player(rnd.nextInt(11)+90);
        Player pl4 = new Player(rnd.nextInt(11)+90);
        Player pl5 = new Player(rnd.nextInt(11)+90);
        Player pl6 = new Player(rnd.nextInt(11)+90);
        Player.info();
        Player pl7 = new Player(rnd.nextInt(11)+90);
        System.out.println("The players number after the 7th was tried to be added: "+ Player.getCount());
        System.out.println("The player1 has current stamina of "+ pl1.getStamina()+", he starts to run");
        while (pl1.getStamina()>0){
            pl1.run();
        }
        Player.info();
    }
}
