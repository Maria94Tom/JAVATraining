package AssignmentQ5;
/*
Q5. Write a program to find next date
Input : enter day: 31
 enter month: 12
enter year : 2022
today date: 31/12/2022
Next date: 1/1/2023
 */

import java.util.Scanner;

class checkLeapYear{
    public boolean leap =false;
    public checkLeapYear(int year){
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {

            leap= true;
        } else {
            leap= false;
        }

    }

}

public class Assignment5 {
    public static void main(String[] args) {
        int noOfDaysEachMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter today's day(for eg if 08/01/2025, enter 08):");
        int day= sc.nextInt();
        System.out.println("Please enter today's month(for eg if 08/01/2025, enter 01):");
        int month= sc.nextInt();
        System.out.println("Please enter today's year(for eg if 08/01/2025, enter 2025):");
        int year= sc.nextInt();
        System.out.println("The date u entered is:"+day+"/"+month+"/"+year);
        checkLeapYear leapYear = new checkLeapYear((year));
      //  leapYear.setDaysWhenLeapYear();
        if(leapYear.leap==true){
            noOfDaysEachMonth[2]=29;
        }
        day=day+1;
        if(day>noOfDaysEachMonth[month]) {
            day = 1;
            month = month + 1;
        }
        if(month>12){
            month=1;
            year=year+1;


        }
        System.out.println("The next date is:"+day+"/"+month+"/"+year);






    }

}
