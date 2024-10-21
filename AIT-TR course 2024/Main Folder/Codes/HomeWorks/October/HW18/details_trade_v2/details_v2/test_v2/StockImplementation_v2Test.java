package HW18.details_trade_v2.details_v2.test_v2;

import HW18.details_trade_v2.details_v2.dao_v2.Stock_v2;
import HW18.details_trade_v2.details_v2.controller_v2.StockImplementation_v2;
import HW18.details_trade_v2.details_v2.model_v2.Detail_v2;
import HW18.details_trade_v2.details_v2.model_v2.Gear_v2;
import HW18.details_trade_v2.details_v2.model_v2.Lever_v2;
import HW18.details_trade_v2.details_v2.model_v2.Rugs_v2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockImplementation_v2Test {

    Stock_v2 stock;
    Detail_v2[] det;

    @BeforeEach
    void setUp() {
        stock = new StockImplementation_v2(7);
       det = new Detail_v2[6];

        det[0] = new Gear_v2(100000000000000l, 10,"M1",0.15,"V1",7.5,200, 6.5,2, 3);
        det[1] = new Lever_v2(100000000000001l, 11,"M2",0.15,"V2",10,400, 200,0.95);
        det[2] = new Rugs_v2(100000000000002l, 12,"M4",0.15,"V1",7.5,200, true);
        det[3] = new Gear_v2(100000000000003l, 13,"M1",0.25,"V7",15,1000, 4,3, 2);
        det[4] = new Rugs_v2(100000000000004l, 12,"M4",0.11,"V4",3,150, false);
        det[5] = new Lever_v2(100000000000005l, 10,"M3",0.12,"V4",14,700, 150,0.8);


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
        Detail_v2 detNew = new Rugs_v2(100000000000010l, 8,"M8",0.18,"V8",8,200, false);
        assertTrue(stock.addSparePart(detNew));
        //check size
        System.out.println(stock.quantityOfSpareParts());
        stock.printSparePart();
        // try to add when no free space in storage
        Detail_v2 detNew2 = new Rugs_v2(100000000000015l, 8,"M8",0.18,"V8",8,200, false);
        assertFalse(stock.addSparePart(detNew2));
    }//end addSparePartTest

    @Test
    void findSparePartTest() {
        Detail_v2 foundedSparePart = stock.findSparePart(100000000000000l);
        assertEquals(det[0], foundedSparePart);

    }//end findSparePartTest

    @Test
    void findSparePartByVendorTest() {
        Detail_v2[] exp = {det[4], det[5]};
        Detail_v2[] act = stock.findSparePartByVendor("V4");
        assertArrayEquals(exp,act);
    }//end findSparePartByVendorTest

    @Test
    void findSparePartByMaterialTest() {
        Detail_v2[] exp = {det[0], det[3]};
        Detail_v2[] act = stock.findSparePartByMaterial("M1");
        assertArrayEquals(exp,act);
    }//end findSparePartByMaterialTest

    @Test
    void findSparePartWithDiscountTest() {
        Detail_v2[] exp = {det[1], det[5]};
        Detail_v2[] act = stock.findSparePartWithDiscount();
        assertArrayEquals(exp,act);
    }//end findSparePartWithDiscountTest

    @Test
    void findSparePartWithDiscountLowerThanTest() {
        Detail_v2[] exp = {det[5]};
        Detail_v2[] act = stock.findSparePartWithDiscountLowerThan(0.85);
        assertArrayEquals(exp,act);
    }//end findSparePartWithDiscountLowerThanTest

    @Test
    void findSetSparePartTest() {
        Detail_v2[] exp = {det[0], det[3]};
        Detail_v2[] act = stock.findSetSparePart();
        assertArrayEquals(exp,act);
    }//end findSetSparePartTest

    @Test
    void findCheapestSparePartTest() {
        assertEquals(det[4], stock.findCheapestSparePart());
    }//end findCheapestSparePartTest

    //делаю допущение - на заводе поставщика прошла перестандартизация.
    // Деталь Gear c баркодом 100000000000000l, получила новый tooth -> 3 и новый weight -> 0.18. (old tooth = 2; old weight = 0.15;)
    //det[0] = new Gear_v2(100000000000000l, 10,"M1",0.15,"V1",7.5,200, 6.5,2, 3) деталь для замены из конструктора в классе Test
    // Остальные параметры, включая баркод не изменились.
    // Поставщику вернули все Gear старого образца, и он бесплатно поменял их на новые Detail_v2 detail.
    @Test
    void updateSparePartTest() {
        stock.printSparePart();
         // запчасти под замену нет на складе
        Detail_v2 newGear = new Gear_v2(100001111111111l, 10,"M1",0.18,"V1",7.5,200, 6.5,3, 3);
        assertFalse(stock.updateSparePart(newGear));
        //апдейт запчасти
        newGear = new Gear_v2(100000000000000l, 10,"M1",0.18,"V1",7.5,200, 6.5,3, 3);
        assertTrue(stock.updateSparePart(newGear));
        System.out.println("------------after change------------");
        stock.printSparePart();

    }//end updateSparePartTest

    @Test
    void removeSparePartTest() {
        //remove absent spare part
        Detail_v2 detNew = new Rugs_v2(100000000000010l, 8,"M8",0.18,"V8",8,200, false);
        assertNull(stock.removeSparePart(100000000000010l));

        //remove spare part
        assertEquals(det[0], stock.removeSparePart(100000000000000l));
        stock.printSparePart();

        //size
        assertEquals(5, stock.quantityOfSpareParts());
    }//end removeSparePartTest

    @Test
    void totalWeightInStorageTest() {
        assertEquals(470.5, stock.totalWeightInStorage());
    }//end totalWeightInStorageTest

    @Test
    void averageWeightSparePartInStorageTest() {
        assertEquals(0.177547169811320754, stock.averageWeightSparePartInStorage());
    }//end averageWeightSparePartInStorageTest()

    @Test
    void quantityOfSparePartsTest() {
        assertEquals(6,stock.quantityOfSpareParts());
    }

    @Test
    void printSparePartTest() {
        stock.printSparePart();
    }//end printSparePartTest

    @Test
    void quantityOfPiecesOfSparePartsTest (){
        assertEquals(2650, stock.quantityOfPiecesOfSpareParts());
    }//end quantityOfPiecesOfSparePartsTest

}//end class