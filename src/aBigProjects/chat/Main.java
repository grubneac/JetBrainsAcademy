package aBigProjects.chat;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*About
In this project, you will create a simple chat based on the client/server architecture that will allow
you to talk with other Internet users.
Learning outcomes
Learn to create network connections using sockets and handle multiple connections simultaneously using multithreading.
*/
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Set<String> chatUsers = new HashSet<>();

    public static void main(String[] args) {
        Message msg = new Message(scanner.nextLine());
        chatUsers.add(msg.getSenderName());

        while (chatUsers.size() > 0) {
            msg.print();
            msg = new Message(scanner.nextLine());
            if (TypeMsg.LEFT.equals(msg.getTypeMsg())) {
                chatUsers.remove(msg.getSenderName());
            } else
                chatUsers.add(msg.getSenderName());
        }
    }
}

class Message {
    private String senderName = "";
    private TypeMsg typeMsg = TypeMsg.UNKNOWN;
    private final StringBuilder msg = new StringBuilder();

    public Message(String rawMsg) {
        String[] arrMsg = rawMsg.split("\\s+");
        for (int i = 0; i < arrMsg.length; i++) {
            switch (i) {
                case (0):
                    this.senderName = arrMsg[i];
                    break;
                case (1):
                    this.typeMsg = TypeMsg.findById(arrMsg[i]);
                    break;
                default:
                    msg.append(" ").append(arrMsg[i]);
            }
        }

    }

    public String getSenderName() {
        return senderName;
    }

    public TypeMsg getTypeMsg() {
        return typeMsg;
    }

    public void print() {
        if (senderName.length() > 0 && typeMsg.equals(TypeMsg.SENT)) {
            System.out.printf("%s:%s\n", senderName, msg);
        }
    }
}

enum TypeMsg {
    JOINED("joined"),
    LEFT("left"),
    SENT("sent"),
    DISCONNECTED("disconnected"),
    CONNECTED("connected"),
    UNKNOWN("unknown");

    private final String strTypeMsg;

    TypeMsg(String strTypeMsg) {
        this.strTypeMsg = strTypeMsg;
    }

    public static TypeMsg findById(String theType) {
        for (TypeMsg type : values()) {
            if (theType.equals(type.strTypeMsg)) {
                return type;
            }
        }
        return TypeMsg.UNKNOWN;
    }
}