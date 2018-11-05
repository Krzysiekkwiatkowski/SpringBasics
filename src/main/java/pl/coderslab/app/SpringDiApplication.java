package pl.coderslab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.EmailService;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.MessageSender;

public class SpringDiApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld object = (HelloWorld) context.getBean("helloWorld");
        object.getMessage();
        EmailService email = (EmailService) context.getBean("emailService");
        email.send();
        MessageSender sender = (MessageSender) context.getBean("messageSender");
        sender.sendMessage();
        MessageSender messageSender = (MessageSender) context.getBean("messageSender");
        messageSender.sendMessageFromProperty();
        context.close();
    }
}
