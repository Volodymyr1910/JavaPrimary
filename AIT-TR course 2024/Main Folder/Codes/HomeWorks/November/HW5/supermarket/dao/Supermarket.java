package HW5.supermarket.dao;

import HW5.supermarket.model.Product;

public interface Supermarket extends Iterable <Product>{

    boolean addProduct (Product product);
    Product removeProduct (long barCode);
    Product findByBarCode (long barCode);
    Iterable<Product> findByCftegory (String category);
    Iterable<Product> findByBrand (String brand);
    Iterable<Product> findProductsWithExpiredDate (String category);
    int skuQuantity ();


}//end
