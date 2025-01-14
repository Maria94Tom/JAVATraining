package Question3;

import java.io.IOException;
import java.io.Serializable;

/*
Write a program to serialize and deserialize an object of Employee class. Employee class has the following
members.
Employee
Int id;
String name;
Address
address;
double salary; (nonserializable)
void display()
 */

public class EmpSerial {
    public static void main(String[] args) {
        Address address = new Address("Pune", "Maharashtra", "India");
        Employee employee = new Employee(1, "Raj", address, 50000);

        try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream("employee.ser"))) {
            oos.writeObject(employee);
            oos.close();
            System.out.println("Employee object serialized to employee.ser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream("employee.ser"))) {
            Employee employee1 = (Employee) ois.readObject();
            employee1.display();
        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}