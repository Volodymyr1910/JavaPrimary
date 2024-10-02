package HW20;

import java.util.Scanner;
public class HW20 {

    public static void main(String[] args) {

        //Задача 1. В программе задаются часы, минуты и секунды. Нужно вывести общее количество секунд, прошедших с начала суток.
        // Вычисление произведите в методе, который получает на вход часы, минуты и секунды.
        int h = 5 /* ко-во часов*/, m = 32 /* ко-во минут */, s = 15 /* ко-во секунд */;
        int res = howMuchSeconds(h, m, s);
        System.out.println("From daystart has gone " + res + " seconds.");

        //Задача 2. Написать программу, выводящую на экран максимальное из трех целых чисел. Числа задайте самостоятельно внутри программы.
        // Решите эту задачу с помощью if ... else и также с помощью тернарного оператора.

        int a = 0, b = 64, c = -17;
        // решение с if ... else
        if (a > b) {
            if (a > c) {
                System.out.println("Number " + a + " is the biggest !");
            } else {
                System.out.println("Number " + c + " is the biggest !");
            }//end else
        }//end if ab
        if (b > c) {
            System.out.println("Number " + b + " is the biggest !");
        }//end if bc

        // решение с тернарным оператором

        int max = (a > b) ? a : b;
        int max1 = (max > c) ? max : c;
        System.out.println("Number " + max1 + " is the biggest !");

        //Задача 3. Анна использует различные электроприборы в своем доме. У неё есть холодильник, который потребляет 150 Вт, и кондиционер с потреблением 2000 Вт.
        // Анна хочет узнать, сколько она тратит на электроэнергию в месяц, если стоимость 1 кВт·ч составляет 0.15 евро.
        // Вопросы: Сколько электроэнергии тратят холодильник и кондиционер вместе в час? (calculateHourlyConsumption) Сколько Анна тратит на электроэнергию в месяц? (calculateMonthlyCost)
        int fridge = 150, condition = 2000;
        double cost = 0.15;

        int hc = calculateHourlyConsumption(fridge, condition);
        double mc = calculateMonthlyCost(hc, cost);
        System.out.printf("Anna, you spend %.2f", mc);
        System.out.println(" euro for energy every month !");

        //Задача 4. Написать программу-бот, который помогает выбрасывать мусор в баки разных цветов:
        //
        //упаковки в желтый бак
        //пищевые отходы в коричневый бак
        //бумага в зеленый бак
        //прочие отходы в черный бак Используйте цифры для кодирования вариантов действий.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello ! You want to throw garbage away? y/n:");
        String string = scanner.nextLine();
        if (string.equals("y")) {
            boolean flag = true;
            while (flag) {
                if (string.equals("y")) {
                    System.out.println("What garbage you have?");
                    System.out.println("Press 1 - for old packaging, 2 - for food waste, 3 - for papper, 4 - for other waste: ");
                    int garbage = scanner.nextInt();
                    switch (garbage) {
                        case 1 -> System.out.println("Throw to Yellow container, please.");
                        case 2 -> System.out.println("Throw to Brown container, please.");
                        case 3 -> System.out.println("Throw to Blue container, please.");
                        case 4 -> System.out.println("Throw to Black container, please.");
                    }//end switch garbage
                    System.out.println("Thanks ! Have you more garbage? y/n :");
                    string = scanner.next();
                    if (string.equals("y")) {
                        flag = true;
                    } else {
                        flag = false;
                    }//end if else
                }//end if string second
            }//end while
        }//end if string first
        System.out.println("Ok. Have a nice day !");

        //Задача 5.(*) Программа запрашивает у пользователя количество секунд, прошедших с начала суток. Нужно вывести часы, минуты и секунды. Проверьте, что число введенных пользователем секунд не более 86 400.

        System.out.println("Enter please, how much seconds has gone from daystart:");
        int seconds = scanner.nextInt();
        if (seconds<=86400){
            int hours = seconds / 3600;
            int minutes = (seconds - (hours * 3600)) / 60;
            int finalSeconds = seconds - minutes * 60 - hours * 3600;
            System.out.println(seconds + " seconds has gone from daystart. It means " + hours + "h:" + minutes + "m:" + finalSeconds + "s.");
        }else{
            System.out.println("Wrong input. Bye!");//end if seconds
        }//end else

    }//end main

    private static int howMuchSeconds(int h, int m, int s) {    // метод к задаче 1
        return h * 3600 + m * 60 + s;
    }//end howMuchSeconds

    private static int calculateHourlyConsumption(int fridge, int condition) {    // метод к задаче 3
        return fridge + condition;
    }//end calculateHourlyConsumption

    private static double calculateMonthlyCost(double hc, double cost) {    // метод к задаче 3
        return ((hc * 24 * 30) / 1000) * cost;
    }//end calculateMonthlyCost


}// end class
