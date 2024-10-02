package Day18;

import java.util.Scanner;

//Пользователь вводит натуральное число (целое, положительное).
//Выясните, сколько цифр в числе 254 789.
public class Digits {
    public static void main(String[] args) {
        //5 467
        ///--------
        //5 467 % 10 = 7 - cамая крайняя правая цифра
        //5467 / 10 = 546
        //деление на 10 продолжаем в цикле пока результат > 0

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter positive integer number, please: ");
        int number = scanner.nextInt();
        int number1 = number;

        int count = 0;

        while (number > 0){ //number это параметр цикла
            number = number / 10;
            count ++;

        }//end while
        System.out.println("We have " + count + " digits in our number: " + number1);
        System.out.println("Finish !");

    }//end main


}//end class
