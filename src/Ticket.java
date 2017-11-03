import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ticket {
    public static int id = 0;
    private LocalDateTime timeCreated;
    private User ticketCreator;
    private User ticketOwner;
    private Queue assignedQueue;
    private String logSummary;
    private ArrayList<String> log;
    private TicketPriority priority;
    private TicketType ticketType;

    public Ticket(Scanner sc){
        System.out.println();
    }


}
