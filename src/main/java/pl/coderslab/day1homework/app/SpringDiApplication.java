package pl.coderslab.day1homework.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.day1homework.beans.*;

public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleCustomerLogger simpleCustomerLogger = (SimpleCustomerLogger) context.getBean("simpleCustomerLogger");
        simpleCustomerLogger.log();
        MemoryCustomerRepository memory = (MemoryCustomerRepository) context.getBean("memoryCustomerRepository");
        Customer customer = new Customer(1, "Krzysiek", "Kwiat", "Kriss");
        memory.addCustomer(customer);
        FileCustomerLogger logger = (FileCustomerLogger) context.getBean("fileCustomerLogger");
        logger.log();
        DBCustomerLogger saveToDb = (DBCustomerLogger) context.getBean("DBCustomerLogger");
        saveToDb.log();
    }
}
