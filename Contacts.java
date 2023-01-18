import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacts {

    public static void main(String[] args) throws IOException {

        String directory = "data";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);

        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }

        List<String> contacts = Arrays.asList("Ralph", "Crystal", "Antonio");

        Path filepath = Paths.get("data", "contacts.txt");

        Files.write(filepath, contacts);

        List<String> contactsList = Files.readAllLines(filepath);

        System.out.println("contacts = " + filename);

        for (int i = 0; i < contactsList.size(); i += 1) {

            System.out.println((i + 1) + ": " + contactsList.get(i));

        }

        Files.write(
                filepath,
                List.of("John"), // list with one item
                StandardOpenOption.APPEND
        );


        System.out.println("contacts = " + contactsList);


        List<String> lines = Files.readAllLines(filepath);

        List<String> newList = new ArrayList<>();

//        for (String line : lines) {
//            if (line.equals("milk")) {
//                newList.add("cream");
//                continue;
//            }
//            newList.add(line);
//        }

        Files.write(filepath, newList);
    }
}
