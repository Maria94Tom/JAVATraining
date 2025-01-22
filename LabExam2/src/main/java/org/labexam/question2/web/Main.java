package org.labexam.question2.web;

import org.labexam.question2.repository.Customers;
import org.labexam.question2.service.CustomerServiceImpl;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(String.valueOf(Main.class));
    public static void main(String[] args) {
logger.info("Customer Application started");

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.addCustomer(new Customers(22,"B","Bangalore",123455680));
        customerService.getCustomerById(1).forEach(System.out::println);



    }
}
