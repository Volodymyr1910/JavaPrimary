package HW6;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetFirstTime {


    public static void main(String[] args) {


        TreeSet <Integer> firstTreeSet = new TreeSet<>(Set.of(6,8,10,35, 17,22, 4,25,13,9,2,23,32));
        System.out.println(firstTreeSet);
        System.out.println(" start size -> " + firstTreeSet.size()); // 13
        // add new element
        firstTreeSet.add(27);
        System.out.println(" after add -> " + firstTreeSet.size());  // 14

        //remove element
        firstTreeSet.remove(8);
        System.out.println(" after remove -> " + firstTreeSet.size());  // 13

        // contains
        System.out.println(" contains 35 ? -> " + firstTreeSet.contains(35)); // true
        System.out.println(" contains 100 ? -> " + firstTreeSet.contains(100)); // false

        //is treeSet empty
        System.out.println(" empty ? -> " + firstTreeSet.isEmpty()); // false

        // get the smallest element in set
        System.out.println(" the smallest number is -> " + firstTreeSet.first()); // 2

        // get the biggest element in set
        System.out.println((" the biggest number is -> " + firstTreeSet.last())); // 35

        // remove smallest
        System.out.println(" remove smallest " + firstTreeSet.pollFirst());  // remove 2
        System.out.println(firstTreeSet);

        // remove biggest
        System.out.println(" remove biggest " + firstTreeSet.pollLast());  // remove 35
        System.out.println(firstTreeSet);

        // get the biggest element that is lower than choosen
        System.out.println(" find the lowest element, that is bigger than 15 - > " + firstTreeSet.higher(15)); // 17

        // get the smallest element that is bigger than choosen
        System.out.println(" find the biggest element, that is lower than 15 - > " + firstTreeSet.lower(15)); // 13

        // copy elements to another object
        Object clone = firstTreeSet.clone();
        System.out.println("clone " + clone);  //(4, 6, 9, 10, 13, 17, 22, 23, 25, 27, 32 )

        //get the lowest element that is equil or bigger than chossen
        System.out.println(" bigger or equil 14 -> " + firstTreeSet.ceiling(14)); // 17

        //get the biggest element that is equil or lower than chossen
        System.out.println(" lower or equil 13 -> " + firstTreeSet.floor(12)); // 10

        //get elements in range
        System.out.println(" all elements from 6 to 28  -> " + firstTreeSet.subSet(6, 25)); //(6, 8, 9, 10, 13, 17, 22, 23 )

        //get all elements, that is lower than choosen
        System.out.println(" all elements lower than 11 -> " + firstTreeSet.headSet(11)); //(4, 6, 9, 10 )


        //get all elements, that is equal or bigger than choosen
        System.out.println(" all elements that is equal or bigger than 11 -> " + firstTreeSet.tailSet(11)); //(13, 17, 22, 23, 25, 27, 32 )

    }//end vain






}//end class
