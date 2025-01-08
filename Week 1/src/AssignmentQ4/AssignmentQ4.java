package AssignmentQ4;
/*
Q4. Create pascal triangle using 2D array
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
1 2 3 4 5 6 7
1 2 3 4 5 6 7 8

 */

import java.util.Scanner;

public class AssignmentQ4 {
    public static void main(String args[]) {// opening of main
        Scanner sc = new Scanner(System.in);
        int n, i, j, a[][];
        System.out.println("HOW MANY STEPS?");
        n = sc.nextInt();
        a = new int[n][n];
        // filling the 2D matrix.
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++)
                //if (j == 0 || j == i)
                    if (j == 0 )
                    a[i][j] = 1;
                else
                    a[i][j] = j+1;
        }
        // displaying the Pascal's Triangle as the output.
        System.out.println("\nOUTPUT:\n");
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++)
                System.out.print(a[i][j] + "\t");

            System.out.println();
        }
    }
}
