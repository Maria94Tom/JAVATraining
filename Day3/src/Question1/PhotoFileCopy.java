package Question1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


    public class PhotoFileCopy{

        public static void main(String[] args) throws IOException {
            // Define the source and destination file paths
            String sourceFile = "imageToCopy.jpg";  // Path to your photo file
            String destinationFile = "D:\\JAVATraining\\Day3\\imageCopied.jpg";  // Destination file path
            long startTime = System.currentTimeMillis();
            try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
                 FileOutputStream fileOutputStream = new FileOutputStream(destinationFile)) {

                int byteData;
                while ((byteData = fileInputStream.read()) != -1) {
                    fileOutputStream.write(byteData); // Write each byte to the destination file
                }

                System.out.println("File copied successfully using FileInputStream/FileOutputStream.");
            }
//            catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            System.out.println("Time taken to copy the file: " + elapsedTime + " milliseconds.");

        }
    }

