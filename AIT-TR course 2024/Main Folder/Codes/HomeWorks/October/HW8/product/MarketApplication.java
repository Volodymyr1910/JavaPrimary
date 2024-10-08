package HW8.product;

import HW8.product.model.Food;
import HW8.product.model.MeatFood;
import HW8.product.model.MilkFood;
import HW8.product.model.Product;

import javax.lang.model.type.NullType;
import java.util.Scanner;

public class MarketApplication {

    public static void main(String[] args) {

        Product product1 = new Product(30,"Sigarets", 554678l);
        Food product2 = new Food(7,"Pinapple",565789l,"20.10.2024");
        MeatFood product3 = new MeatFood(16.5,"Neck",576890l,"22.10.2024","Pork");
        MilkFood product4 = new MilkFood(8,"Bottle of Milk",587901l,"13.10.2024","Cow",3.2);

        //print
        Product marketList [] = new Product[4];
        marketList [0] = product1;
        marketList [1] = product2;
        marketList [2] = product3;
        marketList [3] = product4;
        for (int i = 0; i < marketList.length; i++) {
            System.out.println(marketList[i]);
        }//end for

        //total price
        double totalPrice = 0;
        for (int i = 0; i < marketList.length; i++) {
            totalPrice += marketList[i].getPrice();
        }//end for
        System.out.println("-------------------Total cost--------------");
        System.out.println("The total cost of all positions is -> " + totalPrice + ".");

        System.out.println("-------------------Perform a comparison--------------");
        System.out.println("Product and product2 are the same -> " + marketList[0].equals(marketList[1]));

        //looking for the product by barcode
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a barcode, please: ");
        long barCode = scanner.nextLong();
        boolean checker = false;
        for (int i = 0; i < marketList.length; i++) {
            if (barCode == (marketList[i].getBarCode())){
                System.out.println("Under your barcode is registered -> " + marketList[i]);
                checker = true;
            }//end if
        }//end for
        if (checker == false) {
            System.out.println("No products with selected barcode.");
        }//end if

        //looking for the product by expiration date
        scanner.nextLine();
        System.out.println("Input an expiration date, please: ");
        String expDate = scanner.nextLine();
        boolean checker2 = false;
        for (int i = 0; i < marketList.length; i++) {
            if(marketList[i] instanceof Food) {
                if(((Food) marketList[i]).getExpDate().equals(expDate)){
                    System.out.println("The folowing products has " + expDate + " experation date -> " + marketList[i]);
                    checker2 = true;
                }//end if
            }//end if
        }//end for
        if (checker2 == false) {
            System.out.println("No products with selected expiration date.");
        }//end if

        //loocking for not food products
        for (int i = 0; i < marketList.length; i++) {
            if (!(marketList[i] instanceof Food)){
                System.out.println("We have next no food products -> " + marketList[i]);
            }//end if
        }//end for


    }//end main
}//end class
