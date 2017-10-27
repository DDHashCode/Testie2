import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Scanner;

public class User implements Serializable{
    String name;
    String surname;
    static int id = 0;
    int identifier;
    LocalDateTime date_created;

    public User(String name, String surname, LocalDateTime date_created) {
        this.name = name;
        this.surname = surname;
        this.identifier = User.id;
        this.date_created = date_created;
        id++;
    }
    public User(Scanner sc) {
        System.out.println("You're about to create new user, please provide name:");
        this.name = sc.next();
        System.out.println("Please provide surname:");
        this.surname = sc.next();
        this.identifier = User.id;
        id++;
        this.date_created = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String output = String.format("%-15s\t%-20s\t%-10d\t%tF", this.name, this.surname, this.identifier, date_created);
        return output;
    }
}
