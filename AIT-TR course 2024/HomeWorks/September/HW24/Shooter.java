package HW24;

import java.util.Random;

public class Shooter {
    //Задача 2
//У стрелка есть 10 попыток поразить мишень. Смоделируйте 10 выстрелов с помощью датчика случайных чисел.
// Ответьте на вопрос, сколько очков набрал стрелок? Попал ли он хоть раз в центр мишени?
//
    public static void main(String[] args) {
        Random random = new Random();

        int []shooter = new int [10];
        int sum = 0;
        int center = 5; // center of the target
        int milk = 0; // not in target
        int centerTime = 0; // number of shots to target center
        int milkTime = 0; // number of shots passt the target


        for (int i = 0; i < shooter.length; i++) {
            shooter[i] = random.nextInt(6);
            sum = sum + shooter[i];
                if(shooter[i] == center){
                    centerTime++;
                } else if (shooter[i] == milk) {
                    milkTime++;
                } //end else

        }//end for
        System.out.println("Shooter did 10 shots. First shot in to ->  " + shooter[0] + ".");
        System.out.println("2nd -> " + shooter[1] + ", 3rd -> " + shooter[2] + ", 4th -> " + shooter[3] + ", 5th -> " + shooter[4] + ".");
        System.out.println("6th -> " + shooter[5] + ", 7th -> " + shooter[6] + ", 8th -> " + shooter[7] + ", 9th -> " + shooter[8] + ".");
        System.out.println("The last shot in to -> " + shooter[9] + ".");
        System.out.println("Total score is " + sum + ".");
        System.out.println("Number of clean shots -> " + centerTime + ", number of empty shots -> " + milkTime + ".");
    }//end main
}//end class
