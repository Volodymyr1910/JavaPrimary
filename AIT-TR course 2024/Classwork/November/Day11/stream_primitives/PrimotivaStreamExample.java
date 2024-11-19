package Day11.stream_primitives;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

//**Задание 1.**
//Стримы примитивов Integer, Long, Double
//- получить случайные целые числа в интервале от min = 1 до max = 10 в нужном количестве
//- получение простейших статистических данных с помощью summaryStatistics
//- моделирование лотереи 6 из 49
public class PrimotivaStreamExample {

    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final int N_NUMBERS = 20;


    public static void main(String[] args) {

        Stream<Integer> numbers = getRandomNumbers(MIN, MAX, N_NUMBERS);
        // numbers.forEach(System.out::println);
        //numbers.forEach(n -> System.out.print(n + " ")); forEach - терминальная операция, после выполнения которой, stream будет недоступен


        System.out.println("----------------------------------------------sum of numbers in stream -------------------------------------");
        int sum = numbers.mapToInt(Integer::intValue) // достаем значения елементов в stream
                .sum(); // суммируем элементы  при этом sum() также терминальная операция, после выполнения которой, stream будет недоступен
        System.out.println("Sum = " + sum);


        System.out.println("----------------------------------------------SummaryStatistics -------------------------------------");
        IntSummaryStatistics intSummaryStatistics = getRandomNumbers(N_NUMBERS, MIN, MAX)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("Min value: " + intSummaryStatistics.getMin());
        System.out.println("Max value: " + intSummaryStatistics.getMax());
        System.out.println("Average: " + intSummaryStatistics.getAverage());
        System.out.println("Count: " + intSummaryStatistics.getCount());
        System.out.println("Sum: " + intSummaryStatistics.getSum());


        System.out.println("---------------------моделирование лотереи 6 из 49------------------------"); // 6 чисел, без повторов, в промежутке от 1 до 50
        Stream <Integer> lotteryNumbers = getRandomNumbers(1, 50)
                .distinct()
                .limit(6);

        //lotteryNumbers.forEach((n) -> System.out.println(n));
        lotteryNumbers.forEach(System.out::println);
    //There are a couple of small issues with your code:
        //Stream.forEach() doesn't return a Stream. Instead, it performs an action on each element of the stream and returns void. So if you intend to store the lottery numbers in a list or further use them, you should call forEach separately after limiting and collecting the numbers.
        //To fix this, you might want to use .collect() instead of forEach() at first, if you want to store or use the generated numbers as a collection.
        //List<Integer> lotteryNumbers = getRandomNumbers(1, 50, 6) .distinct() .limit(6) .collect(Collectors.toList()); // Collects into a List for further use lotteryNumbers.forEach(System.out::println); // Prints the collected numbers if needed






    }//end main

    private static Stream<Integer> getRandomNumbers(int min, int max) {
        return new Random()
                .ints(MIN, MAX) // создает стрим рандомных чисел в заданных количестве и границах от и до
                .boxed(); // упаковка структуры в память для дальнейшего использования
    }//end getRandomNumbers


    private static Stream<Integer> getRandomNumbers(int min, int max, int nNumbers) {
        return new Random()
                .ints(N_NUMBERS, MIN, MAX) // создает стрим рандомных чисел в заданных количестве и границах от и до
                .boxed(); // упаковка структуры в память для дальнейшего использования
    }//end getRandomNumbers

    //Методы .ints(), .doubles(), и аналогичные в классе java.util.Random используются для генерации потоков случайных чисел различных типов, таких как int, double, и long. Эти методы полезны для получения последовательностей случайных чисел, которые можно обработать как потоки (Stream), что особенно удобно для работы с большими наборами данных.

}//end class
