package HW5.supermarket;

import HW5.supermarket.model.Product;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SupermarketApplication {

    public static void main(String[] args) {

        Product product1 = new Product(100001l,"Yogurt", "Milk products", "Our", 1.25, LocalDate.of(2024,11,12));
        Product product2 = new Product(100002l,"Chicken Heart", "Meat products", "Ohayo farm", 2.30, LocalDate.of(2024,11,03));
        Product product3 = new Product(100003l,"Light", "Cigarettes", "Chester Field", 6.5, LocalDate.of(2025,10,31));
        Product product4 = new Product(100004l,"Honey with pepper", "Alcohol", "Nemiroff", 8, LocalDate.of(2024,10,25));

        Set <Product> supermarket = new HashSet<>(Set.of(product1, product2, product3, product4));

        System.out.println("List of all products:");
        for (Product p : supermarket) {
            System.out.println(p);
        }//end

        System.out.println();
        System.out.println("List of all products with expired date:");
        for (Product p : supermarket) {
            if(p.getExpDate().isBefore(LocalDate.now()))
            System.out.println(p);
        }//end


    }//end main



}//end class
