package org.example;


import org.springframework.stereotype.Component;

@Component
public class TransportFactory {

    public Transport getTransport(City city, int weight, int hours){

        float requiredSpeed = (float) city.getDistanceKm()/hours;

        return requiredSpeed < 40 && city.isOnWater() ? getShip(getRightCapacity(weight), getRightSpeed(requiredSpeed))
                : requiredSpeed > 120 && city.isHasAirport() ? getPlane(getRightCapacity(weight), getRightSpeed(requiredSpeed))
                : getTruck(getRightCapacity(weight), getRightSpeed(requiredSpeed));
    }

    private int getRightSpeed (float requiredSpeed){

        final int speedMultiplicity = 10;

        return requiredSpeed<= speedMultiplicity ? speedMultiplicity
                : requiredSpeed / speedMultiplicity == requiredSpeed % speedMultiplicity ? (int) requiredSpeed //Кажется бессмысленно лишний код... всё равно 2 операции - можно было просто посчитать последним условием
                : (int) (Math.ceil(requiredSpeed / speedMultiplicity)* speedMultiplicity);
    }

    private int getRightCapacity (int weight){

        final int weightMultiplicity = 500;

        return weight <= weightMultiplicity ? weightMultiplicity
                : (float) weight / weightMultiplicity == weight % weightMultiplicity ? weight //Кажется бессмысленно лишний код... всё равно 2 операции - можно было просто посчитать последним условием
                : (int) (Math.ceil((float) weight/ weightMultiplicity))* weightMultiplicity;
    }

    private Transport getTruck (int capacity, int speed ){

        final float costOfKm = 2.5f;
        final String trackName = "Автопоезд 'Mad Max'";

        return new Truck(trackName,capacity, speed, costOfKm);
    }

    private Transport getShip (int capacity, int speed ){

        final float costOfKm = 1.7f;
        String shipName = "Сухогруз 'Доктор наук профессор Шварценгольд'";

        return new Ship(shipName,capacity, speed, costOfKm);
    }

    private Transport getPlane (int capacity, int speed ){

        final float costOfKm = 7.8f;
        String airplaneName = "Грузовой самолёт 'Сибирский буревестник'";

        return new Plane(airplaneName,capacity, speed, costOfKm);
    }


}
