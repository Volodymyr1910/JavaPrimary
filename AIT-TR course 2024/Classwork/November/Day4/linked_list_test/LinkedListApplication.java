package Day4.linked_list_test;
// заполнить список случайными целыми числами
// проверить работу методов LinkedList

import java.util.*;


public class LinkedListApplication {

    private  static final int N_NUMBERS = 10;
    private static final Random random = new Random();
    private static  final int MIN = 10;
    private static  final int MAX = 20;

    public static void main(String[] args) {

        List <Integer> list = new LinkedList<>(); // определяем имплементацию
        fillList (list); // create
        printList(list); // read

        System.out.println(list.size());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(0));
        System.out.println(list.get(list.size() - 1));
        System.out.println("-----------------------------------------------------");
        System.out.println(list.indexOf(25)); // -1
        System.out.println(list.indexOf(10));

        list.set(0,50);
        list.set(N_NUMBERS-1, 100);
        printList(list);

        list.set((N_NUMBERS - 1) / 2, 200);
        System.out.println(list.size());

        //удалить конкретное число 15, если оно есть

        // for each годится только для поиска елемента, добавлять или удалять элементы нельзя, будет ошибка
        //for (Integer num : list) {list.remove(num); printList(list);   }//end for

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer num = iterator.next();
            if(num.equals(15)){
                iterator.remove(); // удаление в позиции курсора итератора
            }
        }
        printList(list);
        list.remove(list.indexOf(100));


        //удаление по условию prtdicate или ляьда-выражение
        // удалим все элементы кратные 3
        list.removeIf(e -> e % 3 == 0);


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
           list.add(random.nextInt(MIN,MAX)) ;
        }//end fori
    }//end fillList


}//end class
