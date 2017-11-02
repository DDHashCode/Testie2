import java.io.Serializable;
import java.util.ArrayList;

public class Queue implements Serializable{
    public static int id = 0;
    private String queueName;
    private ArrayList<Ticket> ticketsInQueue = new ArrayList<>();
}
