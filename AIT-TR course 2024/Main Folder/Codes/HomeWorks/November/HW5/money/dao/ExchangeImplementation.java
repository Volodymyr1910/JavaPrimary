package HW5.money.dao;

import HW5.money.model.Money;

import java.util.Scanner;

public class ExchangeImplementation implements Exchange {

    Scanner scanner = new Scanner(System.in);
    Money money;

    public ExchangeImplementation(Money money) {
        this.money = money;
    }

    @Override
    public void mainMenu() {

        System.out.println("Hi, Friend !");
        int actionNum = 0;

        do {
            System.out.println("Choose a currency to exchange to EUROs: " + Money.USD.getCode() + " -> " + Money.USD.getNumber() + "; " + Money.UAH.getCode() + " -> " + Money.UAH.getNumber() + "; " + Money.CNY.getCode() + " -> " + Money.CNY.getNumber() + "; " + Money.INR.getCode() + " -> " + Money.INR.getNumber() + "; " + Money.MXN.getCode() + " -> " + Money.MXN.getNumber() + ". Press 6 for Exit.");

            actionNum = scanner.nextInt();
            if (actionNum == 6){
                System.out.println("See you later ! Bye.");
                break;
            }//end if

        } while ( actionNum < 1 | actionNum > 5 );

        if  (actionNum !=6 ) {
            for (Money choise : Money.values()) {
                if (choise.getNumber() == actionNum) {
                    int n = quantity();
                    double res = calc(choise.getRatioWithEuro(), n);
                    //System.out.println(n + " " + choise.getCode() + " = " + res + " EUR");
                    System.out.print(n + " " + choise.getCode());
                    System.out.printf(" = %.2f", res);
                    System.out.print(" EUR");
                    System.out.println();
                    break;
                }//end if
            }//end for
        }//end if

    }//end mainMenu

    @Override
    public double calc(double ratio, int n) {
        return n * ratio;
    }//end calc

    @Override
    public int quantity() {
        int quantity = 0;
        do {
            System.out.println("Enter quantity, please: ");
            quantity = scanner.nextInt();
        } while (quantity <= 0);
        return quantity;
    }//end quantity
}//end class
