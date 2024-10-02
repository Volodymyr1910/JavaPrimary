package HW2;

import java.util.Scanner;
//Задача 2. Вводится n - натуральное число. Напишите метод, который получает на вход n и вычисляет n! = 1 * 2 * 3 *... * n.
// Вызовите полученный метод. При каком значении n происходит переполнение памяти (результат станет отрицательным), выделяемой для значения n! типа int? Использовать цикл for.
//готовый код по этой задаче есть в кодах урока 13
public class NeedToBeDone {
    public static void main(String[] args) {
         /*//=====на развитие======= Задача 3(*). Написать метод, принимающий на вход массив строк. Метод должен вернуть массив,
            // состоящий из самой короткой и самой длинной строки изначального массива. Создайте массив типа String и заполните его названиями знакомых вам городов.
            // Проверьте работу написанного метода на этом массиве.
            String [] cities1 = {"aaa","aa","aa","aaa","a"};
            //String [] cities = {"Мюнхен","Лейпциг","Кьольн","Берлін","Херсон","Одеса","Миколаїв","Магдебург","Ерфурт", "Дрезден"};
            String max="a";
            String min ="a";
            for (int i = 0; i < cities1.length; i++) {
                cities1[i] = cities1[i];
                if(cities1[i]>max){
                    max = cities1[i];
                }//end if
                if(cities1[i]< min){
                    min = cities1[i];
                }//end if
            }//end for */

        //Задача 1. Составьте программу, которая вычисляет сумму чисел от 1 до 1/n, n вводится с клавиатуры.
        // Пример: n = 10 sum = 1 + 1/2 + 1/3 + ... + 1/10 Использовать цикл for.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter positive number, please: ");
        int n = scanner.nextInt();

        int number = 1;
        double temp = 0;
        for (int i = number; i <= n; i++) {
            temp = i % n;
            System.out.print(temp + " ");
                /*sum = sum + 1 / n;
                System.out.print("Sum = " + sum + " + ");
                if(sum < 0) {
                    i = n;
                }//end if*/

        }//end for
        System.out.println();





    }//end main
}//end class
