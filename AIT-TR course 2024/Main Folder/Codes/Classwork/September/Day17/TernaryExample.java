package Day17;

import java.util.Scanner;


//В программе задаются два целых числа.
//  Найдите минимальное из них с помощью тернарного оператора.
//  Дополните программу возможностью ввода чисел пользователем.
public class TernaryExample {
    public static void main(String[] args) {
        int a = 500;
        int b = 200;

        int min = (a < b) ? a : b;

        System.out.println("Min = " + min);

        int max = (a > b) ? a : b;
        System.out.println("Max = " + max);

        //input data
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number, please:");
        a = scanner.nextInt();
        System.out.println("Enter second number, please:");
        b = scanner.nextInt();


        min = min(a,b);
        System.out.println("Min = " + min);

        String str = scanner.nextLine(); // команда ожидающая ввода от пользователя строки данных, до нажатия enter

    }//end of main
    public static int min(int a, int b){
        return (a < b) ? a : b;
    }//end of min


}//end of class
