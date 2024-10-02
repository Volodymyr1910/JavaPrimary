package HW27;


import array_methods.ArrayMethods;

import java.util.Random;

//На повторение: Задача 1. Найти произведение всех двузначных нечетных чисел кратных 17.

public class Seventeen {
    public static void main(String[] args) {
        Random random = new Random();

        // вызвал метод который создает массивы с кратными числами, размер массива определяется автоматически
        int q [] = ArrayMethods.fillGrowingArrayFromAtoBAutoSize(17,99);
        ArrayMethods.printArray(q);
        int multiplication17 = q[0];

        for (int i = 1; i < q.length; i++) {
                multiplication17 = multiplication17 * q[i];
        }//end for
        System.out.println("Multiplication of all two-digit odd numbers even 17 is -> " + multiplication17 + ".");
    }//end main
}//end class
