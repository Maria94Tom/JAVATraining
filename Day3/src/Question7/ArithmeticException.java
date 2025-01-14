package Question7;
/*
Write a program that accepts (using Scanner ) 2 integers a and b as input and finds the quotient of a/b.
This program may generate an Arithmetic Exception. Use exception handling mechanisms to handle this
exception. In the catch block, print the message as shown in the sample output.
 Also illustrate the use of finally block. Print the message “Inside finally block”.
Sample Input and Output
1: Enter the 2 numbers 5 2 The quotient of 5/2 = 2 Inside finally block
Sample Input and Output
2: Enter the 2 numbers 5 0 DivideByZeroException caught Inside finally block
 */
import java.util.Scanner;

public class ArithmeticException {
        public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter two numbers");
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(b==0) {
                throw new java.lang.ArithmeticException("DivideByZeroException caught. please provide valid dividend");
            }
            System.out.println("The Quotient of"+a+"/"+b+"is: "+a/b);
        }
        catch (java.lang.ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("This is finally block");
        }
    }
}
