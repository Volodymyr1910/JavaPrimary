package HW27;

import java.util.Scanner;

//Задача 2. В сберкассу на трёхпроцентный вклад положили s рублей. Какой станет сумма вклада через n лет. Использовать цикл for.
public class RepeatTaskBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of your deposit, please: (for example: 100 or 200,50)");
        double amount = scanner.nextDouble();
        while (amount <= 0) {
            System.out.println("Wrong input. Enter the amount of your deposit again, please:  ");
            amount = scanner.nextDouble();
        }//end while
        System.out.println("Enter please, for how many full years do you want to place a deposit: ");
        int n = scanner.nextInt();
        while (n <= 0) {
            System.out.println("Wrong input. Please choose another therm: ");
            n = scanner.nextInt();
        }//end while
        double newAmount = 0;
        for (int i = 0; i < n; i++) {
            if (newAmount == 0) {
                newAmount = amount;
            }
            newAmount = newAmount + (newAmount * 0.03);
        }//end for
        System.out.printf("-> %.2f", newAmount);
        System.out.println(" <- Euro will wait for you, after " + n + " years. Great!");
    }//end main
}//end class
