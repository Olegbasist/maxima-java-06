package org.example;

import org.example.config.SpringConfig;
import org.example.model.City;
import org.example.model.Transport;
import org.example.services.Logistics;
import org.example.services.TransportFactory;
import org.example.services.TransportFactoryAnotherTry;
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
// TODO: Метод getTransport в классе TransportFactory не должен быть статическим !!
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Поднимаю контекст ...");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //TransportFactoryAnotherTry anotherTransportFactory = context.getBean(TransportFactoryAnotherTry.class);
        //TransportFactory transportFactory = context.getBean(TransportFactory.class);

        Logistics logistics = context.getBean(Logistics.class);

        System.out.println("Даю логистику!");
        Transport vehicle = logistics.getShipping(getRandomCity(),1,0);
        System.out.println(vehicle.toString());

        /*System.out.println("Получаю транспорт:");
        City city = getRandomCity();
        System.out.println(anotherTransportFactory.getTransport(city,1000,240).getName());
        System.out.println(transportFactory.getTransport(city,50,4).getName());*/

    }
    public static City getRandomCity (){
        Random r = new Random();
        int distance = r.nextInt(15000);
        boolean hasAirport = r.nextBoolean();
        boolean isOnWater = r.nextBoolean();

        return new City("City of Random",distance,hasAirport,isOnWater);
        }
        /*private static void getTransportFromFactory (TransportFactory factory){
            Random random = new Random();
            int weight = random.nextInt(10000);
            int hours = random.nextInt(24);

            System.out.println(factory.getTransport(getRandomCity(),weight,hours).getName());
            //return factory.getTransport(getRandomCity(), weight,hours);

        }*/

}
