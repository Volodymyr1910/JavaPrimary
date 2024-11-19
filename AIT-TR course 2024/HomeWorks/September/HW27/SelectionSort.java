package HW27;

import array_methods.ArrayMethods;

//Задача 3. ()* Найти в Интернете алгоритм selection sort. https://www.geeksforgeeks.org/selection-sort/ Задать массив из случайных целых чисел.
// Реализовать метод, получающий на вход массив и сортирующий его по алгоритму selection sort.

/// я думаю что здесь обьясняют понятие selection sort лучше, но на английском https://www.youtube.com/watch?v=EwjnF7rFLns&t=139s

public class SelectionSort {
    public static void main(String[] args) {
        int array[] = ArrayMethods.fillArrayRandomWithoutRepetitions(1, 10, 7);
        ArrayMethods.printArray(array);
        ArrayMethods.selectionSort(array);
        ArrayMethods.printArray(array);
    }//end main
}//end class
