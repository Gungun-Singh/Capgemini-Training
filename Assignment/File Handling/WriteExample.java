package fileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("test.txt");
             // FileWriter writer = new FileWriter("test.txt", true);
            // If you want to append on the data you have previuosly written , then the "true" keyword is used.
            writer.write("Hello Vishal!\n");
            writer.write("You are learning File Handling.");
            writer.close(); // If you dont close the file , data may not be saved properly.
            System.out.println("Successfully written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
