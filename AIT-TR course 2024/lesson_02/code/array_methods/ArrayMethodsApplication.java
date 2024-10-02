package array_methods;


import java.util.Scanner;

public class ArrayMethodsApplication {
    public static void main(String[] args) {
        //classwork 25.09
        /*int [] myArray = ArrayMethods.fillArray(-10, 20, 20);
        ArrayMethods.printArray(myArray);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number for searching, please : ");
        int n = scanner.nextInt();
        boolean isInArray = ArrayMethods.searchInArray(myArray,n);
        System.out.println("Number " + n + " is in array: " + isInArray + "."); */

        //homework 25.09
        //задача 1
        /*double [] clientsMoney = ArrayMethods.fillArrayDouble(1.0,1.5,8);
        double [] clientsMoneyWithDayExtra = ArrayMethods.calculatePercent(clientsMoney);
        ArrayMethods.printArrayDouble(clientsMoneyWithDayExtra);
        //задача 2
        double [] test = ArrayMethods.fillArrayDouble(12, 20, 10 );
        double sum = ArrayMethods.sumArrayDouble(test);
        double average = ArrayMethods.averageValueDouble(test);
        System.out.println();
        System.out.printf("Total of array-ellements is -> %.2f", sum);
        System.out.println(".");
        System.out.printf("Average value of array is -> %.2f", average);
        System.out.println("."); */

        //classwork 26.09
        /*int [] myArray = {50, 40, 30, 20, 10}; //{10, 20, 30, 40, 50}
        System.out.println(" Number 10 is in array at position -> " + ArrayMethods.linearSearch(myArray,60));
        int index = ArrayMethods.binarySearchFromHighToSmall(myArray, -2000);
        System.out.println(index);
        //перегон данных с одного массива в другой с изменением типа массива с int на double
        int [] intArray  = {1,2,3,4,5};
        double [] doubleArray = new double[5];
        for (int i = 0; i < intArray.length; i++) {
            doubleArray[i] = intArray[i];
            System.out.print(doubleArray[i] + " ");
        }//end for */


    }//end main

}//end class
