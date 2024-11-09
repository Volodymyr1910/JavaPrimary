package HW8;

import array_methods.ArrayMethods;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Задача 3(*). В классе DigitsFreqApp сгенерировать один миллион положительных целых чисел в интервале от 100 до 1000, и подсчитать частоту встречаемости цифр в этих числах.
public class DigitsFreqApp {

    public static void main(String[] args) {
        Random random = new Random();


        // create variables for entroducing quantity of generated numbers and control of this process
        int count = 1;
        int quantity = 1000000;

        //create million of numbers and put them to string
        StringBuilder str = new StringBuilder();
        while (count++ < quantity) {
            str.append(random.nextInt(100, 1001));
        }//end while

        Map <Integer, Integer> numbersMap = new HashMap<>(Map.of(0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0) );
        for (int i = 0; i < str.length(); i++) {
            numbersMap.put(str.charAt(i)- '0', (numbersMap.get(str.charAt(i)- '0') + 1));
        }//end for
        System.out.println();
        numbersMap.forEach((key, value)-> System.out.println(key + " : " + value));

    }//end main
}//end class
