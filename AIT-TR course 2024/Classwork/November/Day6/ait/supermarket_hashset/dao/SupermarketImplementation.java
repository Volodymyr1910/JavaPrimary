package Day6.ait.supermarket_hashset.dao;

import Day6.ait.supermarket_hashset.model.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class SupermarketImplementation implements Supermarket {

    private Collection <Product> products = new HashSet<>(); // hier first change 1/3

    @Override
    public boolean addProduct(Product product) {
        if(product == null)return false; // hier second change 2/3
        return  products.add(product);
    }//end addProduct

    @Override
    public Product removeProduct(long barCode) {
        Product product = findByBarCode(barCode);
        products.remove(product);
        return product;
    }

    @Override
    public Product findByBarCode(long barCode) {
        for (Product p : products) {
            if(p.getBarCode() == barCode) return p;
        }
        return null;
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        return findByPredicate(product -> product.getCategory().equalsIgnoreCase(category));
    }//end findByCategory

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return findByPredicate(product -> product.getBrand().equalsIgnoreCase(brand));
    }//end findByBrand



    @Override
    public Iterable<Product> findProductWithExpiredDate() {
        return findByPredicate(product -> product.getExpDate().isBefore(LocalDate.now()));
    }//end findProductWithExpiredDate

    @Override
    public int skuQuantity() {
        return products.size();
    }//end skuQuantity

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }//end iterator

    private Iterable <Product> findByPredicate (Predicate <Product> predicate){
        HashSet<Product> res = new HashSet<>(); // hier third change 3/3
        for (Product p : products) {
            if(predicate.test(p)){
                res.add(p);
            }//end if
        }//end for
        return  res;
    }//end findByPredicate


}//end class
