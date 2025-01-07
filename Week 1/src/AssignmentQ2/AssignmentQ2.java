package AssignmentQ2;

import java.util.Scanner;

/*
Write a program called GradesAverage, which prompts user for the number of students, reads it
from the keyboard, and saves it in an int variable called numStudents. It then prompts user for the
grades of each of the students and saves them in an int array called grades. Your program shall
check that the grade is between 0 and 100. A sample session is as follow:
Enter the number of students: 3
Enter the grade for student 1: 55
Enter the grade for student 2: 108
Invalid grade, try again...
Enter the grade for student 2: 56
Enter the grade for student 3: 57
The average is: 56.
 */
public class AssignmentQ2 {
    public static void main(String[] args) {
        float avg =0;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int noOfStudents=sc.nextInt();
        for (int i=1; i<=noOfStudents; i++){
            System.out.println("Enter the grade for student" +i);
            int grade = sc.nextInt();
            if(grade<0 || grade >100){
                System.out.println("invalid grade, pls enter again");
                grade =sc.nextInt();
                continue;

            }
            avg=avg+grade;
        }
        System.out.println("Average is"+avg/noOfStudents);
    }

}
