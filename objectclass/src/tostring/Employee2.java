package tostring;

import java.util.Objects;

//equals() method is used to compare two objects for equality, by default compares memory Address
class EmployeeDetails2 {
    private int id;
    private String name;

    public EmployeeDetails2(int id, String name){
        this.id=id;
        this.name=name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


//    public String toString(){
//        StringBuilder sb=new StringBuilder();
//        sb.append("id= "+id).append("\n");
//        sb.append("name= "+name);
//        return sb.toString();
//    }

//
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDetails2 that = (EmployeeDetails2) o;
        return id == that.id && Objects.equals(name, that.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name);
//    }
}
public class Employee2 {
    public static void main(String[] args) {
        EmployeeDetails2 e1=new EmployeeDetails2(1,"abc");
        EmployeeDetails2 e2=new EmployeeDetails2(1,"abc");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.equals(e2));

    }
}

