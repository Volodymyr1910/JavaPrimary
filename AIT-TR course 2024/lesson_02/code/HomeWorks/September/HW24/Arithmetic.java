package HW24;

public class Arithmetic {
    //Задача 3 (*).
//Написать метод, принимающий массив целых чисел, и возвращающий среднее арифметическое всех его элементов.
// Проверьте его работу на массиве ageOfGroup = {47, 49, 37, 47, 52, 60, 44, 34, 38, 59, 18, 38, 35, 41, 18, 43};
//

    public static void main(String[] args) {

        int[] ageOfGroup = {47, 49, 37, 47, 52, 60, 44, 34, 38, 59, 18, 38, 35, 41, 18, 43};
        float res = arithmeticAverage(ageOfGroup);
        System.out.printf("The average arithmetic number of massive ageOfGroup is -> %.2f", res);
        System.out.println(".");

    }//end main

    private static float arithmeticAverage(int [] ageOfGroup) {
        float sum =0;
        for (int a = 0; a < ageOfGroup.length; a++) {
            sum = sum + ageOfGroup[a];
        }//end for
        return (float) sum / ageOfGroup.length;
    }//end of arithmeticAverage


}//end class
