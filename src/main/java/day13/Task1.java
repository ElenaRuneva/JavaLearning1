package day13;

public class Task1 {
    public static void main(String[] args) {
        User u1 = new User("Atos");
        User u2 = new User("Partos");
        User u3 = new User("Aramis");
        u1.sendMessage(u2, "Salut!");
        u1.sendMessage(u2, "Po konyam!");
        u2.sendMessage(u1, "Vpered!");
        u2.sendMessage(u1, "Ara zhdet nas");
        u2.sendMessage(u1, "v kabake");
        u3.sendMessage(u1, "Ya vzyal 3 piva,");
        u3.sendMessage(u1, "rakov");
        u3.sendMessage(u1, "i vina");
        u1.sendMessage(u3, "Otlichno, my uzhe v puti...");
        u1.sendMessage(u3, "Postoite!");
        u1.sendMessage(u3, "A gde zhe Dartanyan?");
        u3.sendMessage(u1, "Ne znayu, ego net v nashey sotcseti.");
        MessageDatabase.showDialog(u1, u3);

        //1. в качестве проверки:
        //у u1 добавлена подписка на u2 и u3 и на себя
        //у u2 - подписка на u1
        //у u3 - подписка на u2
        //выведена информация о подписках и друзьях u1
        u1.subscribe(u2);
        u1.subscribe(u1);
        u2.subscribe(u1);
        u2.subscribe(u3);
        u3.subscribe(u1);
        u3.subscribe(u2);
        System.out.println("Subscriptions of "+u1.getUsername()+":");
        System.out.println(u1.getSubscriptions());
        System.out.println("Friends of "+u1.getUsername()+":");
        if (u2.isFriend(u1))
            System.out.println(u2);
        if (u3.isFriend(u1))
            System.out.println(u3);

        //2. в качестве проверки:
        //выведено первое сообщение из базы данных
        System.out.println();
        System.out.println(MessageDatabase.getMessages().get(0));
    }
}
