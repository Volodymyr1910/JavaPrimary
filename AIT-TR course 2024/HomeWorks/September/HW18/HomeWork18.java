package HW18;

import java.util.Scanner;

public class HomeWork18 {
    public static void main(String[] args)
    {
        //Возведите 5 в степень 8, выведите на печать все промежуточные результаты.

        int startNumber = 5;
        //int number = (int) Math.pow(5, 8); // можно включить для самоконтроля
        //int finalNumber = number; // можно включить для самоконтроля
        int power = 1;
        int res = 1;
        //System.out.println("Our result is: " + number + "."); // можно включить для самоконтроля

        while (power <= 8){
            res = res * 5;
            System.out.println("Number " + startNumber + " in power " + power + " is equal: " + res);
            power ++;
        }
        System.out.println("We are finished !");

        //Выясните, сколько цифр в числе 254 789

        startNumber = 254789;
        int number = startNumber;

        int count = 0;

        while (number > 0 ){
            number = number / 10;
           count++;
        }
        System.out.println("In number " + startNumber + " we have " + count + " digits.");

        //Задача 1. Программа получает на вход строку и число повторений этой строки. Программа должна вывести эту строку нужное количество раз.
        // Пример: строка - молоко, кол-во раз 3 молоко молоко молоко

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inter what you wish for yourself ! Happiness, for example..");
        String str = scanner.nextLine();
        System.out.println("How many times you want to get it? Enter a number, please: ");
        int quantity = scanner.nextInt();
        count = 0;

        while (count < quantity){
            System.out.println("I wish " + str + " to you !!!");
            count++;
        }

        //Задача 3. В первый день спортсмен пробежал s километров, а затем он каждый день увеличивал пробег на 10 % от предыдущего значения.
        // Определите номер того дня, на который пробег спортсмена составит не менее target километров.
        // Программа получает на вход действительные числа s и target и должна вывести одно натуральное число.

        double s = 3;
        int day = 1;
        int target = 45;

        while (s < target){
            s = s+s*0.1;
            day++;

        }//end while
        System.out.printf("Congratulations !!! You have ran  %.0f", s);
        System.out.println(" kilomiters on " + day + " day !");

        //Задача 4. (*) Вводится шестизначное число (номер автобусного билета).
        // Определите, является ли этот билет "счастливым" (сумма первых трех цифр равна сумме трех последних цифр).

        String busTicketNumber = "121121";
        String zeroSymbol = String.valueOf(busTicketNumber.charAt(0));
        int zero = Integer.parseInt(zeroSymbol);
        String firstSymbol = String.valueOf(busTicketNumber.charAt(1));
        int first = Integer.parseInt(firstSymbol);
        String secondSymbol = String.valueOf(busTicketNumber.charAt(2));
        int second = Integer.parseInt(secondSymbol);
        String thirdSymbol = String.valueOf(busTicketNumber.charAt(3));
        int third = Integer.parseInt(thirdSymbol);
        String fourthSymbol = String.valueOf(busTicketNumber.charAt(4));
        int fourth = Integer.parseInt(fourthSymbol);
        String fifthSymbol = String.valueOf(busTicketNumber.charAt(5));
        int fifth = Integer.parseInt(fifthSymbol);
       res = zero + first + second;
       int res2 = third + fourth + fifth;

       if (res == res2){
           System.out.println("You have a lucky bus ticket !");
       }else System.out.println("Your ticket is regular.");





    }//end main

}//end class
