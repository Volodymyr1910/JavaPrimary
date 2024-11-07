package Day7.citizens.collections;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsMethods {

    public static void main(String[] args) {


       List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("lemon");
        fruits.add("papaya");
        fruits.add("orange");
        fruits.add("pineapple");
        fruits.add("grape");
        fruits.add("apricot");
        fruits.add("peach");
        fruits.add("pear");
        fruits.add("banana");

        for (String fruit : fruits)  System.out.print(fruit + " | ");
        System.out.println();
        fruits.forEach(System.out::println); //


        System.out.println("---------------------------sort---------------------------");

        //вариант 1
        System.out.println("----------------------- v 1 -------------------------");
        Comparator <String> fruitComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return - o1.compareTo(o2);
            }
        };
        Collections.sort(fruits, fruitComparator);
        fruits.forEach(System.out::println);

        //вариант 2
        System.out.println("----------------------- v 2 -------------------------");
        Collections.sort(fruits.reversed());
        System.out.println(fruits);

        //вариант 3
        System.out.println("----------------------- v 3 -------------------------");
        Comparator<String> fruitComparator2 = String::compareTo;
        Collections.sort(fruits, fruitComparator2);
        fruits.forEach(System.out::println);


        System.out.println("-------------------------max--------------------------");
        System.out.println(fruits);
        System.out.println(Collections.max(fruits));

        System.out.println("-------------------------max with fruitComparator--------------------------");
        System.out.println(fruits);
        System.out.println(Collections.max(fruits, fruitComparator));


        System.out.println("-------------------------reverse--------------------------");
        Collections.reverse(fruits);
        System.out.println(fruits);
        fruits.forEach(System.out::println);

        System.out.println("-------------------------shuffle--------------------------"); // перетасовывает элементы случайным образом
        Collections.shuffle(fruits);
        fruits.forEach(System.out::println);

    }//end main


}//end class
