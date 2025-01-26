package org.assignment2.persistence;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeDaoJdbcImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDaoJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Employee.class));

    }

    @Override
    public Employee addEmployee(Employee employee) {
        String sql = "INSERT INTO employee(name,dept,salary) VALUES(?,?,?)";
        jdbcTemplate.update(sql,employee.getName(),employee.getDept(),employee.getSalary());
        return employee;

    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        String sql = "UPDATE employee SET name = ?, dept = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql,employee.getName(),employee.getDept(),employee.getSalary(),id);


    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Employee.class),id);
        if(employee != null)
            return employee;
        return null;
    }
}
