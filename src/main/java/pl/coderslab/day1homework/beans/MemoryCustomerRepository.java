package pl.coderslab.day1homework.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryCustomerRepository implements CustomerRepository {
    private ArrayList<Customer> customers = new ArrayList<>();
    private CustomerLogger customerLogger;

    @Autowired
    public MemoryCustomerRepository(@Qualifier("test") CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerLogger.log();
        customers.add(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerLogger.log();
        customers.remove(id);
    }

    @Override
    public List<Customer> showCustomers() {
        customerLogger.log();
        ArrayList<Customer> customerList = customers;
        return customerList;
    }
}
