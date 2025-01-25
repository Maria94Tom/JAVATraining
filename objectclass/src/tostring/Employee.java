package tostring;
//toString() method returns a string representation of the object.
// By default, it returns a string that consists of the class name followed by the "@" symbol and the hashcode of the object.
class EmployeeDetails{
    private int id;
    private String name;

    public EmployeeDetails(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId() {
        return id;
    }    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeDetails{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }



}
public class Employee {
    public static void main(String[] args) {
        EmployeeDetails e1=new EmployeeDetails(1,"abc");
       // When you print an object using System.out.println(),
        // Java will automatically call the toString() method to get a string representation of that object.
        System.out.println(e1);

    }
}
