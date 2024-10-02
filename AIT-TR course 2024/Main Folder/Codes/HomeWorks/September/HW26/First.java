package HW26;

import array_methods.ArrayMethods;

public class First {
    public static void main(String[] args) {

        //Задача 1. Написать метод copyOfArray. Метод принимает на вход массив целых чисел и целое число - длину нового массива newLength.
         // Метод должен создать новый массив длиной newLength. В новый массив должны быть скопированы элементы из входящего массива:
        // Пример: Исходный массив: {0, 1, 2, 3, 4 , 5, 6} -> copyOfArray(array, 3) -> вывод на печать {0, 1, 2}
        System.out.println("The old array is : " );
         int [] temp = ArrayMethods.fillArrayRandom(1,5,5); // создание массива донора
         ArrayMethods.printArray(temp); // печать массива донора
        System.out.println("The new array is : ");
        ArrayMethods.printArray(ArrayMethods.copyOfArray(temp,10)); // перенос елементов с массива-доннора в новый массив с последующей печатью

        //====на повторение====== Задача 2. Подбросьте монетку 100 раз и подсчитайте, сколько раз выпал орел и сколько решка.
        // Запишите результаты в массив. Рассчитайте вероятность выпадения орла и решки.

        int [] temporary = ArrayMethods.fillArrayRandom(1,2,100); // создание массива
        int [] resultsArray = new int[2];
        resultsArray[0] = ArrayMethods.howMuchTimesFindElement((temporary), 1); //сколько раз выпал орел кладем в массив с индексом 0
        resultsArray[1] = ArrayMethods.howMuchTimesFindElement((temporary), 2); //сколько раз выпала решка кладем в массив с индексом 1
        int propabilityFrontSide = (resultsArray[0]) % 100; //считаем вероятность выпадения орла
        int propabilityBackSide = 100 - propabilityFrontSide; //считаем вероятность выпадения решки
        System.out.println("We throwed coin 100 times. Front side dropout propability is -> " + propabilityFrontSide + "%");
        System.out.println("We throwed coin 100 times. Back side dropout propability is -> " + propabilityBackSide + "%");


    }//end main
}//end class
