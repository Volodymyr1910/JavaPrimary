package Day21.ait.cars.dao;

import Day21.ait.cars.model.Car;
import HW18.details_trade_v2.details_v2.model_v2.Detail_v2;

import java.util.function.Predicate;

public class GarageImplementation implements Garage {

    private Car[] cars;
    private int size;


    public GarageImplementation( int capasity) {
        this.cars = new Car [capasity];
        this.size = size;
    }

    @Override
    public boolean addCar(Car car) {
        if(car == null || size == cars.length || findCarByRegNumber(car.getRegNumber()) != null) {
            return false;
        }
        cars[size++] = car; // постфиксная операция увеличить size ПОСЛЕ добавления новой car
        return true;
    }//end  addCar

    @Override
    public Car removeCar(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars[i].getRegNumber().equals(regNumber)) {
                Car victim = cars[i];
                cars[i] = cars[size - 1];
                size--;
                return victim;
            }//end if
        }//end fori
        return null;
    }//end removeCar

    @Override
    public Car findCarByRegNumber(String regNumber) {
        for (int i = 0; i < size; i++) {
            if (cars [i].getRegNumber().equals(regNumber)){
                return cars [i];
            }//end if
        }//end for
        return null;
    }//end findCarByRegNumber

    @Override
    public Car[] findCarsByModel(String model) {
        return findCarsByPredicate(car -> car.getModel().equals(model));
    }//end findCarsByModel

    @Override
    public Car[] findCarsByCompany(String company) {
        return findCarsByPredicate(car -> car.getCompany().equals(company));
    }//end findCarsByCompany

    @Override
    public Car[] findCarsByEngine(double min, double max) {
        return findCarsByPredicate(c -> c.getEngine() > min && c.getEngine() < max);
    }//end findCarsByEngine

    @Override
    public Car[] findCarsByColor(String color) {
        return findCarsByPredicate(car -> car.getColor().equals(color));
    }//end findCarsByColor

    @Override
    public int size() {
        return size;
    }//end size

    @Override
    public void printCars() {
        for (int i = 0; i < size; i++) {
            System.out.println(cars[i]);
        }//end for
    }//end printCars

    // в этот метод передаем логическое выражение, которое будет тестировать объекты типа Car
    private Car[] findCarsByPredicate(Predicate<Car> predicate){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(predicate.test(cars[i])){ // объект проходит тест
                count++;
            }//end if
        }//end for
        // читаем массив и перекладываем рез-ты в новый
        Car[] res = new Car[count];
        for (int i = 0, j = 0 ; j < res.length; i++) {
            if(predicate.test(cars[i])){
                res[j++] = cars[i];
            }//end if
        }//end for
        return res;
    }//end findCarsByPredicate





}//end class
