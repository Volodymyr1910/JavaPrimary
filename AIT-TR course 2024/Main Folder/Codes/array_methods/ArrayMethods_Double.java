package array_methods;

public class ArrayMethods_Double {



//// ------------------------------------- Searching in array  ----------------------------------------------



//// ------------------------------------- Sorting array ----------------------------------------------------



//// ------------------------------------- Copy or transfer array with CHANGING ARRAY TYPE ------------------



//// ------------------------------------- Copy or transfer array -------------------------------------------



//// ------------------------------------- Other operations with array  -------------------------------------

    //accrues interest на каждый елемент массива + 0.05%
    public static double[] calculatePercentDouble (double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + (array[i] * 0.05);
        }//end for
        return array;
    }//end calculatePercentDouble

//// ------------------------------------- Total and Average of array  --------------------------------------

    // возвращает среднее арифметическое значение всех элементов массива.
    public static double averageValueDouble (double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }//end for
        return sum / array.length;
    }//end averageValueDouble

    // возвращает сумму всех элементов массива.
    public static double sumArrayDouble (double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }//end sumArrayDouble

//// ------------------------------------- Print array ------------------------------------------------------

    //print double[] array
    public static void printArrayDouble (double[] array) {
        int n = 0;
        System.out.println(); // добавил println т.к. следующая печать printf
        for (int i = 0; i < array.length; i++) {
            System.out.printf(" %.2f", array[i]);
            n++;
            if (n < array.length) {
                System.out.print("; ");
            }//end if
        }//end for
        System.out.println();
        System.out.println("------------------------------");
    }//end printArrayDouble

//// ------------------------------------- Fill array -------------------------------------------------------

    //fill double[] array random numbers
    // a - left border, b - right border, n - quantity (array size)
    public static double[] fillArrayRandomDouble (double a, double b, int n) {
        double[] res = new double[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = (Math.random() * (b - a + 1) + a);
        }//end for
        return res;
    }//end fillArrayRandomDouble

}//end class
