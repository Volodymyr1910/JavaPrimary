package HW6.supermarket_linkedList.dao;

import HW6.supermarket_linkedList.model.Product;

public interface Supermarket extends Iterable <Product>{

    boolean addProduct(Product product);

    Product removeProduct(long barCode);

    Product findByBarCode(long barCode);

    Iterable<Product> findByCategory(String category);

    Iterable<Product> findByBrand(String brand);

    Iterable<Product> findProductWithExpiredDate();

    int skuQuantity();


}//end interface
