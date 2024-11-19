package Day4.merge_lists;

import java.util.*;

//Напишите программу, которая объединяет два списка целых чисел (ArrayList<Integer>), удаляет из объединенного списка дубликаты и сортирует его в порядке возрастания.
//list1 = [3, 5, 1, 9, 3]
//list2 = [8, 2, 5, 3]
public class MergeLists {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>(List.of(3, 5, 1, 9, 3));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(8, 2, 5, 3));

        //Merging lists
        ArrayList <Integer> mergeList = new ArrayList<>(list1); // ввели list1 лист в другой mergeList
        mergeList.addAll(list2); // ввели list2 лист в другой mergeList
        System.out.println(mergeList);
        //Remove duplicates

        Set <Integer> iniqueNumbers = new HashSet<>(mergeList);

        System.out.println(iniqueNumbers);

        //put set into List

        mergeList = new ArrayList<>(iniqueNumbers);

        mergeList.sort(Integer::compareTo);
        System.out.println("-----------list after sort---------------");
        System.out.println(mergeList);

    }//end main




}//end class
