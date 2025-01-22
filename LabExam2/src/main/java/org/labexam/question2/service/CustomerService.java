package org.labexam.question2.service;

import org.labexam.question2.repository.Customers;


import java.util.List;

public interface CustomerService {
    public Customers addCustomer(Customers customer);
    public List<Customers> getCustomerById(int id);


}
