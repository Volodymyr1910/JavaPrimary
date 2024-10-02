package Day17;

import java.util.Scanner;

//Рассчитайте величину скидки и стоимость покупки с учетом скидки по следующим правилам:
//- сумма покупки до 100 евро - скидка 0%
//- сумма покупки от 101 евро до 200 евро - скидка 2%
//- сумма покупки от 201 евро до 500 евро - скидка 5%
//- сумма покупки от 501 евро до 1000 евро - скидка 10%
//- сумма покупки от более 1000 евро - скидка 20%
//Сумма покупки вводится с клавиатуры.
public class Discount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of the purchase, please: ");
        double amount = scanner.nextDouble();
        double discount = 0;

        if (amount > 0 && amount <= 100){
            discount = 0;
        } else if (amount > 101 && amount <= 200) {
            discount = 0.02;
        } else if (amount > 201 && amount <= 500) {
            discount = 0.05;
        } else if (amount > 501 && amount <= 1000) {
            discount = 0.1;
        } else if (amount > 1000) {
            discount = 0.2;
        }
        System.out.println("Discount is " + discount + ".");
    }//end of main

}//end of class
