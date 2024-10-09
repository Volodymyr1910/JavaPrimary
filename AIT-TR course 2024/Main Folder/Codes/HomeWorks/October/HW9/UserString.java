package HW9;

import MyMethods.string_methods.StringMethods;

import java.util.Scanner;

////Задание 2. Разработайте приложение, которое принимает от пользователя строку (некое предложение, например: "Мама мыла раму.") и выводит:
////
////количество символов в строке;
////количество символов в верхнем регистре;
////количество цифр в строке;
////количество пробелов в строке;
////в зависимости от последнего символа в строке сообщает, какое это предложение:
////повествовательное;
////вопросительное;
////восклицательное. Используйте методы класса Character.
public class UserString {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string, please: ");
        String userSentence = scanner.nextLine();

        //String userSentence =  "I love programming 100 TIMES every day !!!";

        System.out.println("The number of symbols in your string is -> " + userSentence.length() + ".");
        System.out.println("The number of capital letters in your string is -> " + StringMethods.howMuchUpperCaseLettersInString(userSentence) + ".");
        System.out.println("The number of digits in your string is -> " + StringMethods.howMuchDigitsInString(userSentence) + ".");
        System.out.println("The number of spaces in your string is -> " + StringMethods.howMuchSelectedElementsInString(userSentence," ") + ".");

        switch (userSentence.charAt(userSentence.length()-1)){
            case '!' -> System.out.println("Your sentence is exclamatory.");
            case '?' -> System.out.println("Your sentence is interrogative.");
            default -> System.out.println("Your sentence is affermative.");
        }//end switch


    }//end main


}//end class
