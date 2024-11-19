package HW11;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumbersStream {
//Задание 2. Имеется набор целых чисел: 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20. Требуется из этого списка отобрать только простые числа. Используйте методы stream()
    public static void main(String[] args) {

        List <Integer> num = Arrays.asList(1, 12, 13, 14, 15, 16, 17, 18, 19, 20);

        List<Integer> res = num.stream().filter(PrimeNumbersStream::isPrimeNumber).toList();
        //Stream<Integer> res = Stream.of(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20).filter(n -> isPrimeNumber(n));
        System.out.println(res);
    }//end main

    public static boolean isPrimeNumber(Integer number){
        if(number <= 1 ){
            return false;
        }
        return IntStream.range(2,number)
                .noneMatch(div -> number % div == 0);
    }//end isPrimeNumber
}//end class
