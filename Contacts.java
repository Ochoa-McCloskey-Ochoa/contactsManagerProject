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


    public static void main(String[] args) throws IOException {

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

        List<String> contacts = Arrays.asList("Ralph", "856-555-1234", "Crystal", "203-555-1234",
                "Antonio", "485-555-8537");

        Path filepath = Paths.get("data", "contact.txt");

        Files.write(filepath, contacts);

        List<String> contactsList = Files.readAllLines(filepath);

//        System.out.println("contacts = " + filename);

        System.out.println("Name | Phone Number \n-------------------");

        for (int i = 0; i < contactsList.size(); i += 1) {
            if (i % 2 == 0) {
                System.out.print(contactsList.get(i));
            } else {
                System.out.println(" | " + contactsList.get(i));
            }
        }

        Files.write(
                filepath,
                List.of("John", "972-555-4823"), // list with one item
                StandardOpenOption.APPEND
        );


        List<String> lines = Files.readAllLines(filepath);

//        To add a list of all the items in the array
//        System.out.println("contacts = " + contactsList);

        List<String> newList = new ArrayList<>();

//        for (String line : lines) {
//            if (line.equals("milk")) {
//                newList.add("cream");
//                continue;
//            }
//            newList.add(line);
//        }

//        Files.write(filepath, newList);
    }
}
