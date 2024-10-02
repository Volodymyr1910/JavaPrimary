package HW27;

import array_methods.ArrayMethods;

import java.util.Random;

//Задача 2. Задача про поиск "счастливого пельменя". Хозяйка налепила для гостей 30 пельменей.
// В один из пельменей она положила монету, которая увеличивает вес пельменя на 15 грамм.
// Напишите программу, которая ищет счастливый пельмень.
public class Lucky {
    public static void main(String[] args) {
        Random random = new Random();
        int pelmenweight = 20;
        int potSize = 30; // размео кастрюли
        int pot[] = ArrayMethods.fillArrayAllElementsAreEqual(potSize, 20); // кладем пельмени в кастрюлю
        //ArrayMethods.printArray(pot);
        int randomPlaceInPot = random.nextInt(potSize); // выбираем случайный пельмень из кастрюли
        //System.out.println(randomPlaceInPot);
        pot[randomPlaceInPot] = 15 + pelmenweight; // кладем монетку в случайный пельмень
        int founded = (findLucky(pot)) + 1; // результат работы метода, который ищет индекс счастливого пельменя
        //ArrayMethods.printArray(pot);
        System.out.println("Гость № " + (founded) + " нашeл счастливый пельмень !!!");

    }//end main

    private static int findLucky(int pot[]) {
        int hereYouAre = 0;
        for (int i = 0; i < pot.length; i++) {
            if (i > 0) {
                if (pot[i] < pot[i - 1]) {
                    hereYouAre = i-1;
                    i = pot.length-1;
                }else{
                    hereYouAre = i;
                }//end else
            }//end if
        }//end for
        return hereYouAre;
    }
}//end class
