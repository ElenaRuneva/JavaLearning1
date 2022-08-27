package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageDatabase {
    private static List<Message> messages = new ArrayList<>();

    public static void addNewMessage(User u1, User u2, String text){
        MessageDatabase.messages.add(new Message(u1, u2, text));
    }
    public static List<Message> getMessages(){
        return MessageDatabase.messages;
    }
    public static void showDialog(User u1, User u2){
        //среди всех сообщений найти те, где отпр или получатель = u1, u2
        StringBuilder sb = new StringBuilder();
        for (Message message : MessageDatabase.getMessages()){
            if ((message.getReceiver().equals(u1) && (message.getSender().equals(u2)))
                    || (message.getReceiver().equals(u2) && (message.getSender().equals(u1))))
                sb.append(message.getSender()).append(": ").append(message.getText()).append("\n");
        }
        System.out.println(sb);
    }
}
