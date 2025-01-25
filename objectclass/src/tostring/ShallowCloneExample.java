package tostring;

class Address {
    String city;
    String country;

    // Constructor to initialize address fields
    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Customer implements Cloneable {
    String name;
    int age;
    Address address; // Reference to an Address object

    // Constructor to initialize fields
    public Customer(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Overriding clone() to implement shallow cloning
    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone(); // Default shallow copy
    }

    @Override
    public String toString() {
        return name + ", " + age + ", Address: " + address;
    }
}

public class ShallowCloneExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Creating an Address object
        Address address1 = new Address("New York", "USA");

        // Creating a Customer object with address1
        Customer p1 = new Customer("Alice", 30, address1);
        System.out.println("Original Customer: " + p1);

        // Cloning the p1 object
        Customer p2 = p1.clone();

        // Modify the address of the cloned object (p2)
        p2.address.city = "Los Angeles"; // This modifies the same Address object in both p1 and p2

        // Printing details of original and cloned objects
        System.out.println("Original Customer: " + p1);
        System.out.println("Cloned Customer: " + p2);
    }
}

