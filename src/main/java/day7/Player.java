package day7;

public class Player {
    public static final int MAX_STAMINA=100;
    public static final int MIN_STAMINA=0;
    private int stamina;
    private static int countPlayers = 0;
    public Player(int stamina) {
        this.stamina = stamina;
        if (getCount()<6)
            countPlayers++;
    }
    public int getStamina(){
        return stamina;
    }
    public static int getCount(){
        return countPlayers;
    }
    public void run(){
        if (stamina == 0) {
            System.out.println("The player is not on the field");
            return;
        }
        stamina--;
        if (stamina == 0) {
            countPlayers--;
            System.out.println("The player has been out");
        }
    }
    public static void info(){
        if(getCount()<6)
            System.out.println("The teams are incomplete. There are "+(6-getCount())+" vacant places on the field");
        else
            System.out.println("There are no vacant places on the field");
    }
}
