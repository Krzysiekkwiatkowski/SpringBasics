package pl.coderslab.day1homework.beans;

import java.util.List;

public interface CustomerRepository {
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    List<Customer> showCustomers();
}
