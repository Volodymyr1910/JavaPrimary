package Day6.ait.supermarket_arraylist.dao;

import Day6.ait.supermarket_arraylist.model.Product;

import java.util.function.Predicate;

public interface Supermarket extends Iterable <Product>{

    boolean addProduct(Product product);

    Product removeProduct(long barCode);

    Product findByBarCode(long barCode);

    Iterable<Product> findByCategory(String category);

    Iterable<Product> findByBrand(String brand);

    Iterable<Product> findProductWithExpiredDate();

    int skuQuantity();


}//end interface
