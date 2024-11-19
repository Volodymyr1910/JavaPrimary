package HW11;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Задание 1. Имеется набор оценок 20 студентов в диапазоне от 5 до 1 балла за семестр по 10 предметам. Смоделируйте этот набор данных, найдите студентов с максимальным/минимальным средним баллом. Используйте методы stream()
public class StudentsGrade222 {
    static Random random = new Random();

    public static void main(String[] args) {

        Set<String> students = new TreeSet<>(Set.of("St1", "St2", "St3", "St4", "St5", "St6", "St7", "St8", "St9", "St10", "St11", "St12", "St13", "St14", "St15", "St16", "St17", "St18", "St19", "St20"));
        Set<String> operations = new TreeSet<>(Set.of("Math", "Information Security", "Logistics", "Sport", "Religion", "Physics", "Chemistry", "Anatomy", "English", "Ecology"));

        findWorstAndBest1(students, operations);

    }//end main

    private static TreeMap<String, Integer> tabel1(Set<String> operations) {
        TreeMap<String, Integer> operationGrades = new TreeMap<>();
        operations.forEach((op) -> operationGrades.put(op, random.nextInt(1, 6)));
        return operationGrades;
    }//end tabel

    private static void findWorstAndBest1 (Set <String> students,  Set<String> operations) {

        TreeMap<Double, List <String>> studentsAverageGrade = new TreeMap<>();

        students.forEach((student) -> {
            TreeMap<String, Integer> grades = tabel1(operations);
            double avg = grades.values().stream().mapToInt(Integer::intValue).average().orElse(0);
            studentsAverageGrade.computeIfAbsent(avg, k -> new ArrayList<>()).add(student);
        });

        studentsAverageGrade.forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("Best average grade -> " + studentsAverageGrade.lastKey() + " have student " + studentsAverageGrade.get(studentsAverageGrade.lastKey()));
        System.out.println("Worst average grade -> " + studentsAverageGrade.firstKey() + " have student " + studentsAverageGrade.get(studentsAverageGrade.firstKey()));

    }//end findWorstAndBest


}//end class
