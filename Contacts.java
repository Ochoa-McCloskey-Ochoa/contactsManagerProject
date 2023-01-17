import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Files.write;

public class Contacts {

//******* Was getting errors because I forgot to add "throws IOException to my psvm  ********
                                          //V V V V V V V V V
    public static void main(String[] args) throws IOException{

        //create variables to hold our chosen file names
        String directory = "data";
        String filename = "contacts.txt";

        //create the paths we want to put them in
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        //checks if directory and file actually exist, creates them
        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }
        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        //create new list and add names
// ********GONNA NEED TO FIGURE OUT HOW YOU GUYS WANNA ADD NUMBERS TO IT********
        List<String> contactsList = Arrays.asList("Ralph", "Crystal", "Antonio");

        //creates file path to store the path in order to use it with our write
        Path filepath = Paths.get("data", "contacts.txt");
        write(filepath, contactsList);

        // create new list to read from the dataFile
        List<String> contacts = Files.readAllLines(filepath);

        //check what we got so far
        System.out.println(contacts);


    }

}
