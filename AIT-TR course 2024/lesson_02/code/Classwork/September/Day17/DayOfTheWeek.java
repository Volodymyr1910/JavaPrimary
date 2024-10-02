package Day17;

import java.util.Scanner;

//Написать программу, которая по введенной цифре от 1 до 7 определяет день недели.
//Второй вариант - на цифры от 1 до 5 программа сообщает, что это будний день, а на 6 и 7, что это выходной.
public class DayOfTheWeek {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number of the day, please:");
        int weekDay = scanner.nextInt();

        switch (weekDay){
            case 1 ->
                System.out.println("This is Monday!");
            case 2 ->
                System.out.println("This is Tuesday!");
            case 3 ->
                System.out.println("This is Wednesday!");
            case 4 ->
                System.out.println("This is Thoursday!");
            case 5 ->
                System.out.println("This is Friday!");
            case 6 ->
                System.out.println("This is Saturday!");
            case 7 ->
                System.out.println("This is Sunday!");
            //end of case 1
            default -> System.out.println("Wrong input !");
        }//end of switch

        switch (weekDay){
            case 1, 2, 3, 4, 5 ->
                System.out.println("This is  a working day.");
            case 6, 7 ->
                System.out.println("This is a Weekend.");
            //default -> System.out.println("Wrong input !");

        }//end of switch 2

    }//end of main


}//end of class
