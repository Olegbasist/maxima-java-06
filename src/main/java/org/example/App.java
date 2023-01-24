package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

//  Взять необходимые классы из модуля 2
//  Классы Logistics и TransportFactory модуля сделать бинами,
//  TODO: использовать разные способы их конфигурирования.
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Поднимаю контекст ...");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TransportFactory factory = context.getBean(TransportFactory.class);
        
        System.out.println(factory.getTransport(getRandomCity(),1000,2).getName());
    }
    public static City getRandomCity (){
        Random r = new Random();
        int distance = r.nextInt(15000);
        boolean hasAirport = r.nextBoolean();
        boolean isOnWater = r.nextBoolean();
        return new City("City of Random",distance,hasAirport,isOnWater);
    }
}
