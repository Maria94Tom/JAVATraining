package Question3;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Q3. Consider file data.txt which contains the following doubles:
20.355993598952395
Put data into a file named data.txt, Read from data.txt all the doubles (edited by a user) and display the biggest one.
*/
public class Displaybiggestdouble {
    public static void main(String[] args) {
        try(BufferedReader br= new BufferedReader(new FileReader("data.txt"))){
            double max=Double.MIN_VALUE;
            String line=br.readLine();
            while(line!=null){
                double d=Double.parseDouble(line);
                if(d>max){
                    max=d;
                }
                line=br.readLine();
            }
            System.out.println("Biggest double in the file is "+max);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }

    }

}
