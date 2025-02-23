package com.employee.controller;

import com.employee.config.JwtService;
import com.employee.repo.Employee;
import com.employee.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
//@RequestMapping("api")
public class EmployeeController {
    public static final Logger logger = Logger.getLogger(EmployeeController.class.getName());
    private EmployeeService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployees(){
    logger.info("Getting all employees");
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployees());
    }

    @PreAuthorize("hasAuthority('ROLE_MANAGER') or hasAuthority('ROLE_TEAMLEAD')")
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        logger.info("Getting employee with id: "+id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeById(id));
    }
 //   @Operation(summary = "Add employee")
  //  @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping("employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addEmployee(employee));
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateEmployee(id, employee));
    }

    @PreAuthorize("hasAuthority('ROLE_TEAMLEAD')")
    @DeleteMapping("employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
        service.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }



}
