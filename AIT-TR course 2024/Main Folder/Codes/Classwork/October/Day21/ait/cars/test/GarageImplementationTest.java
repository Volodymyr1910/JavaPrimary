package Day21.ait.cars.test;

import Day21.ait.cars.dao.Garage;
import Day21.ait.cars.dao.GarageImplementation;
import Day21.ait.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageImplementationTest {

private Garage garage;
private Car[] c;


    @BeforeEach
    void setUp() {

        garage = new GarageImplementation(5);

        Car c[] = new Car [5];

        c[0] = new Car("Number1", "Model1", "Company1", 1.5, "Red");
        c[1] = new Car("Number2", "Model2", "Company1", 2.5, "Green");
        c[2] = new Car("Number3", "Model1", "Company2", 1.5, "Red");
        c[3] = new Car("Number4", "Model4", "Company2", 2.0, "Green");

        //TODO добавить машины в гараж
        for (int i = 0; i < 4; i++) {
            garage.addCar(c[i]);
        }//end for

    }//end setUp

    @Test
    void addCarTest() {




    }//end addCarTest

    @Test
    void removeCarTest() {
    }

    @Test
    void findCarByRegNumberTest() {
    }

    @Test
    void findCarsByModelTest() {

        Car[] expected = {c[0], c[2]};
        Car[] actual = garage.findCarsByModel("Model1");
        assertArrayEquals(expected, actual);

    }//end findCarsByModelTest

    @Test
    void findCarsByCompanyTest() {
    }

    @Test
    void findCarsByEngineTest() {
    }

    @Test
    void findCarsByColorTest() {
    }

    @Test
    void printCarsTest() {
        garage.printCars();


    }//end printCarsTest

    @Test
    void sizeTest() {
        assertEquals(4,garage.size());

    }//end sizeTest


}//end class