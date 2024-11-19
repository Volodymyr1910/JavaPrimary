package HW24;


public class Massive83 {
    //Задача 1
//Задан массив целых чисел: 65, 37, 51, -17, 73, -41, 52, 56, -55, 83. Найдите максимальный элемент массива и его индекс.
// (max = 83, indexMax = 9) Поставьте этот элемент в начало массива вместо имеющегося. (number[0] = number[indexMax])
//
    public static void main(String[] args) {

        int[] massive83 = {65, 37, 51, -17, 73, -41, 52, 56, -55, 83};

        int max = massive83[0];
        int indexofMax = 0;

        for (int s = 0; s < massive83.length; s++) {
            if (massive83[s] > max) {
                max = massive83[s];
                indexofMax = s;
            }//end if
            System.out.print(massive83[s] + " ");
        }//end for
        System.out.println();
        System.out.println("Max element of massive83 is " + max + ", his index is - " + indexofMax + ".");
        System.out.println("First element of massive83 is " + massive83[0] + ".");

        //Put the max element to the zero-position
        massive83[0] = max;
        for (int s = 0; s < massive83.length; s++) {
            System.out.print(massive83[s] + " ");
        }//end for
        System.out.println();
        System.out.println("New First element of massive83 is " + massive83[0] + ", his index is - " + indexofMax + ".");


    }//end main
}//tnd class
