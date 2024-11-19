package HW17.details_trade.details.test;

import HW17.details_trade.details.dao.Stock;
import HW17.details_trade.details.dao.StockImplementation;
import HW17.details_trade.details.model.Detail;
import HW17.details_trade.details.model.Gear;
import HW17.details_trade.details.model.Lever;
import HW17.details_trade.details.model.Rugs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockImplementationTest {

    Stock stock;
    Detail [] det;

    @BeforeEach
    void setUp() {
        stock = new StockImplementation(7);
       det = new Detail [6];

        det[0] = new Gear(100000000000000l, 10,"M1",0.15,"V1",7.5,200, 6.5,2, 3);
        det[1] = new Lever(100000000000001l, 11,"M2",0.15,"V2",10,400, 200,0.95);
        det[2] = new Rugs(100000000000002l, 12,"M4",0.15,"V1",7.5,200, true);
        det[3] = new Gear(100000000000003l, 13,"M1",0.25,"V7",15,1000, 4,3, 2);
        det[4] = new Rugs(100000000000004l, 12,"M4",0.11,"V4",3,150, false);
        det[5] = new Lever(100000000000005l, 10,"M3",0.12,"V4",14,700, 150,0.8);


        for (int i = 0; i < 6; i++) {
            stock.addSparePart(det[i]);
        }//end for

    }//end setUp

    @Test
    void addSparePartTest() {
        //try to add null
        assertFalse(stock.addSparePart(null));
        //try to add duplicate
        assertFalse(stock.addSparePart(det[0]));
        //add new spare part
        Detail detNew = new Rugs(100000000000010l, 8,"M8",0.18,"V8",8,200, false);
        assertTrue(stock.addSparePart(detNew));
        //check size
        System.out.println(stock.quantityOfSpareParts());
        stock.printSparePart();
        // try to add when no free space in storage
        Detail detNew2 = new Rugs(100000000000015l, 8,"M8",0.18,"V8",8,200, false);
        assertFalse(stock.addSparePart(detNew2));
    }//end addSparePartTest

    @Test
    void findSparePartTest() {



    }//end findSparePartTest

    @Test
    void findSparePartByVendorTest() {
    }

    @Test
    void findSparePartByMaterialTest() {
    }

    @Test
    void findSparePartWithDiscountTest() {
    }

    @Test
    void findSparePartWithFixedDiscountTest() {
    }

    @Test
    void findSetSparePartTest() {
    }

    @Test
    void findCheapestSparePartTest() {
    }

    @Test
    void updateSparePartTest() {
    }

    @Test
    void removeSparePartTest() {
        //remove absent spare part
        Detail detNew = new Rugs(100000000000010l, 8,"M8",0.18,"V8",8,200, false);
        assertNull(stock.removeSparePart(100000000000010l));

        //remove spare part
        assertEquals(det[0], stock.removeSparePart(100000000000000l));
        stock.printSparePart();

        //size
        assertEquals(5, stock.quantityOfSpareParts());
    }//end removeSparePartTest

    @Test
    void totalWeightInStorageTest() {
    }

    @Test
    void averageWeightSparePartInStorageTest() {
    }

    @Test
    void quantityOfSparePartsTest() {
        assertEquals(6,stock.quantityOfSpareParts());
    }

    @Test
    void printSparePartTest() {
        stock.printSparePart();

    }//end printSparePartTest
}