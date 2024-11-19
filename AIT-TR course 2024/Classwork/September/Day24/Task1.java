package Day24;
//Задан массив целых чисел: 75, 34, -15, -123, 57, -145, 86, 77, 48, -59.
//Найдите минимальный элемент массива и его индекс.
//Каков будет результат, если в массиве несколько одинаковых минимальных элементов?
//Найдите максимальный элемент массива и его индекс.
//Поменяйте местами минимальный и максимальный элементы, распечатайте массив.
public class Task1 {
    public static void main(String[] args) {
        int [] task1 = {75, 34, -15, -123, 57, -145, 86, 77, -145, 48, -59, -145};
        int min = task1[0]; //  guess предположение
        int indexMin = 0; //  guess предположение

        for (int i = 0; i < task1.length; i++) {
            if (task1[i] < min){
                min = task1[i];
                indexMin = i;

            }//end if

        }//end for
        System.out.print("Min element of array " + min + " , index of min element = " + indexMin  + ".");


        // //Поменяйте местами минимальный и максимальный элементы, распечатайте массив. МЕНЯЕМ
        int max = task1[0]; //  guess предположение
        int indexMax = 0; //  guess предположение

        for (int i = 0; i < task1.length; i++) {
            if (task1[i] > max){
                max = task1[i];
                indexMax = i;

            }//end if

        }//end for
        System.out.println();
        System.out.print("Max element of array " + max + " , index of max1 element = " + indexMax  + ".");

        //МЕНЯЕМ местами минимальный и максимальный элементы
        int temp = task1[indexMin];
        task1[indexMin] = task1[indexMax];
        task1[indexMax] = temp;
        System.out.println();
        System.out.println(task1);

        for (int i = 0; i < task1.length; i++) {
            System.out.print(task1[i] + " ");
        }//end for
        System.out.println();
    }//end main

}//end class
