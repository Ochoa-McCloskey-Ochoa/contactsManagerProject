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

        //ADD TO CONTACTs FILE
        List<String> contacts = Arrays.asList("Ralph | 856-555-1234", "Crystal | 203-555-1234",
                "Antonio | 485-555-8537");

        //CREATE PATH TO EXTRACT FROM
        Path filepath = Paths.get("data", "contact.txt");

        //WRITE TO FILE USING PATH
        Files.write(filepath, contacts);

//        //ADD CONTACT
//        Files.write(
//                filepath,
//                List.of("John | 972-555-4823"), // list with one item
//                StandardOpenOption.APPEND
//        );

        //CALL LIST
        List<String> contactsList = Files.readAllLines(filepath);

        //PRINT ALL CONTACTS
        System.out.println("\nName | Phone Number \n-------------------");

        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println(contactsList.get(i));

//            if (i % 2 == 0) {
//                System.out.print(contactsList.get(i));
//            } else {
//                System.out.println(" | " + contactsList.get(i));
//            }
        }

        //ADD CONTACT
        public void add(object) {
            Files.write(
                    filepath,
                    List.of(object), // list with one item
                    StandardOpenOption.APPEND
            );
        }




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
