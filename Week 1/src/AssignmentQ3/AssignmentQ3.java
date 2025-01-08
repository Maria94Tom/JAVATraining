package AssignmentQ3;
import java.util.Arrays;
import java.util.Scanner;
/*
Write a method called copyOf(), which accept an int array and returns a copy of the given array.
The method's signature is as follows:
public static int[] copyOf(int[] array)
 */

class copyArray{


    public static int[] copyArrayMethod(int arr[]){
        return Arrays.copyOf(arr,arr.length);


    }
}
public class AssignmentQ3 {
    public static void main(String[] args) {
        int arr[] =new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the numbers in the array");
        for (int i=0; i<5;i++)
        {
            arr[i] =sc.nextInt();
        }
        System.out.println("Copy of the input array is"+Arrays.toString(copyArray.copyArrayMethod(arr)));


    }
}

/*
the copyOf() method is static because:

It doesn't need an instance of ArrayOp to work.
It operates as a utility method that can be called directly via the class.
It is more efficient and simpler to use without the need to instantiate the class.
 */