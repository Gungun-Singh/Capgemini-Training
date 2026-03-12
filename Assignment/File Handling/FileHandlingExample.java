import java.io.*;
import java.util.*;

public class FileHandlingExample {

    public static void main(String[] args) {

        String fileName = "students.txt";

        
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("101 Rahul CSE 85\n");
            writer.write("102 Aman IT 90\n");
            writer.write("103 Neha ECE 88\n");
            writer.write("104 Riya CSE 92\n");
            writer.write("105 Karan ME 80\n");
            writer.close();
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing.");
        }

        
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);

            System.out.println("Reading file data:");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

      
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("106 Simran CE 87\n");
            writer.close();
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.out.println("Error while appending.");
        }

      
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("Final file content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
