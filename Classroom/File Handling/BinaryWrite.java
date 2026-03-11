package fileHandling;

import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryWrite {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data.bin")) {
            fos.write(65);  // ASCII of A
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    Byte Stream (Binary files)
//     FileInputStream
//     FileOutputStream
//
//    Used for:
//          Images
//          PDFs
//          Audio
//          Video

}
