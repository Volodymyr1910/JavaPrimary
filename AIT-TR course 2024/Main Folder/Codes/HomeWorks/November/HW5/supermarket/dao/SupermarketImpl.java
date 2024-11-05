package HW5.supermarket.dao;

import HW5.supermarket.model.Product;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class SupermarketImpl implements Supermarket{

    private Set<Product> products;






    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public Product removeProduct(long barCode) {
        return null;
    }

    @Override
    public Product findByBarCode(long barCode) {
        return null;
    }

    @Override
    public Iterable<Product> findByCftegory(String category) {
        return null;
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return null;
    }

    @Override
    public Iterable<Product> findProductsWithExpiredDate(String category) {
        return null;
    }

    @Override
    public int skuQuantity() {
        return 0;
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }



}//end class
