package Day17;

import java.util.Scanner;

//Родители позволяют ребенку играть на компьютере 1 час.
//  Напишите программу, которая будет реагировать на полученную в школе оценку:
//1. "Молодец!", время для игр на компьютере увеличивается на 30 мин.
//2. "Хорошо", ты можешь играть на компьютере обычные 60 минут.
//3. "Посредственно.", время для игр уменьшается на 30 мин.
//4. "Плохо!", сегодня никаких игр на компьютере.
//5. "Позор семьи!", никаких игр на компьютере 2 дня.
public class ChildTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What grade did you get today?(1, 2, 3, 4, 5)");
        int mark = scanner.nextInt();

        int timeForGame = 60;

        switch (mark){
            case 1 : {
                timeForGame = timeForGame + 30;
                System.out.println("You are handsome !! Time for game today : " + timeForGame + " minutes.");
                break;
            }//end of case 1
            case 2 : {
                System.out.println("Good !! Time for game today : " + timeForGame + " minutes.");
                break;
            }//end of case 2
            case 3 : {
                timeForGame = timeForGame - 30;
                System.out.println("Not so good !! Time for game today : " + timeForGame + " minutes.");
                break;
            }//end of case 3
            case 4 : {
                timeForGame = 0;
                System.out.println("Bad !! Time for game today : " + timeForGame + " minutes.");
                break;
            }//end of case 4
            case 5 : {
                System.out.println("Terrible !! NO games today and tomorrow!!!");
                break;
            }//end of case 5
            default : {
                System.out.println("Wrong input of the grade.");
            }//end of default

        }//end of switch



    }//end of main

}//end of class
