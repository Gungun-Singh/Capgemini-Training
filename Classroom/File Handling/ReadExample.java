package fileHandling;//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class ReadExample {
//    public static void main(String[] args) {
//        try {
//            File file = new File("test.txt");
//            Scanner sc = new Scanner(file);
//
//            while (sc.hasNextLine()) {
//                System.out.println(sc.nextLine());
//            }
//
//            sc.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
// Using Buferred reader.
//    public static void main(String[] args) {
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    // Using Filereader(But it will read th file char by char and not line by line)
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("test.txt");

            int data;
            while((data = reader.read()) != -1){
                System.out.println((char) data);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    Character Stream (Text files)
//      FileReader
//      FileWriter
//      BufferedReader
//      BufferedWriter
//
//    Used for:
//      .txt
//      .csv
//      .json

}
