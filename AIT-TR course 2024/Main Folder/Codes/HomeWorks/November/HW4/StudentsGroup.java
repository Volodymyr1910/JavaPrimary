package HW4;

import MyMethods.array_methods.ArrayMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Задача 3.(*) Распределить группу студентов на две примерно равных группы (+/- 1 человек) случайным образом. Определить список студентов в программе. Получить на выходе 2 списка студентов.
public class StudentsGroup {
    private static final Random random = new Random();

    public static void main(String[] args) {

        List<String> students = new ArrayList<>(List.of("st 1", "st 2", "st 3", "st 4", "st 5", "st 6", "st 7", "st 8", "st 9", "st 10", "st 11", "st 12", "st 13", "st 14", "st 15", "st 16", "st 16", "st 18", "st 19", "st 20", "st 21", "st 22", "st 23"));

        List<String> group1 = new ArrayList<>();
        List<String> group2 = new ArrayList<>();

        fairSeparate(students, group1, group2);
        printListOneString(group1);
        printListOneString(group2);


    }//end main


    public static void fairSeparate(List students, List group1, List group2) {

        int place = 0;
        int listStartSize = students.size();

        for (int i = 0; i < listStartSize; ) {

            //when or if -> origin list have 1 element, it will go to random group
            if (students.size() == 1 && group1.size() == group2.size()) {
                place = random.nextInt(0, 2);
                if (place == 0) group1.add(i, students.get(0));
                else group2.add(i, students.get(0));
                i = listStartSize;
            }//end if

            //otherwise, each group receives a member at each iteration
            if ( i != listStartSize) {
                place = random.nextInt(0, (students.size() - 1));
                group1.add(i, students.get(place));
                students.remove(place);

                place = random.nextInt(0, (students.size() - 1));
                group2.add(i, students.get(place));
                students.remove(place);

                // to next interation
                i++;
            }//end if
        }//end for

    }//end fairSeparate

    public static void printListOneString(List list) {
        //for (Object o : list) {
        //System.out.print(o + ", ");
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) System.out.print(list.get(i) + ", ");
            if (i == list.size() - 1) System.out.println(list.get(i));

        }//end for
        System.out.println();
    }//printListOneString


}//end class
