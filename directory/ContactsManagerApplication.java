package directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ContactsManagerApplication {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.println(" > Welcome to the contacts manager!");
        System.out.println("--------------------------------------------------");
        boolean confirmation = true;

        while (confirmation) {
            System.out.println("What would you like to do?");
            System.out.println("0 - Exit");
            System.out.println("1 - View Directory");
            System.out.println("2 - Add a new Contact");
            System.out.println("3 - Search by Number");
            System.out.println("4 - Search by Name");
            System.out.println("5 - Remove an existing Contact");
            System.out.println("Please make a selection: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0 -> {
                    System.out.println("Have a great day!");
                    confirmation = false;
                }
                case 1 -> Contacts.showContacts();
                case 2 -> {
                    Contacts contact = new Contacts("name", "number");
                    contact.addContact();
                }
                case 3 -> searchByName();
                case 4 -> searchByNumber();
                case 5 -> removeContact();
                default -> System.out.println("Unknown selection, " + choice + ".");
            }
        }
    }
}