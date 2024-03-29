package org.example.model;

//  22.09.2022  Запретить создание экземпляров класса Transport, метод getPrice сделать абстрактным.
//
public abstract class Transport implements Repairable
{

    private String name; //Название
    private int capacity; //Вместимость
    private int speed; //Скорость
    private float costOfKm;//Стоимость километра
    private boolean isRepairing;//Состояние на ремонте



    // Конструктор - один за всех
    public Transport(String name, int capacity, int speed, float costOfKm) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.costOfKm = costOfKm;
    }

    // Геттеры-сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getCostOfKm() {
        return costOfKm;
    }

    public void setCostOfKm(float costOfKm) {
        this.costOfKm = costOfKm;
    }


    // Подсчёт стоимости перевозки
    public abstract float getPrice(City city);



    //Постановка и снятие с ремонта
    @Override
    public void startRepair() { this.isRepairing = true; }

    @Override
    public void finishRepair() {
        this.isRepairing = false;
    }

    @Override
    public boolean isRepairing() {
        return isRepairing;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", speed=" + speed +
                ", costOfKm=" + costOfKm +
                ", isRepairing=" + isRepairing +
                '}';
    }
}
