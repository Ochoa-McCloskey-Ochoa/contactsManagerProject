package Directory.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacts {

    //  set up contact.txt
    //  view contacts
    //  add names and phone numbers
    //  search contact by name
    //  delete existing contact

//    private static final ContactsManagerApplication.Contact contactsDao = new ContactsManagerApplication.Contact();

    public static class Contact {
        private String name;
        private String number;

        public Contact(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    public static void showContacts() {
        System.out.printf("| %-20s | %-15 |%n", "Name", "Phone Number");
//        System.out.println();
//        System.out.println(" Name | Number ");
//        System.out.println("---------------");
//        System.out.println(contactsDao.findAll());
//        System.out.println();
    }


    public static void addContact() {
        ContactsManagerApplication.Contact newContact = new ContactsManagerApplication.Contact(
                ContactsManagerApplication.Input.getString("name: "),
                ContactsManagerApplication.Input.getString("number: ")
        );

        try {
            contactsDao.add(newContact);
            System.out.println("Contact added!");
        } catch (IOException e) {
            System.out.println("Error adding a new contact!");
            e.printStackTrace();
        }
    }

    public static void searchByName() {

    }

    public static void searchByNumber() {

    }

    public static void removeContact() {
        String name = ContactsManagerApplication.Input.getString("Enter the name of the contact to remove: ");
        ContactsManagerApplication.Contacts toRemove = contactsDao.findByName(name);
        if (toRemove == null) {
            System.out.println("Sorry, no contact with that name was found.");
            return;
        }
        contactsDao.delete(toRemove);
        System.out.println("Contact removed!");
    }

    static class Input {
        private static Scanner scanner = new Scanner(System.in);

        public static int getInt() {
            return getInt("Please enter an integer: ");
        }

        public static int getInt(String prompt) {
            System.out.print(prompt);
            String userInput = scanner.nextLine();
            try {
                return Integer.valueOf(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Sorry, '" + userInput + "' is not a valid integer.");
                return getInt(prompt);
            }
        }

        public static String getString(String prompt) {
            System.out.print(prompt);
            return scanner.nextLine();
        }

        public static String getString() {
            return getString("Please enter a string: ");
        }
    }



    public void findAll(){
        for (int i = 0; i < contactsList.size(); i += 1) {
            if (i % 2 == 0) {
                System.out.print(contactsList.get(i));
            } else {
                System.out.println(" | " + contactsList.get(i));
            }
        }
    }

//    public void add(){
//        Files.write(
//                filepath,
//                List.of(), // list with one item
//                StandardOpenOption.APPEND
//        );
//    }

//    static interface Contacts {
//        List<Contact> findAll();
//        Contact findByName(String name);
//        Contact findByNumber(String number);
//        void add(Contact Contact) throws IOException;
//        void delete(Contact contact);
//    }


}
