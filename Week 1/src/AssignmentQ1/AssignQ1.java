package AssignmentQ1;

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
