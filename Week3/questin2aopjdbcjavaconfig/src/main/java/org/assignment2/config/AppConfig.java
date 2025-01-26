package org.assignment2.config;


import org.assignment2.persistence.EmployeeDao;
//import org.assignment2.persistence.EmployeeDaoImp;
import org.assignment2.persistence.EmployeeDaoJdbcImpl;
import org.assignment2.services.EmployeeService;
import org.assignment2.services.EmployeeServiceImpl;
import org.assignment2.services.aspect.MethodLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.assignment2")
@EnableAspectJAutoProxy
@PropertySource("application.properties")
public class AppConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;




@Bean
    public MethodLogger methodLogger() {
        return new MethodLogger();
    }
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl();
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDaoJdbcImpl(dataSource());
    }
}
