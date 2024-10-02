package HW17;

import java.util.Scanner;

public class HomeWork17 {

    public static void main(String[] args) {

        ///программa расчета выдачи денег работнику с учётом надбавки за стаж
        double basicPramie = 500;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much years You are working? Enter, please full number, by example: 7, 16, or 38");
        int workExperience = scanner.nextInt ();

        if (workExperience < 3){
            double extraPramie = 0;
            System.out.println("Bonus for your working expirience is: 0%. Your extra pramie is: " + extraPramie + "Euro. Total is: " + basicPramie + "Euro." );
        } else if (workExperience >= 3 & workExperience < 5) {
            double extraPramie = basicPramie + basicPramie*0.1;
            System.out.println("Bonus for your working expirience is: 10%. Your extra pramie is: " + basicPramie*0.1 + "Euro. Total is: " + extraPramie + "Euro." );
        }else if (workExperience >= 5 & workExperience < 10) {
            double extraPramie = basicPramie + basicPramie * 0.5;
            System.out.println("Bonus for your working expirience is: 50%. Your extra pramie is: " + basicPramie * 0.5 + "Euro. Total is: " + extraPramie + "Euro." );
        }else if (workExperience > 9 & workExperience < 15) {
            double extraPramie = basicPramie * 2;
            System.out.println("Bonus for your working expirience is: 100%. Your extra pramie is: " + basicPramie + "Euro. Total is: " + extraPramie + "Euro." );
        }else if (workExperience > 14) {
            double extraPramie = basicPramie + basicPramie * 1.5;
            System.out.println("Bonus for your working expirience is: 150%. Your extra pramie is: " + basicPramie * 1.5 + "Euro. Total is: " + extraPramie + "Euro." );
        }//end of else

        //программа сообщает, какому времени года принадлежит введенный месяц.
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter a number of month, from 1 to 12, please: ");
        int monthNumber = scanner2.nextInt ();

        if (monthNumber >=3 & monthNumber < 6){
            System.out.println("Your month is springmonth!");
        } else if (monthNumber >=6 & monthNumber < 9){
            System.out.println("Your month is summermonth!");
        }else if (monthNumber >=9 & monthNumber < 12){
            System.out.println("Your month is autumnmonth!");
        }else if (monthNumber == 12 || monthNumber < 3) {
            System.out.println("Your month is wintermonth!");
        }

        //cветофор задается в программе
        int greenLight = 1;
        int yellowLight = 2;
        int redLight = 3;
        int trafficLights = 1;
        if (trafficLights == greenLight){
            System.out.println("You must Drive ! Green Light! GO GO GO !!!");
        } else if (trafficLights == yellowLight){
            System.out.println("You must Wait ! You can't drive on yellow ! Get ready in waiting for green light !");
        }else if (trafficLights == redLight) {
            System.out.println("You must Stop ! You can't drive on red and yellow ! Get ready in waiting for green light !");

        }else {
            System.out.println("The trafficlights is broken ! Follow the road signs !");
        }
        //cветофор задается с клавиатуры.
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Choose the color of trafficlights : 1, 2, or 3, where 1 - is green, 2 - is yellow, and 3 - is red.");
        trafficLights= scanner3.nextInt();
        switch (trafficLights){
            case 1 ->System.out.println("You must Drive ! Green Light! GO GO GO !!!");
            case 2 -> System.out.println("You must Wait ! You can't drive on yellow ! Get ready in waiting for green light !");
            case 3 -> System.out.println("You must Stop ! You can't drive on red and yellow ! Get ready in waiting for green light !");
            default -> System.out.println("The trafficlights is broken ! Follow the road signs !");
        }//end of switch


        //Написать приложение - калькулятор для работы с целыми числами: oper 1 => + oper 2 => - oper 3 => *, oper 4 => /, oper 5 => % , other print "Wrong operation".
        // Числа и требуемая операция вводятся с клавиатуры.
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Enter the first number, please:");
        double number1 = scanner4.nextInt();
        System.out.println("Enter the second number, please:");
        double number2 = scanner4.nextInt();

        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Thank You! What operation you want to do ? Enter, please 1 - for addition, 2 - for subtaction, 3 - for multiplication or 4 - for division:");
        int oper = scanner5.nextInt();

        switch (oper){
            case 1 : {
                double res = number1 + number2;
                System.out.println("Ok. Entered numbers: " + number1 + " and " + number2 + ". Result of addition operation is: " + res + ".");
                break;
            }
            case 2 : {
                double res = number1 - number2;
                System.out.println("Ok. Entered numbers: " + number1 + " and " + number2 + ". Result of subtaction operation is: " + res + ".");
                break;
            }
            case 3 : {
                double res = number1 * number2;
                System.out.println("Ok. Entered numbers: " + number1 + " and " + number2 + ". Result of multiplication operation is: " + res + ".");
                break;
            }
            case 4 : {
                double res = number1 / number2;
                System.out.println("Ok. Entered numbers: " + number1 + " and " + number2 + ".");
                System.out.printf("Result of division operation is: %.2f",res);
                System.out.println(".");
                break;
            }
            default:{
                System.out.println("You make a wrong choise. Operation isn't possible.");
            }
        }//end of switch


    }//end of main

}//end of class
