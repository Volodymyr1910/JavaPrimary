package HW31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

//Задача 4.(*) Заполните структуру типа ArrayList 20-ю случайными целыми числами в интервале от 1 до 10. Удалите из полученного списка дубликаты.
public class ArrayListNumbers {

    public static void main(String[] args) {

        Random random = new Random();
        ArrayList <Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
        num.add(i, random.nextInt(0, 10) + 1);
        }
        Collections.sort(num);

        for (int i = 0; i < num.size()-1;) {
            if(num.get(i) == num.get(i+1)) num.remove(i);
            else i++;
        }
        System.out.println(num);
    }//main

}//end class
