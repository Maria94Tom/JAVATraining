package org.labexam.question2.repository;

import java.util.List;

public interface CustomerDao {
    public Customers addCustomer(Customers customer);
    public List<Customers> getCustomerById(int id);
}
