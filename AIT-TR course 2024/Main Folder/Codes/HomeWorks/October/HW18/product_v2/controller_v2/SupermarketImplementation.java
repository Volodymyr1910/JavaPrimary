package HW18.product_v2.controller_v2;

import HW18.details_trade_v2.details_v2.model_v2.Detail_v2;
import HW18.product_v2.dao_v2.Supermarket;
import HW18.product_v2.model_v2.Food_v2;
import HW18.product_v2.model_v2.Product_v2;

import java.util.function.Predicate;

public class SupermarketImplementation implements Supermarket {
    private Product_v2[] products;
    private int size;


    public SupermarketImplementation(int capasity) {
        this.products = new Product_v2[capasity];
        this.size = size;
    }

    @Override
    public boolean addProduct(Product_v2 product) {
        if (product == null) return false;
        if (size == products.length) return false;
        if (findProductByBarCode(product.getBarCode()) != null) return false;
        products[size++] = product;
        return true;
    }//addPriduct

    @Override
    public Product_v2 removeProduct(long barCode) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarCode() == barCode) {
                Product_v2 victim = products[i];
                products[i] = products[size - 1];
                size--;
                return victim;
            }//end if
        }//end fori
        return null;
    }//end removeProduct

    @Override
    public Product_v2 findProductByBarCode(long barCode) {
        for (int i = 0; i < size; i++) {
            if (products[i].getBarCode() == barCode) return products[i];
        }//end
        return null;
    }//end findProductByBarCode

    @Override
    public Product_v2[] findProductsByExpireDate(String expDate) {
       int count = 0;
        for (int i = 0; i < size; i++) {
            if(products[i] instanceof Food_v2){
                if (((Food_v2) products[i]).getExpDate() == expDate)count++;
            }//end if
        }//end for
        Product_v2 array [] = new Product_v2[count];
        for (int i = 0, j = 0; j < array.length; i++) {
            if(products[i] instanceof Food_v2){
                if (((Food_v2) products[i]).getExpDate() == expDate){
                    array [j++] = products[i];
                }//end if
            }//end if
        }//end for
        return array;
    }//end findProductsByExpireDate

    @Override
    public Product_v2[] findProductsByPrice(double price) {
        return findByPredicate(products -> products.getPrice() == price);
    }//end findProductsByPrice

    @Override
    public Product_v2[] findProductsByQuantityInStorageLessThan(int quantity) {
        return findByPredicate(products -> products.getQuantityInStorage() <= quantity);
    }//end findProductsByQuantityInStorageLessThan

    @Override
    public double totalPriceOfAllProducts() {
        double totalPrice = 0;
        for (int i = 0; i < size; i++) {
            totalPrice += products[i].getPrice() * products[i].getQuantityInStorage();
        }//end for
        return totalPrice;
    }//end totalPriceOfAllProducts

    @Override
    public double averagePriceOfProducts() {
        int totalQuantity = 0;
        for (int i = 0; i < size; i++) {
            totalQuantity += products[i].getQuantityInStorage();
        }//end for
        return totalPriceOfAllProducts() / totalQuantity;
    }//end averagePriceOfProducts

    @Override
    public void printProducts() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }//end for
    }//end printProducts

    @Override
    public int size() {
        return size;
    }//end size

    private Product_v2 [] findByPredicate (Predicate <Product_v2> pred){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(pred.test(products[i]))count++;
        }//end for
        Product_v2 [] array = new Product_v2 [count];
        for (int i = 0, j = 0; j < array.length; i++) {
            if(pred.test(products[i])){
                array [j++] = products [i];
            }//end if
        }//end for
        return  array;
    }//end findBaPredicate




}//end class
