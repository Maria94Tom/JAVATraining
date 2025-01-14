package Question2;

import java.io.*;

public class PhotoFileCopyBuffer {
    public static void main(String[] args) throws IOException {
        String sourceFile = "imageToCopy.jpg";
        String OutputFile = "D:\\JAVATraining\\Day3\\image1.jpg";
        long startTime = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(OutputFile));) {
            int byteData;
            while ((byteData = bis.read()) != -1) {
                bos.write(byteData);
            }
            System.out.println("File copied successfully using BufferedInputStream/BufferedOutputStream.");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Time taken to copy the file: " + elapsedTime + " milliseconds.");

    }
}
