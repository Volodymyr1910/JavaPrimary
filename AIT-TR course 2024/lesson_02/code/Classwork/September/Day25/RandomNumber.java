package Day25;


import java.util.Random;
import java.util.Scanner;

//Задайте массив из 10 случайных натуральных чисел в интервале от 1 до 100.
//Запросите у пользователя какое-то натуральное число.
//Определите, есть ли это число в массиве.
//Создайте и используйте метод searchInArray, который получает на вход массив и искомое число, а возвращает
//ответ - нашлось ли это число в массиве.
public class RandomNumber {
    public static void main(String[] args) {

        int [] numbers = new int[10];
        Random random = new Random();

        // fill in numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100)+1;

        }//end for
        // print array for kontrol
        printArray(numbers);

        //receive iformation from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input positive integer number: ");
        int n = scanner.nextInt();

        //Определите, есть ли это число в массиве.
        boolean isInArray = searchInArray(numbers, n );
        System.out.println("Number " + n + " is in array: " + isInArray + ".");


    }//end main

    private static boolean searchInArray(int[] numbers, int n) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n){
                return true;
            }//end if
        }//end for
       return false;
    }//end searchInArray

    private static void printArray (int [] numbers){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }//end for
        System.out.println();
        System.out.println("-----------------------------");

    }//end printArray

}//end class
