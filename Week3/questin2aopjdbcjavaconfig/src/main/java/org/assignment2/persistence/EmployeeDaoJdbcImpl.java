package org.assignment2.persistence;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Repository(value = "dao")
@Profile("jdbc")
public class EmployeeDaoJdbcImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDaoJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));

    }

    @Override
    public Employee addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, dept, salary) VALUES (?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // Insert employee and get the generated key
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getDept());
            ps.setDouble(3, employee.getSalary());
            return ps;
        }, keyHolder);

        // Get the generated key (employee ID)
        Number key = keyHolder.getKey();
        if (key != null) {
            employee.setId(key.intValue()); // Set the generated ID to the employee
        }

        return employee;


    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        String sql = "UPDATE employees SET name = ?, dept = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql,employee.getName(),employee.getDept(),employee.getSalary(),id);


    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Employee.class),id);
        if(employee != null)
            return employee;
        return null;
    }
}
