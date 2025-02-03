package com.employee.entities;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Employee {


    private int id;
    private String name;
    private String dept;
    private BigDecimal salary;

    public Employee( String name, String dept, BigDecimal salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }


}
