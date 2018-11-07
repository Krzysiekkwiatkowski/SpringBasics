package pl.coderslab.day1homework.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DBCustomerRepository implements CustomerRepository {
    private DBBean dbBean;
    private String ADD_CUSTOMER = "INSERT INTO customers VALUES (?,?,?,?)";
    private String DELETE_CUSTOMER = "DELETE FROM customers WHERE id = ?";
    private String SHOW_CUSTOMERS = "SELECT * FROM customers";

    @Autowired
    public void setDbBean(DBBean dbBean){
        this.dbBean = dbBean;
    }

    @Override
    public void addCustomer(Customer customer) {
        try {
            Connection connection = dbBean.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setString(4, customer.getNickName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            Connection connection = dbBean.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> showCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = dbBean.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("nickname"));
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return customers;
    }
}
