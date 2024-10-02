package HW23;
//Задан массив целых чисел: 56, 73, 15, -10, 37, -14, 25, 65, 33, 38. Найдите максимальный элемент массива и его индекс.

import java.util.Arrays;

public class MaxAndIndex {
    static int indexOfMax =0;

    public static void main(String[] args) {
        int [] newNumber = {56, 73, 15, -10, 37, 85, -14, 25, 65, 33, 38};
        int max = newNumber[0];

        for (int i = 0; i < newNumber.length; i++) {
            if(newNumber[i]>max){
                max = newNumber[i];
                indexOfMax = i;
            }//end if

        }//end for
        System.out.println(max + " is max element. His index is " + indexOfMax);
    }//end main
}//end class
