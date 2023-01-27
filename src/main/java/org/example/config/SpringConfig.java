package org.example.config;

import org.example.services.TransportFactoryAnotherTry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class SpringConfig {

    @Bean
    public TransportFactoryAnotherTry anotherTransportFactory(){
        return new TransportFactoryAnotherTry();
    }

    /*@Bean
    public Logistics logistics (){
        return new Logistics();
    }*/

}
