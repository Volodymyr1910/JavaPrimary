package HW24;

public class TurnArround {
    //*Задача 4.()
//Написать метод, принимающий массив целых чисел, и "разворачивающий" его. Последний элемент становится нулевым, предпоследний, первым, и т. д.
// Подсказка: этот метод должен изменить полученный массив, а не распечатать его в обратном порядке.


    public static void main(String[] args) {
        int[] massive83 = {5, 10, 15, 20, 30, 40, 50, 60, 70, 80}; // {-44, 68, 2, -17, 73, -41, 52, 56, -55, 83}
        int[] unknown = new int[massive83.length];
        int u = 0;

        for (int i = 0; i < massive83.length; i++) {
            System.out.print(massive83[i] + " ");
        }//end for

        unknown = turnArround(massive83,unknown);

        for (int i = 0; i < unknown.length; i++) {
            System.out.print(unknown[i] + " ");
        }//end for

    }//end main

    public static int[] turnArround(int[] massive83, int [] unknown) {
        int u = 0;
        for (int t = massive83.length-1; t >= 0; t--) {
            unknown[u] = massive83[t];
            u++;
        }//end for
        //System.out.println();
        return unknown;
    }//end turnArround


}//end class
