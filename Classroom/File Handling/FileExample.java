package fileHandling;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // Important functions
//     1. createNewFile()
//     2. exists()
//     3. delete()
//     4. getName()
//     5. length()
}
