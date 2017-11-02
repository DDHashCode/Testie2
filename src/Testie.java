import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Testie {
    public static void main(String[] args) {
        String UserArrayFileName = "userArrayFileName.dat";
        Scanner readChoice = new Scanner(System.in);
        ArrayList<User> UserList = readUserArray(UserArrayFileName);
        User.id = UserList.size();
        System.out.println("Welcome to Testie.\nMake your choice.");

        switchMenu(readChoice, UserList, UserArrayFileName);
        readChoice.close();
        }

public static void switchMenu(Scanner readChoice, ArrayList<User> ul, String fileName){
    switch (menu(readChoice)){
        case 1:
            User temp = new User(readChoice);
            ul.add(temp);
            saveUserArray(fileName, ul);
            switchMenu(readChoice, ul, fileName);
            break;
        case 2:
            System.out.printf("%-15s\t%-20s\t%-10s\t%-20s\n", "Name", "Surname", "Identifier", "Date created");
            for(User u: ul) System.out.println(u.toString());
            //System.out.println(readUserArray(fileName).toString());
            switchMenu(readChoice, ul, fileName);
            break;
        case 8:
            File db = new File(fileName);
            db.delete();
            System.out.println(db.exists()==false ? "File has been deleted" : "File has not been deleted.");
            switchMenu(readChoice, ul, fileName);
            break;
        case 9:
            System.exit(66);
            break;
        default:
            System.out.println("Wrong choice. Please repeat.");
            switchMenu(readChoice, ul, fileName);
            break;
    }
    }
    public static int menu(Scanner sc){
        System.out.println("1. Create new user.");
        System.out.println("2. Show database of users.");
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
    }







