package MyMethods.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FastTransferDataFrom1ToAnother {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>(List.of(3, 5, 1, 9, 3));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(8, 2, 5, 3));

        //Merging lists
        ArrayList <Integer> mergeList = new ArrayList<>(list1); // ввели list1 лист в другой mergeList
        mergeList.addAll(list2); // добавили еще один list2 в  mergeList
        System.out.println(mergeList);

        //Remove duplicates
        Set<Integer> iniqueNumbers = new HashSet<>(mergeList); //хешсет убрал все дубликаты

        System.out.println(iniqueNumbers);

        //put set into List

        mergeList = new ArrayList<>(iniqueNumbers); // обновили mergeList, теперь он без дубликатов







    }//end main



}//end class
