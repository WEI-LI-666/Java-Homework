package hw13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddressBook {
    private Map<String, Contact> contacts = new TreeMap<String, Contact>();

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scan = new Scanner(System.in);
        String input;
        do{
            showMenu();
            while(true){
                input = scan.nextLine();
                if(input.matches("[0-7]")) break;
                else System.out.println("Invalid input!");
            }

            switch (input){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                default:
                    break;
            }



        } while (!input.equals("0"));

    }

    public static void showMenu(){
        System.out.println("***** Address Book *****");
        System.out.println("1) Add a New Contact");
        System.out.println("2) Show Contact List");
        System.out.println("3) Edit the Contact");
        System.out.println("4) Delete the Contact");
        System.out.println("5) Import Contacts");
        System.out.println("6) Export Contact");
        System.out.println("7) Clear Contact List");
        System.out.println("0) Exit");
        System.out.println("************************");
        System.out.printf("Please enter a number in [1,2,3,4,5,6,7,0]: ");
    }

    public void addContact(){
        Scanner scan = new Scanner(System.in);

        System.out.printf("Name: ");
        String name = scan.nextLine();
        System.out.printf("Phone: ");
        String phone = scan.nextLine();
        System.out.printf("E-mail: ");
        String email = scan.nextLine();
        System.out.printf("Birthday(yyyy/mm/dd): ");
        String birthday = scan.nextLine();

        if(isValidFormat(name, phone, email, birthday)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = null;
            try {
                date = sdf.parse(birthday);
                contacts.put(name, new Contact(name, phone, email, date));
                System.out.println("The contact has been added.");
            } catch (ParseException pe){
                pe.printStackTrace();
            }
        }
    }

    public void showContacts(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Name\tBirthday\tPhone\tEmail");
        System.out.println("-----------------------------------------------");
        for(Map.Entry<String, Contact> contact : contacts.entrySet()){
            System.out.printf("%s\t%s\t%s\t%s\n", contact.getValue().getName(),
                    contact.getValue().getBirthday(), contact.getValue().getEmail(), contact.getValue().getPhone());
        }
    }

    public void updateContact(){

    }

    public void deleteContact(){

    }

    public void importContact(){

    }

    public void exportContact(){

    }

    public void clearList(){
        contacts.clear();
        System.out.println("The contact list is empty.");
    }

    public static boolean isValidFormat(String name, String phone, String email, String birthday){
        if(!name.matches("[a-zA-z]+")){
            System.out.println("Invalid name format!");
            return false;
        }
        if(!phone.matches("09[0-9]{2}-[0-9]{3}-[0-9]{3}")){
            System.out.println("Invalid phone format!");
            return false;
        }
        if(!email.matches("([a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)")){
            System.out.println("Invalid email format!");
            return false;
        }
        if(!birthday.matches("[1-2]\\d{3}/(0[1-9]|1[0-2])/(0[1-9]|[1-2]\\d|3[0-1])")){
            System.out.println("Invalid birthday format!");
            return false;
        }

        return true;
    }
}
