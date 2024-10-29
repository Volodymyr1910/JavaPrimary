package MyMethods.enum_variants.cofee_mashine;

import java.util.Scanner;

public class CofeeApplication {
    public static void main(String[] args) {
        boolean flag = true;
        System.out.println("Welcome to Cofee Shop !");
        Scanner scanner = new Scanner(System.in);

        //start of loop
        while (flag == true) {


            System.out.println("What kind of cofee do you want? Press 1 for Espresso, 2 for Americano,3 for Capuccino,4 for Latte, 5 for Exit");
            int choise = scanner.nextInt();
            Cofee[] cofees = Cofee.values();

            switch (choise) {
                case 1, 2, 3, 4  -> {
                    System.out.println("Your choise is:" + cofees[choise - 1].getTitle());
                    System.out.println("Please make payment: " + cofees[choise - 1].getPrice());
                }
                case 5 -> {
                    flag = false;
                    System.out.println("Bye !");
                }
                default -> System.out.println("Wrong choise !");
            }//end choise
        }//end while


    }//end main

}//end class
