package tostring;

import java.util.HashMap;
import java.util.Map;

import java.util.Objects;

class Pupil {
    private String name;
    private int age;

    // Constructor
    public Pupil(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding equals() to compare the logical equality based on name and age
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // Check if the objects are the same
        if (obj == null || getClass() != obj.getClass()) return false;  // Check for null and type

        Pupil Pupil = (Pupil) obj;  // Cast to the correct class
        return age == Pupil.age && Objects.equals(name, Pupil.name);  // Compare fields
    }

    // Overriding hashCode() to return a consistent hash code based on name and age
    @Override
    public int hashCode() {
        return Objects.hash(name, age);  // Combine fields for hash code
    }

    // Getter methods for name and age (optional)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString() for easier visualization (optional)
    @Override
    public String toString() {
        return "Pupil{name='" + name + "', age=" + age + "}";
    }
}


public class MapAndHashcode {
    public static void main(String[] args) {
        // Create two Pupil objects with the same data
        Pupil p1 = new Pupil("Alice", 30);
        Pupil p2 = new Pupil("Alice", 30);

        // Create a HashMap to test equals() and hashCode() together
        Map<Pupil, String> map = new HashMap<>();
        map.put(p1, "Engineer");

        // Since p2 has the same data as p1, map.get(p2) should return "Engineer"
        System.out.println(map.get(p2));  // Output: Engineer
    }
}


