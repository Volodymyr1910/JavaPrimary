package Day21.ait.cars.dao;

import Day21.ait.cars.model.Car;

public interface Garage {

    boolean addCar(Car car);
    Car removeCar (String regNumber);
    Car findCarByRegNumber (String regNumber);
    Car [] findCarsByModel (String model);
    Car [] findCarsByCompany (String company);
    Car [] findCarsByEngine (double min, double max);
    Car [] findCarsByColor (String color);
    int size();
    void printCars ();

}//interface