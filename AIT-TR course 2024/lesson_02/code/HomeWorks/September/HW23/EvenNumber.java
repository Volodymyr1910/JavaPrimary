package HW23;

import java.util.Arrays;
import java.util.Collections;

//Заполнить массив четными числами от 0 до 50. 0, 2, 4, 8, ... , 42, 44, 48, 50 Распечатать массив в порядке возрастания, затем в порядке убывания.
public class EvenNumber {
    public static void main(String[] args) {
        int [] evenNumber = new int[52];

        for (int i = 0; i < evenNumber.length; i++) {
            if ((i % 2) == 0){
                evenNumber[i] = i;
                System.out.print(evenNumber[i] + ", ");

            }//end if

        }//end for
        System.out.println();
        for (int i = evenNumber.length-1; i >= 0 ; i--) {
            if ((i % 2) == 0) {
                evenNumber[i] = i;
                System.out.print(evenNumber[i] + ", ");
            }//end if
        }//end for



    }//end main
}//end class
