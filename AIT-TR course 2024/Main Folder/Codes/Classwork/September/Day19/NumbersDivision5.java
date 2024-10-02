package Day19;
//Распечатать в консоли все числа от 1 до 100, которые делятся на 5 без остатка.
public class NumbersDivision5 {
    public static void main(String[] args) {

        int i = 1; //параметр цикла
        int y =101;

        while (i < y ){
            //System.out.print(" " + i);
            i++;
            if (i % 7 == 0){
                System.out.print(" " + i);
            }//end if
        }//end while

    }//end main

}//end class
