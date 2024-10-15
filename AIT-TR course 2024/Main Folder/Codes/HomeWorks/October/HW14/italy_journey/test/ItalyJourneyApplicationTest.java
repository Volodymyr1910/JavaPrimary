package HW14.italy_journey.test;

import HW14.italy_journey.ItalyJourneyApplication;
import HW14.italy_journey.model.ItalyJourney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItalyJourneyApplicationTest {

    ItalyJourney j1 = new ItalyJourney("B1",'b', 1f,20);
    ItalyJourney j2 = new ItalyJourney("B2",'b', 10f,40);
    ItalyJourney j3 = new ItalyJourney("B3",'d', 1f,20);
    ItalyJourney j4 = new ItalyJourney("B4",'d', 10f,40);

    @BeforeEach
    void setUp() {
    }

    @Test
    void bestPriceFinder() {

        ItalyJourney  [] arrayTest = new ItalyJourney[2];
        arrayTest [0] = j1;
        arrayTest [1] = j3;
        String expected = arrayTest[0].getBrand();


        final int RANGE_OF_TRIP = 6000;
        final float DAY_DRIVING = 8;
        final float AVERAGE_SPEED = 90;
        float drivingDays = RANGE_OF_TRIP / (AVERAGE_SPEED * DAY_DRIVING);
        ItalyJourney[] generalArray = new ItalyJourney[5];
        Float[] totalCostArray = new Float[generalArray.length];
        Float[] roadCostArray = new Float[generalArray.length];
        Float[] rentCostArray = new Float[generalArray.length];

        int actual = ItalyJourney.bestPriceFinder (arrayTest, roadCostArray,rentCostArray,totalCostArray,2f,2f,1000,5,8f,100f);

        assertEquals(expected, actual, "Method Failed");

    }
}