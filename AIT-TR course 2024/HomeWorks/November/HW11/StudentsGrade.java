package HW11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Задание 1. Имеется набор оценок 20 студентов в диапазоне от 5 до 1 балла за семестр по 10 предметам. Смоделируйте этот набор данных, найдите студентов с максимальным/минимальным средним баллом. Используйте методы stream()
public class StudentsGrade {
    static Random random = new Random();

    public static void main(String[] args) {

        Set<String> students = new HashSet<>(Set.of("St1", "St2", "St3", "St4", "St5", "St6", "St7", "St8", "St9", "St10", "St11", "St12", "St13", "St14", "St15", "St16", "St17", "St18", "St19", "St20"));
        Set<String> operations = new HashSet<>(Set.of("Math", "Information Security", "Logistics", "Sport", "Religion", "Physics", "Chemistry", "Anatomy", "English", "Ecology"));


        Map<String, Map<String, Integer>> studentsGrades = new TreeMap<>();
        students.forEach((student) -> studentsGrades.put(student, tabel(operations)));
        //studentsGrades.forEach((key, value) -> System.out.println(key + " -> " + value));
       findWorstAndBest(studentsGrades);



    }//end main

    private static void findWorstAndBest(Map<String, Map<String, Integer>> studentsGrades) {
       //create map for save results of calc average grade
        Map < String, Double> studentsAverageGradeTemp = new HashMap<>();

        // find average grade for all
        studentsGrades.forEach( (student, grades) -> {
            double avg = grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
            studentsAverageGradeTemp.put(student, avg);
        });

        //create treeMap_ with comparator in constructor for sort by average grade
        TreeMap < String, Double> studentsAverageGrade = new TreeMap<>(
                (st1, st2) -> {
                    int res = Double.compare(studentsAverageGradeTemp.get(st2),studentsAverageGradeTemp.get(st1));
                    return  res != 0 ? res : st1.compareTo(st2);
                }
        );
        studentsAverageGrade.putAll(studentsAverageGradeTemp);

        System.out.println("Best student : " + studentsAverageGrade.firstKey() + " with average grade -> " + studentsAverageGrade.get(studentsAverageGrade.firstKey()));
        System.out.println("Worst student : " + studentsAverageGrade.lastKey() + " with average grade -> " + studentsAverageGrade.get(studentsAverageGrade.lastKey()));
        studentsAverageGrade.forEach((key, value) -> System.out.println(key + " -> " + value));

    }//end findWorstAndBest

    private static Map<String, Integer> tabel(Set<String> operations) {
        Map<String, Integer> operationGrades = new HashMap<>();
        operations.forEach((op) -> operationGrades.put(op, random.nextInt(1, 6)));
        return operationGrades;
    }//end tabel


}//end class
