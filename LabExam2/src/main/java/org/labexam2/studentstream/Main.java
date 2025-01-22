package org.labexam2.studentstream;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();

        // Add students to map
        map.put(new Student(109, "Raj", 95), 95);
        map.put(new Student(61, "Keta", 78), 78);
        map.put(new Student(11, "Gunika", 98), 98);
        map.put(new Student(19, "Keshav", 97), 97);

        // Sort records by student name
        List<Student> studentsByName = new ArrayList<>(map.keySet());
        Collections.sort(studentsByName);
        System.out.println("Sorted by Name:");
        for (Student student : studentsByName) {
            System.out.println(student);
        }

        // Sort records by student ID
        List<Student> studentsById = new ArrayList<>(map.keySet());
        studentsById.sort(Comparator.comparingInt(Student::getId));
        System.out.println("\nSorted by ID:");
        for (Student student : studentsById) {
            System.out.println(student);
        }
    }
}