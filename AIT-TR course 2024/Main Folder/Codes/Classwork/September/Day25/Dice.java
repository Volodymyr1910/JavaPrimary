package Day25;

import java.util.Random;

//Смоделируйте бросок игрального кубика 20 раз. Подсчитайте, сколько раз выпала каждая грань?
//Проверьте, равны ли вероятности выпадений граней кубика?
public class Dice {
    public static void main(String[] args) {
        Random random = new Random(); // инициировали обьект, вызвали класс Random в наш класс Dice.


        int[] toss = new int[20];
        //fill in massive toss
        for (int i = 0; i < toss.length; i++) {
            int n = random.nextInt(6) + 1;  // датчик вызывает случайное число в дапазоне от 1 до 6 и кладет его в переменную
            toss[i] = n;
            System.out.print(n + " ");

        }//end for
        System.out.println();
        // calculate results of tossing Вариант 1
        int[] res = new int[6]; // считаем сколько раз выпала каждая грань, шесть граней - значит шесть ответов, т.е. новый массив имеет размер 6
        //fill in massive res и одновременно результат проганяем через switch
        for (int i = 0; i < toss.length; i++) {
            int k = toss[i];
            switch (k) {
                case 1 -> res[0]++;
                case 2 -> res[1]++;
                case 3 -> res[2]++;
                case 4 -> res[3]++;
                case 5 -> res[4]++;
                case 6 -> res[5]++;
            }//end switch

        }//end for
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
            System.out.println();
        }
        /*/как выяснить вероятность выпадения каждой грани
        for (int i = 0; i < res.length; i++) {
            int v = res[i] / 6;
            System.out.println(v + ", ");
        }*/



        /*Вариант 2 посчитать сколько раз выпала каждая грань

        int sum = 0;

        for (int j = 1; j <= 6; j++){
            for (int i = 0; i < toss.length; i++){
                if (toss[i] == j){
                    sum ++;
                 }//end if
           }//end for
        System.out.println(j + " = " + sum);
        sum = 0;
        }//end for */


    }//end main
}//end class

