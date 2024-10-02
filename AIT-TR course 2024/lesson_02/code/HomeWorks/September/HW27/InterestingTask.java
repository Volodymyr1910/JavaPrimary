package HW27;

import array_methods.ArrayMethods;

import java.util.Random;

public class InterestingTask {
    public static void main(String[] args) {
        //Задача 1. Часть1 Заполните массив целыми числами от 1 до 100. Создайте второй массив с размером на 1 больше, чем имеющийся.
        // Скопируйте первый массив в новый массив.
        //Часть 2 Добавьте случайное целое число в интервале от 1 до 100 на случайное место в исходный массив.
        //Часть 3 В полученном массиве найдите наиболее коротким способом, какое число было добавлено в массив.

        Random random = new Random();

        //Вариант 1

        //создаем массив
        int rightBorderFirstArray = 100;
        int firstArray [] = ArrayMethods.fillArrayRandom(1,rightBorderFirstArray,20);
        //ArrayMethods.printArray(firstArray);

        //копируем старый массив в новый
        int secondArray []= ArrayMethods.copyOfArray(firstArray, firstArray.length+1);
        //ArrayMethods.printArray(secondArray);

        //добавляем случайное число на случайное место в новом массиве
        int randomNumber = random.nextInt(rightBorderFirstArray) + 1;
        //System.out.println(randomNumber);
        secondArray[random.nextInt(firstArray.length)] = randomNumber;
        //ArrayMethods.printArray(secondArray);

        // находим число, которое было добавлено в массив - используя bubleSort и binarySearch
        int numberWhatWeAreLookingFor = secondArray[ArrayMethods.binarySearchFromLowToBig(ArrayMethods.bubleSortFromLowToBigWithReturn(secondArray),randomNumber)];
        System.out.println("В массив добавлено число -> " + numberWhatWeAreLookingFor + ".");



        /*//ВАРИАНТ 2

        //заполняем старый массив
        int rightBorderFirstArray = 100;
        int firstArray[] = ArrayMethods.fillArray(1, rightBorderFirstArray, 20);
        //ArrayMethods.printArray(firstArray);

        //копируем старый массив в новый
        int secondArray[] = ArrayMethods.copyOfArray(firstArray, firstArray.length + 1);
        //ArrayMethods.printArray(secondArray);

        //добавляем случайное число на случайное место в новом массиве
        Random random = new Random();
        int randomNumber = random.nextInt(rightBorderFirstArray) + 1;
        //System.out.println(randomNumber);
        int randomPlace = random.nextInt(firstArray.length);
        //System.out.println(randomPlace);

        //число в новом массиве стоящее на randomPlace перемещаем на пустое последнее место
        //затем приземляем randomNumber в randomPlace в новом массиве
        secondArray[secondArray.length - 1] = secondArray[randomPlace];
        secondArray[randomPlace] = randomNumber;
        //ArrayMethods.printArray(secondArray);

        //считаем суммы масивов
        int sumFirstArray = ArrayMethods.sumArray(firstArray); // сумма елементов старого массива
        int sumSecondArray = ArrayMethods.sumArray(secondArray); // сумма елементов нового массива

        // находим число, которое было добавлено в массив - разница сумм старого и нового массивов
        int numberWhatWeAreLookingFor = sumSecondArray - sumFirstArray;
        System.out.println("В массив добавлено число -> " + numberWhatWeAreLookingFor + "."); */




        /*// ВАРИАНТ 3

        //создаем массив
        int rightBorderFirstArray = 100;
        int firstArray [] = ArrayMethods.fillArray(1,rightBorderFirstArray,20);
        ArrayMethods.printArray(firstArray);

        //копируем старый массив в новый
        int secondArray []= ArrayMethods.copyOfArray(firstArray, firstArray.length+1);
        ArrayMethods.printArray(secondArray);

        //добавляем случайное число на случайное место в новом массиве
        int randomNumber = random.nextInt(rightBorderFirstArray) + 1;
        //System.out.println(randomNumber);
        int randomPlace = random.nextInt(firstArray.length);
        //System.out.println(randomPlace);
        secondArray[randomPlace] = randomNumber;
        //ArrayMethods.printArray(secondArray);

        // находим число, которое было добавлено в массив - по выведенной мною формуле
        // когда рандомное число приземляется в массив, оно заменяет собой то число которое стояло на этом месте
        //поэтому чтоб найти это рандомное число нужно понимать:
         //1. рандомное число приземлилось в таком месте нового массива, которое есть и в массиве-донноре или такого индекса елемента в массиве донноре не существует?
         //2. елемент который был заменен рандомным числом больше или меньше рандомного числа ?
        int sumFirstArray = ArrayMethods.sumArray(firstArray); // сумма елементов доннора
        int sumSecondArray = ArrayMethods.sumArray(secondArray); // сумма елементов нового массива
        if(sumFirstArray > sumSecondArray){ // выясняем сумма елементов какого массива больше
            int numberWhatWeAreLookingFor = firstArray[randomPlace] - (sumFirstArray-sumSecondArray); // сработает если randomNumber меньше чем число которое он заменяет, приземляясь в массив
            System.out.println("В массив добавлено число -> " + numberWhatWeAreLookingFor + "."); // находим число, которое было добавлено в массив
        } else if (randomPlace < firstArray.length) { //здесь будет true если индекс приземления рандомного числа есть в массиве-донноре
            int numberWhatWeAreLookingFor = firstArray[randomPlace] + (sumSecondArray-sumFirstArray);  // сработает если randomNumber больше чем число которое он заменяет, приземляясь в массив
            System.out.println("В массив добавлено число -> " + numberWhatWeAreLookingFor + "."); // находим число, которое было добавлено в массив
        }else { // сработает если randomNumber приземлился на такой индекс которого нет в старом массиве т.е. на последний индекс, т.к. размер нового массива на 1 больше
            int numberWhatAreWeAreLookingFor = sumSecondArray-sumFirstArray; // находим число, которое было добавлено в массив
        }//end else */


    }//end main
}//end class
