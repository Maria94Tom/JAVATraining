package org.labexam2.studentstream;

import java.util.Objects;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private int marks;

    // Constructor
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Implementing equals and hashcode (based on id for uniqueness)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Implementing Comparable interface to compare by name
    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name); // Sorting by name
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', marks=" + marks + "}";
    }
}
