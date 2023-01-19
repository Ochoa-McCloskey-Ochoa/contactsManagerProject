package directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactsManagerApplication extends Contacts {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Contact contact = new Contact("name", "number");

        System.out.println("--------------------------------------------------");
        System.out.println(" > Welcome to the contacts manager!");
        System.out.println("--------------------------------------------------");
        boolean confirmation = true;

        while (confirmation) {
            System.out.println("What would you like to do?");
            System.out.println("0 - Exit");
            System.out.println("1 - View Directory.Directory.data.Contacts");
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
                case 1 -> showContacts();
                case 2 -> addContact();
                case 3 -> searchByName();
                case 4 -> searchByNumber();
                case 5 -> removeContact();
                default -> System.out.println("Unknown selection, " + choice + ".");
            }
        }

        //CREATE FILES AND FOLDERS
        String directory = "data";
        String filename = "contact.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }
        if (!Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        //ADD TO CONTACTS FILE
        List<String> contacts = Arrays.asList("Ralph | 856-555-1234", "Crystal | 203-555-1234",
                "Antonio | 485-555-8537");

        //CREATE PATH TO EXTRACT FROM
        Path filepath = Paths.get("Directory.data", "contact.txt");

        //WRITE TO FILE USING PATH
        Files.write(filepath, contacts);

        //ADD CONTACT
//        Files.write(
//                filepath,
//                List.of("John | 972-555-4823"), // list with one item
//                StandardOpenOption.APPEND
//        );

        //CALL LIST
        List<String> contactsList = Files.readAllLines(filepath);

        //PRINT ALL CONTACTS
//        System.out.println("\nName | Phone Number \n-------------------");
//
//        for (int i = 0; i < contactsList.size(); i += 1) {
//            System.out.println(contactsList.get(i));
//
//            if (i % 2 == 0) {
//                System.out.print(contactsList.get(i));
//            } else {
//                System.out.println(" | " + contactsList.get(i));
//            }
    }

    //ADD CONTACT
//        public void add(Contact) {
//                Files.write(
//                        filepath,
//                        List.of(Contact.getName(), Contact.getNumber()), // list with one item
//                        StandardOpenOption.APPEND
//                );
//        }


}