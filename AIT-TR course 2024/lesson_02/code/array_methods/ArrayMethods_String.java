package array_methods;

import java.util.Arrays;


//// ------------------------------------- Searching in array  ----------------------------------------------



//// ------------------------------------- Sorting array ----------------------------------------------------



//// ------------------------------------- Copy or transfer array with CHANGING ARRAY TYPE ------------------

    public class ArrayMethods_String {
    //разворачивает символы каждого елемента массива в обратном порядке и формирует новый массив, елементы остаются на родных индексах
    // arrayFrom {abcd, fghj, klöä} -> arrayTo {dcba, jhgf, äölk}
    public static String[] reverseArrayString(String[] array) {
        return new String[]{new StringBuilder(Arrays.toString(array)).reverse().toString()};
    }//end reverseArrayString

    // метод що розвертає дані в масиві типу String навпаки int[a,b,c] -> int[c,b,a]
    // если размер arrayFrom больше - будет error
    //если размер arrayTo больше -  в нем останутся пустые ячейки или ячейки с его "родными" елементами
    public static String[] transferFromOneArrayToAnotherWithTurnAroundString(String[] arrayFrom, String[] arrayTo) {
        int u = 0;
        for (int t = arrayFrom.length - 1; t >= 0; t--) {
            arrayTo[u] = arrayFrom[t];
            u++;
        }//end for
        //System.out.println();
        return arrayTo;
    }//end transferFromOneArrayToAnotherWithTurnAroundString

//// ------------------------------------- Copy or transfer array -------------------------------------------



//// ------------------------------------- Other operations with array  -------------------------------------



//// ------------------------------------- Total and Average of array  --------------------------------------



//// ------------------------------------- Print array ------------------------------------------------------
// String [] array = {"saf", "qwe", "jhgjhg"};
// System.out.println(Arrays.toString(array)); // метод toString распечатыывает массивы, но результат не возвращает

    //print String[] array
    public static void printArrayString(String[] array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            n++;
            if (n < array.length) {
                System.out.print("; ");
            }//end if
        }//end for
        System.out.println();
        System.out.println("------------------------------");
    }//end printArrayString


//// ------------------------------------- Fill array -------------------------------------------------------


}//end class

