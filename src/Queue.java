import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Queue implements Serializable{
    public static int id = 0;
    private String queueName;
    private int queueIdentifier;
    private ArrayList<Ticket> ticketsInQueue = new ArrayList<>();

    public Queue(Scanner sc){
        System.out.println("You're about to create new queue. Please provide its name.");
        this.queueName = sc.next();
        this.queueIdentifier = id;
        id++;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queueName='" + queueName + '\'' +
                ", queueIdentifier=" + queueIdentifier +
                ", ticketsInQueue=" + ticketsInQueue.size() +
                '}';
    }
}
