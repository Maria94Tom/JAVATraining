package com.employee.entities;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Employee {


    private int id;
    private String name;
    private String dept;
    private int salary;

//    public Employee(int id, String name, String dept, int salary) {
//        this.id = id;
//        this.name = name;
//        this.dept = dept;
//        this.salary = salary;
//    }


}
