package HW31;

import MyMethods.array_methods.ArrayMethods;

import java.util.Arrays;

//Задача 1. Дополните метод bubbleSort() счетчиком, который позволяет узнать, сколько операций было выполнено по ходу сортировки. Выполните сортировку элементов массивов, в которых содержатся 10, 100 и 1000 элементов. Массивы заполните случайными целыми числами в интервале от 0 до 1000. Как растет количество операций при сортировке при росте количества элементов массива?
public class BubleSortProductCapacity {
    public static void main(String[] args) {

        int array1 [] = ArrayMethods.fillArrayRandom(0,1000,10);
        int stepCount1 = bubleSortFromLowToBigCount(array1);
        int array2 [] = ArrayMethods.fillArrayRandom(0,1000,100);
        int stepCount2 = bubleSortFromLowToBigCount(array2);
        System.out.println("Сортировка массива длиной " + array2.length + " -> " + stepCount2 + " итераций; Сортировка массива длиной " + array1.length + " -> " + stepCount1 + " итераций; т.е. ко-во итераций в " + stepCount2 / stepCount1 + " раз больше, или больше на " + (stepCount2 * 100 / stepCount1 - 100) + " %.");

       array1 = ArrayMethods.fillArrayRandom(0,1000,100);
        stepCount1 = bubleSortFromLowToBigCount(array1);
        array2 = ArrayMethods.fillArrayRandom(0,1000,1000);
        stepCount2 = bubleSortFromLowToBigCount(array2);
        System.out.println("Сортировка массива длиной " + array2.length + " -> " + stepCount2 + " итераций; Сортировка массива длиной " + array1.length + " -> " + stepCount1 + " итераций; т.е. ко-во итераций в " + stepCount2 / stepCount1 + " раз больше, или больше на " + (stepCount2 * 100 / stepCount1 - 100) + " %.");


        array1 = ArrayMethods.fillArrayRandom(0,1000,10);
        stepCount1 = bubleSortFromLowToBigCount(array1);
        array2 = ArrayMethods.fillArrayRandom(0,1000,1000);
        stepCount2 = bubleSortFromLowToBigCount(array2);
        System.out.println("Сортировка массива длиной " + array2.length + " -> " + stepCount2 + " итераций; Сортировка массива длиной " + array1.length + " -> " + stepCount1 + " итераций; т.е. ко-во итераций в " + stepCount2 / stepCount1 + " раз больше, или больше на " + (stepCount2 * 100 / stepCount1 - 100) + " %.");
    }//end main

    public static int bubleSortFromLowToBigCount (int[] array) {
        int stepCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++, stepCount++) {
                if (array[j] > array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
        return stepCount;
    }//end bubleSortFromLowToBig

}//end class
