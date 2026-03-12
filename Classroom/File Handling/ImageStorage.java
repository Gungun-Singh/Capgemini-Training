package fileHandling;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageStore {
//    public static void main(String[] args) {
//        String srcPath = "C:/Users/visha/IdeaProjects/Capgemini/Images/ufc.jpg";
//        String destination = "C:/Users/visha/IdeaProjects/Capgemini/copied.png";
//
//        try{
//            FileInputStream fis = new FileInputStream(srcPath);
//            FileOutputStream fos = new FileOutputStream(destination);
//
//            byte[] buffer = new byte[1024];
//            int bytesRead ;
//            while((bytesRead = fis.read(buffer)) != -1){
//                fos.write(buffer , 0 , bytesRead);
//            }
//
//            fis.close();
//            fos.close();
//
//            System.out.println("Image Stored Successfully");
//        }catch(IOException e){
//            System.out.println("Error Occured");
//            e.printStackTrace();
//        }
//    }
    // for reading image.
    public static void main(String[] args) {
        String srcPath = "C:/Users/visha/IdeaProjects/Capgemini/copied.png";

        try{
            FileInputStream fis = new FileInputStream(srcPath);
            int size = 0;
            while(fis.read() != -1){
                size++;
            }

            fis.close();

            System.out.println("Image Read Successfully");
            System.out.println("Image size : " + size + " bytes");
        }catch(IOException e){
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }
}
