package HW9;
//Задание 1. Напишите программу, которая запрашивает у пользователя строку, содержащую целые числа, и выводит сумму всех этих введенных чисел.
// Используйте классы-обёртки для преобразования строк в соответствующие примитивы.
//

import MyMethods.string_methods.StringMethods;
import array_methods.ArrayMethods;
import array_methods.ArrayMethods_String;

import java.util.Scanner;

public class DigitsInSentence {
    public static void main(String[] args) {

        //receive string with numbers from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string of numbers, separated by spaces, please: ");
        String userSentence = scanner.nextLine();

        // making array
        String array [] = userSentence.split(" ");

        //casting
        int [] digitArray = StringMethods.copyArrayWithChangeStringToIntAutoSize(array);

        //finding total

        int sum = ArrayMethods.sumArray(digitArray);
        System.out.println("Total of your entered numbers is -> " + sum + ".");
    }//end main







}//end class
