package Day20;

import java.util.Scanner;

//Доработать калькулятор так, чтобы он продолжал работать после выполнения одного действия с парой чисел.
public class Calculator {

    static int num1, num2, result, action;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //start must be hier
        boolean flag = true;

        while (flag) {

            //System.out.println("For using calculator press 1, for exit press 2:");
            System.out.println("Continue? y/n:");
            char ch = scanner.next().charAt(0);
            if (ch == 'y') {


                System.out.println("Input first number, please: ");
                num1 = scanner.nextInt();
                System.out.println("Input second number,  please: ");
                num2 = scanner.nextInt();
                System.out.println("Choose action,  please:");
                System.out.println("1 -> '+'");
                System.out.println("2 -> '-'");
                System.out.println("3 -> '*'");
                System.out.println("4 -> '/'");
                System.out.println("5 -> '%'");
                System.out.println("0 -> 'exit'");
                System.out.println("Input action, please:");
                action = scanner.nextInt();

                switch (action) {
                    case 1 -> result = sum(num1, num2);
                    case 2 -> result = deduct(num1, num2);
                    case 3 -> result = multiplay(num1, num2);
                    case 4 -> result = division(num1, num2);
                    case 5 -> result = restOfDivision(num1, num2);
                    case 0 -> flag = false;
                    default -> System.out.println("Wrong input!");
                }//end switch action

                System.out.println("Result = " + result);
            } else {
                flag = false;
            }//end if ch
            //start again
        }
    }//end main

    private static int sum(int num1, int num2) {
        return num1 + num2;

    }//end of sum

    private static int deduct(int num1, int num2) {
        return num1 - num2;

    }//end of deduct

    private static int multiplay(int num1, int num2) {
        return num1 * num2;

    }//end of multiplay

    private static int division(int num1, int num2) {
        return num1 / num2;

    }//end of division

    private static int restOfDivision(int num1, int num2) {
        return num1 % num2;

    }//end of restOfDivision

}// end class
