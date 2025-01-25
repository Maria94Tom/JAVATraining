package tostring;
class Addr implements Cloneable {
    String city;
    String country;

    public Addr(String city, String country) {
        this.city = city;
        this.country = country;
    }

    // Deep cloning Addr object
    @Override
    public Addr clone() {
        try {
            return (Addr) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Consumer implements Cloneable {
    String name;
    int age;
    Addr Addr;

    public Consumer(String name, int age, Addr Addr) {
        this.name = name;
        this.age = age;
        this.Addr = Addr;
    }

    // Deep cloning Consumer object
    @Override
    public Consumer clone() {
        try {
            Consumer cloned = (Consumer) super.clone();
            cloned.Addr = this.Addr.clone();  // Perform deep cloning for Addr
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", Addr: " + Addr;
    }
}

public class DeepCloneExample {
    public static void main(String[] args) {
        Addr Addr1 = new Addr("New York", "USA");
        Consumer Consumer1 = new Consumer("John", 30, Addr1);

        // Create a deep clone of Consumer1
        Consumer Consumer2 = Consumer1.clone();

        // Modify Addr in Consumer2
        Consumer2.Addr.city = "Los Angeles";

        // Print both Consumer1 and Consumer2 to show that the Addr was not shared
        System.out.println("Original Consumer: " + Consumer1);
        System.out.println("Cloned Consumer: " + Consumer2);
    }
}
