package org.assignment2.config;


import org.assignment2.persistence.EmployeeDao;
import org.assignment2.persistence.EmployeeDaoImp;
import org.assignment2.services.EmployeeService;
import org.assignment2.services.EmployeeServiceImpl;
import org.assignment2.services.aspect.MethodLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.assignment2")
@EnableAspectJAutoProxy
public class AppConfig {
@Bean
    public MethodLogger methodLogger() {
        return new MethodLogger();
    }
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl();
    }
    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoImp();
    }
}
