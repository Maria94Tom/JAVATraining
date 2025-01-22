package org.labexam.question2.repository;

import org.labexam.question2.exceptions.CustomerDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static factory.ConnectionFactory.connection;

public class CustomerDaoImpl implements CustomerDao {

    public CustomerDaoImpl() {
        Connection connection= factory.ConnectionFactory.getConnection();
    }
    @Override
    public Customers addCustomer(Customers customer) {
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("insert into customer (name,address,phone_number) values(?,?,?)");
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getAddress());
            preparedStatement.setInt(3,customer.getPhone_number());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomerDaoException(e.getMessage(),e);
        }
        return customer;
    }

    @Override
    public List<Customers> getCustomerById(int id) {
        List <Customers> customerById =new ArrayList<>();
        try{
            PreparedStatement preparedStatement= connection.prepareStatement("select * from customer where id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                customerById.add(new Customers(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getInt("phone_number")));
            }



        } catch (SQLException e) {
            throw new CustomerDaoException(e.getMessage(),e);
        }
        return customerById;
    }
}
