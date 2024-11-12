package HW11;


import MyMethods.int_methods.IntMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumbersStream {
//Задание 2. Имеется набор целых чисел: 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20. Требуется из этого списка отобрать только простые числа. Используйте методы stream()
    public static void main(String[] args) {

        List <Integer> num = Arrays.asList(1, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        List<Integer> res = num.stream().filter(PrimeNumbersStream::isPrimeNumber).collect(Collectors.toList());
        System.out.println(res);
    }//end main

    public static boolean isPrimeNumber(Integer number){
        int div = 2;
        while (div < number ){
            if(number % div == 0){
                return false;
            }//end if
            div++;
        }//end while div
        return true;
    }//end isPrimeNumber
}//end class
