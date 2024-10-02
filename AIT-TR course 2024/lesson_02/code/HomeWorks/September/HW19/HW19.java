package HW19;

import java.util.Scanner;

public class HW19 {

    //Задача 5. (*) Напечатайте на экране шахматную доску размером 8х8. 0 - белая клеточка, 1 - черная. Левая верхняя клеточка должна быть 0, левая нижняя - 1.
    public static void main(String[] args) {

        //Задача 1. Чему равно значение выражения x-- + --x при x = 5? Проверьте свое предположение с помощью кода.
        int x = 5, res = 0, startX = 1, y = 200;

        while (res <= 20) {
            int i = x-- + --x;
            res++;
            System.out.print(i + ", ");
        }//end while res

        //Задача 2. Распечатайте все натуральные числа меньшие 200 и кратные 13. Используйте циклы while и do while.
        x = startX;
        System.out.println();
        System.out.println("Numbers from " + startX + " to " + y + " multiple of 13 is : ");
        while (x < y) {
            if (x % 13 == 0) {
                System.out.print(x + ", ");
            }//end if x
            x++;
        }//end while x

        //Задача 3. Определение времени суток. Напишите программу, которая принимает на вход текущий час (от 0 до 23),
        // и выводит приветствие в зависимости от времени суток (утро, день, вечер, ночь).
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("How much hours on clock, now ? (24h format)");
         x = scanner.nextInt();

        if ((x > 1) & (x < 4)) {
            System.out.println(x + " hours on clock?! . It's night. Go sleep !");
        } else if ((x > 3) & (x < 11)) {
            System.out.println(x + " hours on clock?! . Good morning ! Cofee is waiting !");
        } else if ((x > 10) & (x < 18)) {
            System.out.println(x + " hours on clock?! . It's Day now. You must do your job, pal :)");
        } else {
            System.out.println(x + " hours on clock?! . Evening, at last ! Your time has come, do what you want.)");
        }
    }//end main
}//end class
