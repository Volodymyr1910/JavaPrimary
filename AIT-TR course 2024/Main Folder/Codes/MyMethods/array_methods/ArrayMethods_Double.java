package MyMethods.array_methods;

public class ArrayMethods_Double {

//// ------------------------------------- Searching in array  ----------------------------------------------

//// ------------------------------------- Sorting array ----------------------------------------------------

    //selection sort
    public static void selectionSortDoubleWrap(Double array[]) {
        for (int i = 0; i < array.length; i++) {
            double minElement = array[i];
            int count = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minElement) {
                    minElement = array[j];
                    count = j;
                }//end if
            }//for
            if (minElement < array[i]) {
                double temp = array[i];
                array[i] = minElement;
                array[count] = temp;
            }
        }//end for
    }// end selectionSortDoubleWrap

    //bublesort сортирует по убыванию и ВОЗВРАЩАЕТ МАССИВ
    //- упорядоченные элементы выключаются из цикла
    public static Double[] bubleSortFromHighToSmallWithReturnDoubleWrap(Double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    Double temp = array[j];  //if(array[j] < array[j + 1]) изменение знака влияет на сортировку по возрастанию или по убыванию
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
        return array;
    }//end bubleSortFromHighToSmallWithReturnDoubleWrap

    //bublesort сортирует по возрастанию и ВОЗВРАЩАЕТ МАССИВ
    //- сравниваем всегда 2 соседних элемента, переставляем их местами, если они расположены не в порядке возрастания
    //- цикл должен идти слева направо
    //- упорядоченные элементы выключаются из цикла
    public static Double[] bubleSortFromLowToBigWithReturnDoubleWrap(Double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    Double temp = array[j];  //if(array[j] < array[j + 1]) изменение знака влияет на сортировку по возрастанию или по убыванию
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
        return array;
    }//end bubleSortFromLowToBigWithReturnDouble



    //selection sort
    public static void selectionSortDouble(double array[]) {
        for (int i = 0; i < array.length; i++) {
            double minElement = array[i];
            int count = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minElement) {
                    minElement = array[j];
                    count = j;
                }//end if
            }//for
            if (minElement < array[i]) {
                double temp = array[i];
                array[i] = minElement;
                array[count] = temp;
            }
        }//end for
    }// end selectionSortDouble

    //bublesort сортирует по убыванию и ВОЗВРАЩАЕТ МАССИВ
    //- упорядоченные элементы выключаются из цикла
    public static double[] bubleSortFromHighToSmallWithReturnDouble(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    double temp = array[j];  //if(array[j] < array[j + 1]) изменение знака влияет на сортировку по возрастанию или по убыванию
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
        return array;
    }//end bubleSortFromHighToSmallWithReturnDouble

    //bublesort сортирует по возрастанию и ВОЗВРАЩАЕТ МАССИВ
    //- сравниваем всегда 2 соседних элемента, переставляем их местами, если они расположены не в порядке возрастания
    //- цикл должен идти слева направо
    //- упорядоченные элементы выключаются из цикла
    public static double[] bubleSortFromLowToBigWithReturnDouble(double[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) { //compare two ellements of array, if left > right -> swap (меняем местами)
                    double temp = array[j];  //if(array[j] < array[j + 1]) изменение знака влияет на сортировку по возрастанию или по убыванию
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }//end if
            }//end for2
        }//end for1
        return array;
    }//end bubleSortFromLowToBigWithReturnDouble

//// ------------------------------------- Copy or transfer array with CHANGING ARRAY TYPE ------------------

//// ------------------------------------- Copy or transfer array -------------------------------------------

//// ------------------------------------- Other operations with array  -------------------------------------

    //accrues interest на каждый елемент массива + 0.05%
    public static double[] calculatePercentDouble(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + (array[i] * 0.05);
        }//end for
        return array;
    }//end calculatePercentDouble

//// ------------------------------------- Total and Average of array  --------------------------------------

    // возвращает среднее арифметическое значение всех элементов массива.
    public static double averageValueDouble(double[] array) {
        return sumArrayDouble(array) / array.length;
    }//end averageValueDouble

    // возвращает сумму всех элементов массива.
    public static double sumArrayDouble(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }//end sumArrayDouble

//// ------------------------------------- Print array ------------------------------------------------------

    //print Double[] array
    public static void printArrayDoubleWrap(Double[] array) {
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
    }//end printArrayDoubleWrap

    //print double[] array
    public static void printArrayDouble(double[] array) {
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
    public static double[] fillArrayRandomDouble(double a, double b, int n) {
        double[] res = new double[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = (Math.random() * (b - a + 1) + a);
        }//end for
        return res;
    }//end fillArrayRandomDouble

    //fill Double[] array random numbers
    // a - left border, b - right border, n - quantity (array size)
    public static Double[] fillArrayRandomDoubleWrap(double a, double b, int n) {
        Double[] res = new Double[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = (Math.random() * (b - a + 1) + a);
        }//end for
        return res;
    }//end fillArrayRandomDoubleWrap

}//end class
