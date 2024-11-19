package HW11.best_offer;

import HW11.best_offer.model.OfferAppartaments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestOfferApplicationTest {

    OfferAppartaments offerTown;


    @BeforeEach
    void setUp() {
        offerTown = new OfferAppartaments("berlin", "10117", "400 m", "1800 m^2", false, 2, true, 85, 5, true);
    }



    @Test
    //"String town; //Berlin");
    void validatorTest1() {
        assertEquals("berlin", offerTown.getTown());

    }

    //String postIndex; // 10117 or 10178 or 10179 индексы центальных раенов
    @Test
    void validatorTest2() {
        assertEquals("10117", offerTown.getPostIndex());
    }

    //String RangeToNearestPublicTransportStop; // not clother than 100 m, not futher than 500 m
    @Test
    void validatorTest3() {
        assertEquals("400 m", offerTown.getRangeToNearestPublicTransportStop());
    }

    //String parkingSquare; // square not less than 1500 m^2
    @Test
    void validatorTest4() {
        assertEquals("1800 m^2", offerTown.getParkingSquare());
    }

    //boolean parkingIsUnderGround; //false
    @Test
    void validatorTest5() {
        assertEquals(false, offerTown.isParkingIsUnderGround());
    }

    //int floor; // 2, 3, or 4
    @Test
    void validatorTest6() {
        assertEquals(2, offerTown.getFloor());
    }

    //boolean elevator; //true
    @Test
    void validatorTest7() {
        assertEquals(true, offerTown.isElevator());
    }

    //double livingArea; // from 80 to 130 m^2
    @Test
    void validatorTest8() {
        assertEquals(85, offerTown.getLivingArea());
    }

    //int numberOfRooms; // from 3 to 5
    @Test
    void validatorTest9() {
        assertEquals(5, offerTown.getNumberOfRooms());
    }

    //boolean balcony; //true
    @Test
    void validatorTest10() {
        assertEquals(true, offerTown.isBalcony());
    }



}//end class