package Question6;

import java.util.Scanner;

/*
Write a program to accept name and age of a person from the command prompt(passed as arguments when
you execute the class) and ensure that the age entered is >=18 and < 60. Display proper error messages. The
program must exit gracefully after displaying the error message in case the arguments passed are not proper.
(Hint : Create a user defined exception class for handling errors.
 */
class InvalidAgeException extends Exception{
    public InvalidAgeException(String s) {
        super(s);
    }
}
public class PersonRegistration
{
    public static void main(String[] args) throws InvalidAgeException {
       // String name = args[0];
       // int age = Integer.parseInt(args[1]);
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Name");
            String name = sc.nextLine();
            System.out.println("Enter Age");
            int age = sc.nextInt();
            System.out.println(name);
            System.out.println(age);
            if (age >= 18 && age < 60) {
                System.out.println("Age is valid");
            } else {
                throw new InvalidAgeException("Age is not valid. Enter age between 18 and 60");
            }
        }
        catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
}
