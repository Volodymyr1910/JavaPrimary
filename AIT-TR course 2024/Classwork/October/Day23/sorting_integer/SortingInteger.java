package Day23.sorting_integer;

import java.util.Arrays;

public class SortingInteger {

    public static void main(String[] args) {

        Integer[] numbers = {

                -100, 2,
                Integer.MAX_VALUE, 2, 15, 35,
                Integer.MIN_VALUE, 71


        };
        // пример служебной печати или draft print
        System.out.println("----------------sort по возрастанию----------------");
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        System.out.println("----------------sort в обратном порядке, т.е. по убыванию----------------");
        Arrays.sort(numbers, (n1, n2) -> Integer.compare(n2, n1));
        System.out.println(Arrays.toString(numbers));

        //for each
        System.out.println("---------------- печать с помощью for each----------------");
        int index = 0;
        for (Integer k : numbers) { // в данном примере k это обьект, и ему доступно много методов
            System.out.print(k + " " + index + " | ");
            index++;
        }//end for
        System.out.println();


    }//end main


}//end class
