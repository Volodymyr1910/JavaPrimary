package Day27;

import array_methods.ArrayMethods;

public class TurnArroundArray {
    public static void main(String[] args) {
        // перекручивание массива
        /*int [] newArray = ArrayMethods.fillArray(1, 20, 5);
        ArrayMethods.printArray(newArray);
        int [] ddd = {1,2,3,4,5};
        int [] res = ArrayMethods.turnArroundInt(newArray,ddd);
        ArrayMethods.printArray(res); */
    //-----------------------------------------------------------


         //Задача 1
        //Создать массив из 20-ти случайных целых чисел из интервала от -100 до 100.
         int [] numbers = ArrayMethods.fillArrayRandom(-100,100,20);
         ArrayMethods.printArray(numbers);
         //Выполните сортировку полученного массива.
        ArrayMethods.bubleSortFromLowToBig(numbers);
        ArrayMethods.printArray(numbers);
         //Попало ли число 0 в этот массив? (выяснить с помощью binary search)
        int index = ArrayMethods.binarySearchFromLowToBig(numbers,0);
        System.out.println(index);
         //Если да, то на какое место (индекс) в массиве?
        //Если нет, то на какой индекс его следует поставить?
        index = (index > 0) ? index : -index-1;
        System.out.println(index);


        //Задача 2
        //Создать массив из 20-ти случайных целых чисел из интервала от -100 до 100.
        //Реализуйте метод, который получает на вход исходный массив и возвращает массив,
        //содержащий только положительные числа из исходного массива.
        int [] numbers1 = ArrayMethods.fillArrayRandom(-100,100,20);
        ArrayMethods.printArray(numbers1);
        int positive = howMuchPositiveNumbersInArray(numbers1);
        System.out.println("We have " + positive + " positive numbers in array.");
        int temp1 [] = ArrayMethods.tranferToNewArrayOnlyPositiveAutoSize(numbers1);
        ArrayMethods.printArray(temp1);



    }//end main



    public static int howMuchPositiveNumbersInArray (int [] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0){
                count++;
            }
        }//end for
        return count;
    }//end  howMuchPositiveNumbersInArray

}//end class
