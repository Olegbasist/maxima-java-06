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

        System.out.println("Получаю транспорт:");
        getTransportFromFactory(factory);
    }
    private static City getRandomCity (){
        Random random = new Random();
        int distance = random.nextInt(15000);
        boolean hasAirport = random.nextBoolean();
        boolean isOnWater = random.nextBoolean();

        return new City("City of Random",distance,hasAirport,isOnWater);
    }
    private static void getTransportFromFactory (TransportFactory factory){
        Random random = new Random();
        int weight = random.nextInt(10000);
        int hours = random.nextInt(24);

        System.out.println(factory.getTransport(getRandomCity(),weight,hours).getName());
        //return factory.getTransport(getRandomCity(), weight,hours);

    }
}
