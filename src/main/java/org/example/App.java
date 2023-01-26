package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;


//  Взять необходимые классы из модуля 2
//  Классы Logistics и TransportFactory модуля сделать бинами,
//  использовать разные способы их конфигурирования.
//  TODO: Комментарий: Logistic описан двумя способами, это избыточно.
// -----------------------------------------------------------------------------------
// TODO: Модифицировать класс Logistics так,
//  чтобы при отсутствии доступных транспортов фабрикой создавался бы новый транспорт.
//
// TODO: Метод getTransport в классе TransportFactory не должен быть статическим !!
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Поднимаю контекст ...");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TransportFactoryAnotherTry anotherTransportFactory = context.getBean(TransportFactoryAnotherTry.class);
        TransportFactory transportFactory = context.getBean(TransportFactory.class);

        System.out.println("Получаю транспорт:");
        City city = getRandomCity();
        System.out.println(anotherTransportFactory.getTransport(city,1000,240).getName());
        System.out.println(transportFactory.getTransport(city,50,4));


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
