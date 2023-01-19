package directory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Contacts  {

    private String name;
    private String number;

    //CREATE FILES AND FOLDERS
    String directory = "data";
    String filename = "contact.txt";

    //CREATE PATH TO EXTRACT FROM
    Path dataDirectory = Paths.get(directory);
    Path dataFile = Paths.get(directory, filename);

    if (Files.notExists(dataDirectory)) {
        Files.createDirectories(dataDirectory);
    }
    if (!Files.exists(dataFile)) {
        Files.createFile(dataFile);
    }

    //ADD INITIAL CONTACTS TO CONTACTS FILE
    List<String> contacts = Arrays.asList("Ralph | 856-555-1234", "Crystal | 203-555-1234",
            "Antonio | 485-555-8537");

    Path filepath = Paths.get("Directory.data", "contact.txt");

    //WRITE TO FILE USING PATH
        Files.write(filepath, contacts);

    //  set up contact.txt
    //  view contacts
    //  add names and phone numbers
    //  search contact by name
    //  delete existing contact

    public Contacts(String name, String number) {
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



    public static void showContacts() throws IOException {
        Path filepath = Paths.get("Directory.data", "contact.txt");

        List<String> contactList = Files.readAllLines(filepath);

        //PRINT ALL CONTACTS
        //System.out.println("\nName | Phone Number \n-------------------");
        System.out.printf("| %-20s | %-15 |%n", contactList, "Phone Number");
        for (int i = 0; i < contactList.size(); i += 1) {

        }
    }

    public void addContact() {
        Files.write(
            filepath,
            List.of(Contact.getName(), Contact.getNumber()), // list with one item
            StandardOpenOption.APPEND
        );
    }

    public static void searchByName(name) {

    }

    public static void searchByNumber() {

    }

    public void removeContact(Contacts bla) {

    }



//    static interface Contacts {
//        List<Contact> findAll();
//        Contact findByName(String name);
//        Contact findByNumber(String number);
//        void add(Contact Contact) throws IOException;
//        void delete(Contact contact);
//    }


}
