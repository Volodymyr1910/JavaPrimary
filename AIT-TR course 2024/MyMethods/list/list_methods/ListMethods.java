package MyMethods.list.list_methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListMethods {



//// ------------------------------------- Total and Average of List  --------------------------------------

    // возвращает среднее арифметическое значение всех элементов массива.
    public static double averageListValueDouble(List list) {
        return sumListDouble(list) / list.size();
    }//end averageListValueDouble

    // возвращает сумму всех элементов массива.
    public static double sumListDouble(List <Double> list) {
        double sum = 0;
        for (Double o : list) {
            sum += o;
        }
        return sum;
    }//end sumListDouble

//// ------------------------------------- Fill list -------------------------------------------------------

    //fill double[] array random numbers
    // a - left border, b - right border, n - quantity (array size)
    public static List<Double> fillArrayRandomDouble(double a, double b, int n) {
        List <Double> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i,(Math.random() * (b - a + 1) + a));
        }//end for
        return list;
    }//end fillArrayRandomDouble

//// ------------------------------------- Print List ------------------------------------------------------

    public static void printList(List list, String s) {
        System.out.println("------------------------ " + " List "  + s + " ------------------------");
        for (int i = 0, count = 0; i < list.size(); i++, count++) {
            System.out.println(count + " " + list.get(i));
        }//end for
    }//end printList

    public static void printListOneString (List list){
        //for (Object o : list) {
            //System.out.print(o + ", ");
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) System.out.print(list.get(i) + ", ");
                if (i == list.size() - 1) System.out.println(list.get(i));

        }//end for
        System.out.println();
    }//printListOneString

}//end class
