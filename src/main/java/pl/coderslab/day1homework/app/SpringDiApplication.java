package pl.coderslab.day1homework.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.day1homework.beans.*;

import java.util.List;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerLogger customerLogger = (CustomerLogger) context.getBean("simpleCustomerLogger");
        customerLogger.log();
        Customer customer = new Customer(1, "Marek", "Markowski", "Marecki");
        CustomerRepository customerRepository = (CustomerRepository) context.getBean("DBCustomerRepository");
        customerRepository.addCustomer(customer);
        List<Customer> customers = customerRepository.showCustomers();
        for (Customer loadedCustomer : customers) {
            System.out.println(loadedCustomer.getId() + " " + loadedCustomer.getFirstName() + " " + loadedCustomer.getLastName() + " " + loadedCustomer.getNickName());
        }
    }
}
