import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Testie {
    public static void main(String[] args) {
        String UserArrayFileName = "userArrayFileName.dat";
        String QueueArrayFileName = "queueArrayFileName.dat";
        Scanner readChoice = new Scanner(System.in);
        ArrayList<User> UserList = readUserArray(UserArrayFileName);
        ArrayList<Queue> QueueList = readQueueArray(QueueArrayFileName);
        User.id = UserList.size();
        Queue.id = QueueList.size();
        System.out.println("Welcome to Testie.\nMake your choice.");

        switchMenu(readChoice, UserList, QueueList, UserArrayFileName, QueueArrayFileName);
        readChoice.close();
        }

public static void switchMenu(Scanner readChoice, ArrayList<User> ul, ArrayList<Queue> ql, String UserFileName, String QueueFileName){
    switch (menu(readChoice)){
        case 1:
            User temp = new User(readChoice);
            ul.add(temp);
            saveUserArray(UserFileName, ul);
            switchMenu(readChoice, ul, ql, UserFileName, QueueFileName);
            break;
        case 2:
            System.out.printf("%-15s\t%-20s\t%-10s\t%-20s\n", "Name", "Surname", "Identifier", "Date created");
            for(User u: ul) System.out.println(u.toString());
            switchMenu(readChoice, ul, ql, UserFileName, QueueFileName);
            break;
        case 3:
            Queue tempQueue = new Queue(readChoice);
            ql.add(tempQueue);
            saveQueueArray(QueueFileName, ql);
            switchMenu(readChoice, ul, ql, UserFileName, QueueFileName);
            break;
        case 4:
            for (Queue q: ql) System.out.println(q.toString());
            switchMenu(readChoice, ul, ql, UserFileName, QueueFileName);
            break;
        case 8:
            File db = new File(UserFileName);
            db.delete();
            System.out.println(db.exists()==false ? "File has been deleted" : "File has not been deleted.");
            switchMenu(readChoice, ul, ql, UserFileName, QueueFileName);
            break;
        case 9:
            System.exit(66);
            break;
        default:
            System.out.println("Wrong choice. Please repeat.");
            switchMenu(readChoice, ul, ql, UserFileName, QueueFileName);
            break;
    }
    }
    public static int menu(Scanner sc){
        System.out.println("1. Create new user.");
        System.out.println("2. Show database of users.");
        System.out.println("3. Create new queue.");
        System.out.println("4. Show database of queues.");
        System.out.println("8. Delete database of users.");
        System.out.println("9. Exit Testie.");
        return makeYourChoice(sc);
    }

    public static int makeYourChoice(Scanner readChoice){

            return Integer.parseInt(readChoice.next());
        }
    public static ArrayList<User> readUserArray(String fileName){
        try(ObjectInputStream readIn = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
            return (ArrayList<User>)readIn.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<User>();
        } catch (IOException e) {
            return new ArrayList<User>();
        } catch (ClassNotFoundException e) {
            return new ArrayList<User>();
        }

    }
    public static void saveUserArray(String fileName, ArrayList<User> arrayListToSave){
        try(ObjectOutputStream saveTo = new ObjectOutputStream(new FileOutputStream(new File(fileName)))){
            saveTo.writeObject(arrayListToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Queue> readQueueArray(String filename){
        try(ObjectInputStream readIn = new ObjectInputStream(new FileInputStream(new File(filename)))) {
            return (ArrayList<Queue>)readIn.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<Queue>();
        } catch (IOException e) {
            return new ArrayList<Queue>();
        } catch (ClassNotFoundException e) {
            return new ArrayList<Queue>();
        }
    }

    public static void saveQueueArray(String filename, ArrayList<Queue> ArrayListToSave){
        try(ObjectOutputStream saveTo = new ObjectOutputStream(new FileOutputStream(new File(filename)))) {
            saveTo.writeObject(ArrayListToSave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }







