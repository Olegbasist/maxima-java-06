package org.example;

import org.example.config.SpringConfig;
import org.example.model.City;
import org.example.model.Transport;
import org.example.services.Logistics;
import org.example.services.TransportFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;


//  Взять необходимые классы из модуля 2
//  Классы Logistics и TransportFactory модуля сделать бинами,
//  использовать разные способы их конфигурирования.
//  Комментарий: Logistic описан двумя способами, это избыточно.
// -----------------------------------------------------------------------------------
//  Модифицировать класс Logistics так,
//  чтобы при отсутствии доступных транспортов фабрикой создавался бы новый транспорт.
//
//  Метод getTransport в классе TransportFactory не должен быть статическим !!
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Поднимаю контекст ...");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TransportFactory transportFactory = context.getBean(TransportFactory.class);


        Logistics logistics = context.getBean(Logistics.class);

        City city = getRandomCity();

        System.out.println("Даю логистику!");
        Transport vehicle = logistics.getShipping(city,1,1);
        System.out.println(city);
        System.out.println(vehicle.toString());

        System.out.println("Получаю транспорт от фабрики:");
        System.out.println(city);
        System.out.println(transportFactory.getTransport(city,1,1).toString());
        System.out.println(getRandomTransportFromFactory(transportFactory));

    }
    public static City getRandomCity (){
        Random random = new Random();
        int distance = random.nextInt(15000);
        boolean hasAirport = random.nextBoolean();
        boolean isOnWater = random.nextBoolean();

        return new City("City of Random",distance,hasAirport,isOnWater);
        }
        private static Transport getRandomTransportFromFactory (TransportFactory transportFactory){
            Random random = new Random();
            int weight = random.nextInt(10000);
            int hours = random.nextInt(24);

            return transportFactory.getTransport(getRandomCity(), weight,hours);

        }

}
