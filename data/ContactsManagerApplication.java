package data;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


class ContactsManagerApplication {
    private static final Contacts contactsDao = new ContactsTextFile();

    public static void showContacts() {
        System.out.println();
        System.out.println(" Name | Number ");
        System.out.println("---------------");
        for(Contact contact : contactsDao.findAll()) {
            System.out.printf(
                    "%s | %s\n",
                    contact.getName(),
                    contact.getNumber()
            );
        }
        System.out.println();
    }

    public static void addContact() {
        Contact newContact = new Contact(
                Input.getString("name: "),
                Input.getString("number: ")
        );

        try {
            contactsDao.add(newContact);
            System.out.println("ContactsManagerApplication.Contact added!");
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
        String name = Input.getString("Enter the name of the contact to remove: ");
        Contact toRemove = contactsDao.findByName(name);
        if (toRemove == null) {
            System.out.println("Sorry, no contact with that name was found.");
            return;
        }
        contactsDao.delete(toRemove);
        System.out.println("ContactsManagerApplication.Contact removed!");
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println(" > Welcome to the contacts manager!");
        System.out.println("--------------------------------------------------");

        while (true) {
            System.out.println("What would you like to do?");

            System.out.println("0 - Exit");
            System.out.println("1 - View Contacts");
            System.out.println("2 - Add a new ContactsManagerApplication.Contact");
            System.out.println("3 - Search by Number");
            System.out.println("4 - Search by Name");
            System.out.println("5 - Remove an existing ContactsManagerApplication.Contact");

            int choice = Input.getInt("Please make a selection: ");
            switch(choice) {
                case 0:
                    System.out.println("Have a great day!");
                    return;
                case 1:
                    showContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchByNumber();
                    break;
                case 5:
                    removeContact();
                    break;
                default:
                    System.out.println("Unknown selection, " + choice + ".");
                    break;
            }
        }
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

    static interface Contacts {
        List<Contact> findAll();
        Contact findByName(String name);
        Contact findByNumber(String number);
        void add(Contact Contact) throws IOException;
        void delete(Contact contact);
    }
}
