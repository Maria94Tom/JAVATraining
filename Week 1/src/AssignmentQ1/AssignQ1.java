package AssignmentQ1;
/* Q1. Write a program called Fibonacci to display the first 20 Fibonacci numbers F(n), where
F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average. The output shall look like:
The first 20 Fibonacci numbers are:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
The average is 885.5
*/

public class AssignQ1 {
    public static void main(String[] args) {
        int a=1, b=1, limit, c, sum=0;
        int total = 0;
        for(limit=1;limit<=20;limit++) {
            a=b;
            b=sum;
            sum=a+b;
            System.out.println(sum +"");
            total=total+sum;
        }

        System.out.println("sum of 20 numbers in the series: "+ total);
        float avg = total/20f;
        System.out.println("Avg of 20 numbers is : "  +avg );
    }
}
