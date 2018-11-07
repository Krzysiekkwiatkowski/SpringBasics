package pl.coderslab.day1homework.beans;

import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Logger {
    private CustomerLogger customerLogger;

    public Logger() {
    }

    @Autowired
    public Logger(@Qualifier("test") CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    public void setCustomerLogger(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    public CustomerLogger getCustomerLogger() {
        return customerLogger;
    }
}
