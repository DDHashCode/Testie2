import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {
    public static int id = 0;
    LocalDateTime timeCreated;
    User ticketCreator;
    User ticketOwner;
    Queue assignedQueue;
    ArrayList<String> log;
    TicketPriority priority;


}
