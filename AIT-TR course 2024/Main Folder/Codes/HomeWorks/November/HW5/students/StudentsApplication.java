package HW5.students;

import HW1.runners.Runners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Задача 1.(*) Напишите программу, которая: Создает список студентов, зарегистрированных на два разных курса: "Математика" и "Информатика". Выводит: Список студентов, которые записаны на оба курса. Список студентов, которые записаны только на один из курсов. Условия: Используйте два HashSet для хранения студентов каждого курса. Программа должна использовать операции пересечения и разности множеств для вывода нужных списков.
public class StudentsApplication {
    public static void main(String[] args) {

        //create two groups
        Set<Students> mathOptional = new HashSet<>(Set.of(new Students("Jack Salivan", true, false), new Students("Bredd Pitt", true, false), new Students("Sara Connor", true, false), new Students("Scott Obrayan", true, true), new Students("Djo Slim", true, true), new Students("Lily Brackets", true, false), new Students("Fin Do", true, false), new Students("Mary-Louise Scrennton", true, true)));


        Set<Students> informOptional = new HashSet<>(Set.of(new Students("Arrny List", true, false), new Students("Mary-Louise Scrennton", true, true), new Students("Marc Polo", true, false), new Students("July Grant", true, false), new Students("Scott Obrayan", true, true), new Students("Walter White", true, false), new Students("Victoriya Sicret", true, false), new Students("Rico Soul", true, false), new Students("Djo Slim", true, true)));

        System.out.println("General quantity of students -> " + (informOptional.size() + mathOptional.size()));
        System.out.println();

        //make new sets for information, we want to know
        Set<Students> oneOptioanalStudyStudents = new HashSet<>();
        Set<Students> twoOptioanalsStudyStudents = new HashSet<>();

        //call method
        uniqueStudents(mathOptional, informOptional, oneOptioanalStudyStudents, twoOptioanalsStudyStudents);

        //print results
        System.out.println("List of students, learning in one optional");
        for (Students st : oneOptioanalStudyStudents) {
            System.out.println(st);
        }//end for
        System.out.println("Quantity of students -> " + oneOptioanalStudyStudents.size() + ".");
        System.out.println();

        System.out.println("List of students, learning in two optionals");
        for (Students st : twoOptioanalsStudyStudents) {
            System.out.println(st);
        }//end for
        System.out.println("Quantity of students -> " + twoOptioanalsStudyStudents.size() + ".");

    }//end main

    private static void uniqueStudents(Set<Students> mathOptional, Set<Students> informOptional, Set<Students> oneOptioanalStudyStudents, Set<Students> twoOptioanalsStudyStudents) {

         oneOptioanalStudyStudents.addAll(mathOptional);
         oneOptioanalStudyStudents.addAll(informOptional);


        for (Students st : mathOptional) {
            if (informOptional.contains(st)) twoOptioanalsStudyStudents.add(st);
        }//end for
    }//end uniqueStudents

}//end class
