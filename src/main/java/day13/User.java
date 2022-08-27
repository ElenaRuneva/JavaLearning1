package day13;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<User> subscriptions = new ArrayList<>();

    public User(String name){
        this.username = name;
        this.subscriptions = new ArrayList<>();
    }
    public void subscribe(User user){
        if (! user.equals(this))
            this.subscriptions.add(user);
    }
    public boolean isSubscribed(User user){
        return this.getSubscriptions().contains(user);
    }

    public String getUsername() {
        return username;
    }
    public List<User> getSubscriptions() {
        return subscriptions;
    }
    public boolean isFriend(User user){
        //В этом задании считаю, что друг - это тот, с кем есть взаимная подписка.
        //Если подписки и друзья независимы, то нужен отдельный класс Друг с полями друг1 и друг2
        //и статический класс Друзья, где хранится List объектов класса Друг. Если нужна была такая реализация,
        //то лучше уточнить в задании, что функциональность друзей надо спроектировать независимо от подписок.

        if (user.isSubscribed(this) && this.isSubscribed(user))
            return true;
        else
            return false;
    }
    public void sendMessage(User user, String text){
        MessageDatabase.addNewMessage(this, user, text);
    }
    public String toString(){
        return this.getUsername();
    }
}
