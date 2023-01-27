package org.example.services;

import org.example.model.Transport;
import org.example.model.City;
import org.springframework.stereotype.Component;

@Component
public class Logistics {

    Transport[] vehicles;
    boolean shippingIsAvailable;

    public Logistics(Transport ... vehicles) {
        this.vehicles=vehicles;
    }

    public Transport getShipping(City city, int weight, int hours){
        float costOfDelivery;
        float minCostOfDelivery = Float.MAX_VALUE;
        Transport cheapestVehicle = null;


            for (Transport obj : vehicles) {
                costOfDelivery = obj.getPrice(city);
                shippingIsAvailable = isShippingAvailable(city, weight, hours, obj);

                if (shippingIsAvailable && minCostOfDelivery > costOfDelivery) {
                    minCostOfDelivery = costOfDelivery;
                    cheapestVehicle = obj;
                }
            }


        return cheapestVehicle;
    }

    private boolean isShippingAvailable(City city, int weight, int hours, Transport obj){
        shippingIsAvailable = obj.getPrice(city) != 0
                && city.getDistanceKm() / obj.getSpeed() <= hours
                && obj.getCapacity() >= weight
                && !(obj.isRepairing());

        if (obj.isRepairing()){
            System.out.println("Самый дешевый транспорт в логистике - на ремонте!");
        }
        return shippingIsAvailable;
    }



}