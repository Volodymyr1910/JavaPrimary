package MyMethods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseIterator {

    public static void main(String[] args) {

        List <Integer> list = new ArrayList<>();


        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer num = iterator.next();
            if(num.equals(15)){
                iterator.remove(); // удаление в позиции курсора итератора
            }//end if
        }//end while

    }//end main

}//end class
