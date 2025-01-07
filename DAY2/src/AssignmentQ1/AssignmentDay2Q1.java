/*Implement following UML diagram, Write a program to*/

package AssignmentQ1;

class employee{
    private int id;
    private String firstName;
    private  String lastName;
    private int salary;

    public  employee(int id, String firstName,String lastName, int salary){
        this.id =id;
        this.firstName=firstName;
        this.lastName= lastName;
        this.salary =salary;

    }

    public void getID(){
        System.out.println(id);
    }
    public void getFirstName(){
        System.out.println(firstName);
    }
    public void getLastName(){
        System.out.println(lastName);
    }
    public String getName(String firstName, String lastName){
        return firstName+lastName;
    }
    public String getName(){
        return firstName+lastName;
    }
    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary){
    this.salary = salary;
        System.out.println(salary);
    }
    public int getAnnualSalary() {
        int annualSalary = salary * 12;
        return annualSalary;
    }
    public int raiseSalary(int percentage){
        this.salary =this.salary*(percentage)/100;
        return salary;
    }
    public String toString(){
        return "Employee[id=" +id+", Name=" +firstName+",LastName="+lastName +",salary="+salary+"]";
    }
}
public class AssignmentDay2Q1 {
    public static void main(String[] args) {
        employee e= new employee(1, "Maria","Tom",2000);
        e.getID();
        e.getFirstName();
        e.getLastName();
        System.out.println(e.getName("Isabel","Tibin"));
        System.out.println(e.getName());
        System.out.println(e.getSalary());
        System.out.println(e.getAnnualSalary());
        e.setSalary(3000);
        System.out.println(e.getAnnualSalary());






    }

}
