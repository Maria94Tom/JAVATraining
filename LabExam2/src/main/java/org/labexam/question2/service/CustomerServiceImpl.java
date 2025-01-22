package org.labexam.question2.service;

import org.labexam.question2.exceptions.CustomerDaoException;
import org.labexam.question2.exceptions.CustomerNotFoundException;
import org.labexam.question2.repository.Customers;
import org.labexam.question2.repository.CustomerDao;
import org.labexam.question2.repository.CustomerDaoImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Customers addCustomer(Customers customer) {
        try {
            customerDao.addCustomer(customer);

        }
        catch(CustomerDaoException e){
            throw new CustomerNotFoundException(e.getMessage());
        }
        return customer;
    }



    @Override
    public List<Customers> getCustomerById(int id) {
        try {
            customerDao.getCustomerById(id);
        }

        catch(CustomerDaoException e){
            throw new CustomerNotFoundException(e.getMessage());
        }
       return customerDao.getCustomerById(id);

    }
}
