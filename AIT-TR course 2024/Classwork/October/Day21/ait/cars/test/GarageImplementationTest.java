package Day21.ait.cars.test;

import Day21.ait.cars.dao.Garage;
import Day21.ait.cars.dao.GarageImplementation;
import Day21.ait.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplementationTest {

 Garage garage;
 Car[] cars;


    @BeforeEach
    void setUp() {

        garage = new GarageImplementation(5);

        cars = new Car [5];

        cars[0] = new Car("Number1", "Model1", "Company1", 1.1, "Red");
        cars[1] = new Car("Number2", "Model2", "Company1", 2.5, "Green");
        cars[2] = new Car("Number3", "Model1", "Company2", 1.5, "Red");
        cars[3] = new Car("Number4", "Model4", "Company2", 2.0, "Green");

        //TODO add cars to garage
        for (int i = 0; i < 4; i++) {
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
        Car carNew = new Car("Number 7", "M8","V8",3.5,"Green");
        assertTrue(garage.addCar(carNew));
        //check size
        System.out.println(garage.size());
        garage.printCars();
        // try to add when no free space
        Car carNew2 = new Car("Number 7", "M8","V8",3.5,"Green");
        assertFalse(garage.addCar(carNew2));
    }//end addCarTest

    @Test
    void removeCarTest() {
        //remove absent car
        Car carNew2 = new Car("Number 7", "M8","V8",3.5,"Green");
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
        Car [] exp = {cars[2], cars[3]};
        assertArrayEquals(exp, garage.findCarsByCompany("Company2"));
    }//end findCarsByCompanyTest

    @Test
    void findCarsByEngineTest() {
        Car [] exp = {cars[0], cars[2]};
        assertArrayEquals(exp, garage.findCarsByEngine(1,2));
    }//end findCarsByEngineTest

    @Test
    void findCarsByColorTest() {
        Car [] exp = {cars[1], cars[3]};
        assertArrayEquals(exp, garage.findCarsByColor("Green"));
    }//end findCarsByColorTest

    @Test
    void printCarsTest() {
        garage.printCars();


    }//end printCarsTest

    @Test
    void sizeTest() {
        assertEquals(4,garage.size());

    }//end sizeTest


}//end class