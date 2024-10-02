package Day19;



import java.util.Scanner;

//Пользователь вводит натуральное число n. Определите, является ли оно простым.
//Простое число - это такое число, которое делится **ТОЛЬКО** на себя и на 1.
//Примеры: 2, 3, 5, 7, 11, 13, 17, 19, ...
//Обеспечьте защиту от ввода пользователем отрицательных чисел.
// 31, 37,
// 51, 53, 57, 59,
public class PrimeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer positive number, please: ");
        int  number = scanner.nextInt();

        //check correct number
        while (number <= 0 ){
            System.out.println("Your number is wrong ! Try again.");
            number = scanner.nextInt();
        }//end while number


        boolean isPrime = isPrimeNumber(number);
        System.out.println(number + " is prime " + isPrime);

    }//end main

    private static boolean isPrimeNumber (int number){
        int div = 2;
        while (div < number ){
            if(number % div == 0){
                return false;
            }//end if
            div++;
        }//end while div
        return true;
    }//end isPrimeNumber

}//end class
