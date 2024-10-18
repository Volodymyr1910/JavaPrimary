package HW17.car_parts.details.test;

import HW17.car_parts.details.dao.Stock;
import HW17.car_parts.details.dao.StockImplementation;
import HW17.car_parts.details.model.Detail;
import HW17.car_parts.details.model.Gear;
import HW17.car_parts.details.model.Lever;
import HW17.car_parts.details.model.Rugs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockImplementationTest {

    Stock stock;
    Detail [] det;

    @BeforeEach
    void setUp() {

        Stock stock1 = new StockImplementation(7);
       det = new Detail [6];

        det[0] = new Gear(100000000000000l, 10,"M1",0.15,"V1",7.5,200, 6.5,2, 3);
        det[1] = new Lever(100000000000001l, 11,"M2",0.15,"V2",10,400, 200,0.95);
        det[2] = new Rugs(100000000000002l, 12,"M4",0.15,"V1",7.5,200, true);
        det[3] = new Gear(100000000000003l, 13,"M1",0.25,"V7",15,1000, 4,3, 2);
        det[4] = new Rugs(100000000000004l, 12,"M4",0.11,"V4",3,150, false);
        det[5] = new Lever(100000000000005l, 10,"M3",0.12,"V4",14,700, 150,0.8);


    }//end setUp

    @Test
    void addSparePart() {
    }

    @Test
    void findSparePart() {
    }

    @Test
    void findSparePartByVendor() {
    }

    @Test
    void findSparePartByMaterial() {
    }

    @Test
    void findSparePartWithDiscount() {
    }

    @Test
    void findSparePartWithFixedDiscount() {
    }

    @Test
    void findSetSparePart() {
    }

    @Test
    void findCheapestSparePart() {
    }

    @Test
    void updateSparePart() {
    }

    @Test
    void removeSparePart() {
    }

    @Test
    void totalWeightInStorage() {
    }

    @Test
    void averageWeightSparePartInStorage() {
    }

    @Test
    void quantityOfSpareParts() {
    }

    @Test
    void printSparePart() {
    }
}