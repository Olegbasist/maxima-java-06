package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



//  Взять необходимые классы из модуля 2
//  Классы Logistics и TransportFactory модуля сделать бинами,
//  TODO: использовать разные способы их конфигурирования.
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Поднимаю контекст ...");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.getBean()

        System.out.println("Получаю транспорт:");

    }
}
