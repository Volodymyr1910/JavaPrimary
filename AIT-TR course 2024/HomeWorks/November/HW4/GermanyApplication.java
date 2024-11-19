package HW4;

//Задача 2. В классе GermanyAppl cоздать LinkedList, содержащий города - столицы земель Германии. Опробовать на нем методы, которые доступны для класса LinkedList. Добавить вольный город Гамбург в начало, в середину списка, в конец списка. Отсортировать список по алфавиту и в обратном порядке.

import MyMethods.list.list_methods.ListMethods;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GermanyApplication {


    public static void main(String[] args) {

        List <String> capitals = new LinkedList<>(Arrays.asList("Stuttgart", "Munich", "Berlin", "Potsdam", "Bremen", "Wiesbaden", "Shverin", "Hanover", "Mainz", "Dresden", "Kiel", "Magdeburg", "Erfurt"));
        List <String> part1 = new LinkedList<>(Arrays.asList("Stuttgart", "Munich", "Berlin"));

        System.out.println(capitals.containsAll(part1)); // true

        System.out.println(capitals.hashCode()); // -1_299_346_965

        capitals.spliterator(); // контрольная точка итератора?


       part1 = capitals.subList(0,5);
        ListMethods.printList(part1, " after copy"); // "Stuttgart", "Munich", "Berlin", "Potsdam", "Bremen"
        part1.subList(2,3).clear();
        ListMethods.printList(part1, " after delete"); // "Stuttgart", "Munich", "Potsdam", "Bremen"

        printList(capitals);
        capitals.add((capitals.indexOf(capitals.getFirst())),"Hamburg");
        capitals.add((capitals.indexOf(capitals.getLast())) + 1,"Hamburg");
        capitals.add(capitals.size() / 2,"Hamburg");

        System.out.println("after add 3 new elements");
        printList(capitals);
        System.out.println();

        //sort
        Collections.sort(capitals);
        printList(capitals);
        System.out.println();

        // reverse sort
      Collections.sort(capitals.reversed());
      ListMethods.printListOneString(capitals);
    }//end main

    public static void printList (List list){
        for (Object o : list) {
            System.out.print(o + ", ");
        }
        System.out.println();
    }//end printList

}//end class
