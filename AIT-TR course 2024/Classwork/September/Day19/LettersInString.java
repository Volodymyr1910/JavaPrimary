package Day19;

import java.util.Scanner;

//import java.util.*; - подтягивает в текущий класс все имеющиеся оперативные классы, * вместо названия класса

//Пользователь вводит с клавиатуры строку.
//Распечатайте каждую букву строки на новой строчке.
//Используйте методы length и charAt() класса String.
public class LettersInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string: ");
        String word = scanner.nextLine();

        System.out.println(word);

        int l = word.length();
        System.out.println(l);
        int count = 0;

        while(count < l){
            System.out.println(word.charAt(count));
            count++;
        }

    }//end main
}//end class
