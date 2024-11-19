package HW6.supermarket_linkedList;

import HW6.supermarket_linkedList.dao.SupermarketImplementation;
import HW6.supermarket_linkedList.model.Product;

import java.time.LocalDate;

public class SupermarketApplication {

    public static void main(String[] args) {


        LocalDate now = LocalDate.now();

        SupermarketImplementation myMarket = new SupermarketImplementation();

        Product products [] = new Product[5];

        products[0] = new Product(111111, "White Bread", "Bread", "Kolosok", 6.5, now.plusDays(5));
        products[1] = new Product(222222, "ChocoMilk", "Dairy", "MilkLand", 13, now.minusDays(3));
        products[2] = new Product(333333, "Cheese Gouda", "Dairy", "Farmer", 22.5, now.plusDays(50));
        products[3] = new Product(444444, "Cheese Chedder", "Dairy", "MilkLand", 30, now.plusDays(85));
        products[4] = new Product(555555, "Sweet Beans", "Bread", "Kolosok", 18.3, now.minusDays(25));

        for (Product p : products) {
            myMarket.addProduct(p);
        }//end for

        // menu with options : 1 - storage, 2 - products with expired data, 3 - products by category, 4 - products by brand,

        System.out.println("Products by category :");
        Iterable <Product> res = myMarket.findByCategory("bread");
        System.out.println(res);



    }//end main

}//end class
