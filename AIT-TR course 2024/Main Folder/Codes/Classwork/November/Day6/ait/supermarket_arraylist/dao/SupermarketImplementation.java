package Day6.ait.supermarket_arraylist.dao;

import Day6.ait.supermarket_arraylist.model.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class SupermarketImplementation implements Supermarket{

    private Collection <Product> products = new ArrayList<>();

    @Override
    public boolean addProduct(Product product) {
        if(product == null || products.contains(product))return false;
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
        List<Product> res = new ArrayList<>();
        for (Product p : products) {
            if(predicate.test(p)){
                res.add(p);
            }//end if
        }//end for
        return  res;
    }//end findByPredicate


}//end class
