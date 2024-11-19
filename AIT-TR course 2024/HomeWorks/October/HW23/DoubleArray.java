package HW23;

import MyMethods.array_methods.ArrayMethods_Double;

import java.util.Arrays;
import java.util.Comparator;

////Задание 2. Создайте массив действительных чисел на базе класса-обертки Double на 10 элементов, заполните его случайными числами в интервале от 0 до 10. Выполните сортровки:
////
////ascending; // зростаючий
////descending. // спадаючий
public class DoubleArray {

    public static void main(String[] args) {


        Double array[] = ArrayMethods_Double.fillArrayRandomDoubleWrap(0, 10, 10);
        ArrayMethods_Double.printArrayDoubleWrap(array);

        ArrayMethods_Double.selectionSortDoubleWrap(array); // by ascending
        ArrayMethods_Double.printArrayDoubleWrap(array);

        ArrayMethods_Double.bubleSortFromHighToSmallWithReturnDoubleWrap(array); // by descending
        ArrayMethods_Double.printArrayDoubleWrap(array);

        System.out.println();
        System.out.println("-----------same task, using new technologies-------------");
        Double numbers [] = ArrayMethods_Double.fillArrayRandomDoubleWrap(0,10,10);


        Arrays.sort(numbers);
        ArrayMethods_Double.printArrayDoubleWrap(numbers);// by ascending

        Comparator <Double> comp = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return -Double.compare(o1,o2);
            }
        };

        Arrays.sort(numbers, comp);
        ArrayMethods_Double.printArrayDoubleWrap(numbers); // by descending

    }//end main


}//end class
