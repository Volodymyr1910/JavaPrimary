package HW11;
//Задача 2. Создайте массив из 100 случайных целых чисел в интервале от -10 до 10. Подсчитайте, сколько в этом массиве оказалось:
//
//положительных чисел;
//отрицательных чисел;
//четных чисел;
//нулей.

import array_methods.ArrayMethods;

public class Array100Elements {

    public static void main(String[] args) {

        int array [] = ArrayMethods.fillArrayRandom(-10,10,100);

        int countOfPositive = 0;
        int countOfNegative = 0;
        int countOfEven = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0){
                countOfPositive++;
            }//end if
            if(array[i] < 0){
                countOfNegative++;
            }//end if
            if(array[i] % 2 ==  0){
                countOfEven++;
            }//end if
        }//end for
        int countOfZero = array.length - countOfPositive - countOfNegative;

        System.out.println("Quantity of positive numbers -> " + countOfPositive + ".");
        System.out.println("Quantity of negative numbers -> " + countOfNegative + ".");
        System.out.println("Quantity of even numbers -> " + countOfEven + ".");
        System.out.println("Quantity of zero -> " + countOfZero + ".");




    }//end main
}//end class
