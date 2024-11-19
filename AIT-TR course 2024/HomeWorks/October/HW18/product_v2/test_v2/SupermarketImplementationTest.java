package HW18.product_v2.test_v2;

import HW18.product_v2.controller_v2.SupermarketImplementation;
import HW18.product_v2.model_v2.MeatFood_v2;
import HW18.product_v2.model_v2.MilkFood_v2;
import HW18.product_v2.model_v2.Product_v2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketImplementationTest {
SupermarketImplementation supermarketImplementation;
Product_v2 [] prod;

    @BeforeEach
    void setUp() {
        supermarketImplementation = new SupermarketImplementation(6);
        prod = new Product_v2[5];

        prod[0] = new MilkFood_v2(2.05,"N1", 100000,70, "2024.Dec.22", "Cow", 3.6);
        prod[1] = new MeatFood_v2(4,"N2", 100001,100, "2024.Nov.10", "Pig");
        prod[2] = new MilkFood_v2(1.6,"N3", 100002,20, "2024.Dec.22", "Cow", 1.5);
        prod[3] = new MeatFood_v2(7.5,"N4", 100003,90, "2024.Dec.31", "Cow");
        prod[4] = new MilkFood_v2(2.5,"N5", 100004,15, "2024.Oct.31", "Goat", 2.8);


        for (int i = 0; i < 5; i++) {
        supermarketImplementation.addProduct(prod[i]);
        }//end fori
    }//end setUp

    @Test
    void addPriductTest() {

        assertFalse(supermarketImplementation.addProduct(null));
        assertFalse(supermarketImplementation.addProduct(prod[0]));


        Product_v2 prodNew = new MeatFood_v2(5,"N6", 100006,40, "2024.Dec.26", "Ram");
        assertTrue(supermarketImplementation.addProduct(prodNew));
        System.out.println(supermarketImplementation.size());
        supermarketImplementation.printProducts();

        // try to add when no free space in storage
        Product_v2 prodNew2 = new MeatFood_v2(5,"N6", 100007,40, "2024.Dec.26", "Ram");
        assertFalse(supermarketImplementation.addProduct(prodNew2));

    }//end addPriductTest

    @Test
    void removeProductTest() {

        //remove absent
        assertNull(supermarketImplementation.removeProduct(100000000000010l));

        //remove product
        assertEquals(prod[0], supermarketImplementation.removeProduct(100000));
       supermarketImplementation.printProducts();

        //size
        assertEquals(4, supermarketImplementation.size());
    }//end removeProductTest

    @Test
    void findProductByBarCodeTest() {
        Product_v2 foundedProduct = supermarketImplementation.findProductByBarCode(100002);
        assertEquals(prod[2], foundedProduct);
    }//end findProductByBarCodeTest

    @Test
    void findProductsByExpireDateTest() {
        Product_v2 product [] = {prod [1]};
        assertArrayEquals(product, supermarketImplementation.findProductsByExpireDate("2024.Nov.10"));
    }//end findProductsByExpireDateTest

    @Test
    void findProductsByPriceTest() {
        Product_v2 product [] = {prod [3]};
        assertArrayEquals(product, supermarketImplementation.findProductsByPrice(7.5));
    }//end findProductsByPriceTest

    @Test
    void findProductsByQuantityInStorageLessThanTest() {
        Product_v2 product [] = {prod [0],prod [2],prod [4]};
        assertArrayEquals(product, supermarketImplementation.findProductsByQuantityInStorageLessThan(70));
    }//end findProductsByQuantityInStorageLessThanTest

    @Test
    void totalPriceOfAllProductsTest() {
        assertEquals(1288, supermarketImplementation.totalPriceOfAllProducts());
    }//end totalPriceOfAllProductsTest

    @Test
    void averagePriceOfProductsTest() {
        assertEquals(4.366101694915254237, supermarketImplementation.averagePriceOfProducts());
    }//end averagePriceOfProductsTest

    @Test
    void printProductsTest() {
        supermarketImplementation.printProducts();
    }//end printProductsTest

    @Test
    void sizeTest() {
        assertEquals(5, supermarketImplementation.size());
    }//end sizeTest

}//end class