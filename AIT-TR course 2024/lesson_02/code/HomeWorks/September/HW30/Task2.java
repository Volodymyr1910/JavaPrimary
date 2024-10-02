package HW30;
//Задание 2. Напишите программу, которая запрашивает строку от пользователя и затем:
//сообщает сколько слов в строке
//сообщает сколько букв (символов) в строке
//печатает строку задом наперед, начиная с последнего слова.

import array_methods.ArrayMethods;
import array_methods.ArrayMethods_String;

import java.util.Arrays;
import java.util.Scanner;

//почему метод реверса, разделяет запятыми и ставит квадратные скобки

public class Task2 {
    public static void main(String[] args) {
        
       /// I'm learning in AIT school! Programming - is my future!!!
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your sentence, please: "); // получаем строку от юзера
        String userSentence = scanner.nextLine();

        String words [] = userSentence.split(" "); // убираем пробелы и заполняем массив словами
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }//end for
        System.out.println();
        int numberOfWords = words.length; // находим ко-во елементов в массиве и ко-во символов в строке
        int numberOfLetters = userSentence.length();
        System.out.println("We have " + numberOfWords + " words, and " + numberOfLetters + " letters in our sentence." );
        System.out.println("---------");

        String [] newStringArray = new String[words.length]; //вызываем метод переносящий елементы текущего массива в новый - с разворотом
        newStringArray = ArrayMethods_String.transferFromOneArrayToAnotherWithTurnAroundString(words,newStringArray);
        ArrayMethods_String.printArrayString(newStringArray); //метод который печатает массив String
        System.out.println("------------");

        newStringArray = ArrayMethods_String.reverseArrayString(newStringArray); //вызываем метод делающий реверс символов каждого елемента текущего массива и кладет  в новый
        ArrayMethods_String.printArrayString(newStringArray); //метод который печатает массив String

    }//end main
}//end class
