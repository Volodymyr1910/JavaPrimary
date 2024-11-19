package Day5.hash_set_example;

import java.util.HashSet;
import java.util.Set;

public class HashSwtApplication {

    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>(4,0.5F); // указаны собственные capacity и loadFactor

        // добавляем числа в сет
        for (int i = 0; i < 10; i++) {
            numbers.add(i * 10); // 0, 10, 20, ..., 90
        }

        System.out.println(numbers.size());
        System.out.println("-------------------------");

        for (Integer i: numbers ) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        numbers.add(50);
        System.out.println(numbers.size());
        System.out.println("-------------------------");
        for (Integer i: numbers ) {
            System.out.println(i);
        }

    }









}//end class
