package HW18.cars.test;

import HW18.cars.dao.Garage;
import HW18.cars.dao.GarageImplementation;
import HW18.cars.model.Car;
import MyMethods.array_methods.ArrayMethods_Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplementationTest {

    Garage garage;
    Car[] cars;


    @BeforeEach
    void setUp() {

        garage = new GarageImplementation(7);

        cars = new Car[6];

        cars[0] = new Car("Number6", "Model1", "X", 1.1, "Red");
        cars[1] = new Car("Number2", "Model5", "Q", 2.5, "Green");
        cars[2] = new Car("Number4", "Model4", "C", 1.5, "Red");
        cars[3] = new Car("Number5", "Model7", "A", 2.0, "Green");
        cars[4] = new Car("Number8", "Model9", "M", 4.0, "Green");
        cars[5] = new Car("Number1", "Model2", "V", 1.4, "Green");

        //TODO add cars to garage
        for (int i = 0; i < 6; i++) {
            garage.addCar(cars[i]);
        }//end for

    }//end setUp

    @Test
    void addCarTest() {
        //try to add null
        assertFalse(garage.addCar(null));
        //try to add duplicate
        assertFalse(garage.addCar(cars[0]));
        //add new car
        Car carNew = new Car("Number 7", "M8", "V8", 3.5, "Green");
        assertTrue(garage.addCar(carNew));
        //check size
        System.out.println(garage.size());
        garage.printCars();
        // try to add when no free space
        Car carNew2 = new Car("Number 7", "M8", "V8", 3.5, "Green");
        assertFalse(garage.addCar(carNew2));
    }//end addCarTest

    @Test
    void removeCarTest() {
        //remove absent car
        Car carNew2 = new Car("Number 7", "M8", "V8", 3.5, "Green");
        assertNull(garage.removeCar("100000000000010l"));

        //remove car
        assertEquals(cars[0], garage.removeCar("Number1"));
        garage.printCars();

        //size
        assertEquals(3, garage.size());

    }//end removeCarTest

    @Test
    void findCarByRegNumberTest() {
        assertEquals(cars[2], garage.findCarByRegNumber("Number3"));
    }//end findCarByRegNumberTest

    @Test
    void findCarsByModelTest() {
        Car[] expected = {cars[0], cars[2]};
        Car[] actual = garage.findCarsByModel("Model1");
        assertArrayEquals(expected, actual);

    }//end findCarsByModelTest

    @Test
    void findCarsByCompanyTest() {
        Car[] exp = {cars[2], cars[3]};
        assertArrayEquals(exp, garage.findCarsByCompany("Company2"));
    }//end findCarsByCompanyTest

    @Test
    void findCarsByEngineTest() {
        Car[] exp = {cars[0], cars[2]};
        assertArrayEquals(exp, garage.findCarsByEngine(1, 2));
    }//end findCarsByEngineTest

    @Test
    void findCarsByColorTest() {
        Car[] exp = {cars[1], cars[3]};
        assertArrayEquals(exp, garage.findCarsByColor("Green"));
    }//end findCarsByColorTest

    @Test
    void printCarsTest() {
        garage.printCars();


    }//end printCarsTest

    @Test
    void sizeTest() {
        assertEquals(4, garage.size());

    }//end sizeTest

    @Test
    void sortCarsByCompanyTest() {
        Car[] exp = new Car[]{
                new Car("Number5", "Model7", "A", 2.0, "Green"),
                new Car("Number4", "Model4", "C", 1.5, "Red"),
                new Car("Number8", "Model9", "M", 4.0, "Green"),
                new Car("Number2", "Model5", "Q", 2.5, "Green"),
                new Car("Number1", "Model2", "V", 1.4, "Green"),
                new Car("Number6", "Model1", "X", 1.1, "Red"),
        };
        Car[] act = garage.sortCarsByCompany(cars);
        assertArrayEquals(exp, act);
    }//end sortCarsByCompanyTest

    @Test
    void sortCarsByModelTest() {
        Car[] exp = new Car[]{
                new Car("Number6", "Model1", "X", 1.1, "Red"),
                new Car("Number1", "Model2", "V", 1.4, "Green"),
                new Car("Number4", "Model4", "C", 1.5, "Red"),
                new Car("Number2", "Model5", "Q", 2.5, "Green"),
                new Car("Number5", "Model7", "A", 2.0, "Green"),
                new Car("Number8", "Model9", "M", 4.0, "Green"),
        };
        Car[] act = garage.sortCarsByModel(cars);
        ArrayMethods_Object.printObjectArray(act, "after sort by model");
        assertArrayEquals(exp, act);
    }//end sortCarsByModelTest

    @Test
    void sortCarsByColorTest() {
        Car[] exp = new Car[]{
                new Car("Number2", "Model5", "Q", 2.5, "Green"),
                new Car("Number5", "Model7", "A", 2.0, "Green"),
                new Car("Number8", "Model9", "M", 4.0, "Green"),
                new Car("Number1", "Model2", "V", 1.4, "Green"),
                new Car("Number6", "Model1", "X", 1.1, "Red"),
                new Car("Number4", "Model4", "C", 1.5, "Red"),
        };
        Car[] act = garage.sortCarsByColor(cars);
        ArrayMethods_Object.printObjectArray(act, "after sort by color");
        assertArrayEquals(exp, act);


    }//end sortCarsByColorTest
}//end class