package HW18.product_v2.dao_v2;

import HW18.product_v2.model_v2.Product_v2;

public interface Supermarket {

    boolean addProduct(Product_v2 product);

    Product_v2 removeProduct(long barCode);

    Product_v2 findProductByBarCode(long barCode);

    Product_v2[] findProductsByExpireDate (String expDate);

   Product_v2[] findProductsByPrice (double price);

   Product_v2[] findProductsByQuantityInStorageLessThan (int quantity);

    double totalPriceOfAllProducts();

    double averagePriceOfProducts();

    void printProducts();

    int size ();

}//end interface
