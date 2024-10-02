package HW24;


import java.util.Scanner;

//Задача 4. Задайте массив из 10 случайных натуральных чисел в интервале от 1 до 100.
// Запросите у пользователя какое-то натуральное число. Определите, есть ли это число в массиве.
// Создайте и используйте метод searchInArray, который получает на вход массив и искомое число, а возвращает ответ - нашлось ли это число в массиве.
public class SearchInArray {
    public static void main(String[] args) {
     int [] accident = new int [10];
        int n = 0;
        for (int i = 0; i < accident.length; i++) {
            accident[i] = (int) (Math.random() * (100 - 1 + 1) + 1);
            System.out.print(accident[i]);
            n++;
            if (n< accident.length){
                System.out.print(", ");
            }//end if
        }//end for
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input natural number, please: ");
        int s = scanner.nextInt();
        
        boolean res = searchInArray (accident, s);
        System.out.println("Number " + s + " is in array. That's " + res +".");

    }//end main

    private static boolean searchInArray(int[] accident, int s) {
        for (int i = 0; i < accident.length; i++) {
            if(s == accident[i]){
                return true;
            }//end if
        }
        return false;
    }//end searchInArray

}//end class
