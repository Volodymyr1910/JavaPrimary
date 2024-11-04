package Day4.linked_list_test;

import java.util.*;

public class ListPerformanceTest {
    private static final int N_NUMBERS = 500_000;
    private static final Random random = new Random();
    private static final int MIN = 10;
    private static final int MAX = 20;

    // будем суммировать случайные числа из списка
    public static void main(String[] args) {


        List<Integer> list = new LinkedList<>();
        fillList(list);

        System.out.println("=========================== for each loop ==========================");
        long t1 = System.currentTimeMillis();
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }//end for
        long t2 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(" Time for each -> " + (t2 - t1));

        System.out.println("=========================== iterator loop ==========================");
        t1 = System.currentTimeMillis();
        sum = 0;
        Iterator <Integer>iterator = list.iterator();
        while(iterator.hasNext()){
            sum+= iterator.next();
        }//end for
        t2 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(" Time iterator -> " + (t2 - t1));

        System.out.println("=========================== fori loop ==========================");
        t1 = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum+= list.get(i);
        }//end for
       t2 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(" Time fori -> " + (t2 - t1));



    }//end main

    private static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }//end for
        System.out.println();
        System.out.println("--------------------------------------------------");
    }//end printList

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(random.nextInt(MIN, MAX));
        }//end fori
    }//end fillList


}//end class
