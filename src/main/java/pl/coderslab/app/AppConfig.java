package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pl.coderslab.beans.*;

@Configuration
@ComponentScan(basePackages = "pl.coderslab")
public class AppConfig {
    @Bean
    public HelloWorldAnnotation helloWorldAnnotation(){
        return new HelloWorldAnnotation();
    }

    @Bean
    public Captain jackSparrow() {
        return new Captain();
    }

    @Bean
    public Ship blackPearl() {
        return new Ship(jackSparrow());
    }

    @Bean
    public Scope1 scope1(){
        return new Scope1();
    }

    @Bean
    @Scope("prototype")
    public Scope2 scope2(){
        return new Scope2();
    }
}
