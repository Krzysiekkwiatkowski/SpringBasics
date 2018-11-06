package pl.coderslab.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.*;

public class SpringDiApplicationAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorldAnnotation helloWorldAnnotation = (HelloWorldAnnotation) context.getBean("helloWorldAnnotation");
        helloWorldAnnotation.hello();
        Ship ship = context.getBean("blackPearl", Ship.class);
        ship.getCaptain().startSailing();
        Scope1 scope1 = context.getBean(Scope1.class);
        System.out.println(scope1);
        Scope1 scope11 = context.getBean(Scope1.class);
        System.out.println(scope11);
        Scope2 scope2 = context.getBean(Scope2.class);
        System.out.println(scope2);
        Scope2 scope22 = context.getBean(Scope2.class);
        System.out.println(scope22);
        Auto1 auto1 = context.getBean(Auto1.class);
        System.out.println(auto1.getAuto2().getClass().getName());
    }
}
