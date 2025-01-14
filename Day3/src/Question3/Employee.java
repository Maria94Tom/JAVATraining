package Question3;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private Address address;
    transient private double salary;

    public Employee(int id, String Name, Address address, double salary) {
        this.id=id;
        this.name=Name;
        this.address=address;
        this.salary=salary;

    }
    public void display(){
        StringBuilder sb= new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Salary: ").append(salary).append("\n");
        System.out.println(sb.toString());
    }
}
