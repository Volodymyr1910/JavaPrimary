package Day27;

import array_methods.ArrayMethods;

public class BubleSort {
    public static void main(String[] args) {


        //create array with random numbers
        int [] myArray = ArrayMethods.fillArrayRandom(0,100,10);
        //print array before sort
        ArrayMethods.printArray(myArray);
        //sort array
        ArrayMethods.bubleSortFromLowToBig(myArray);
        //print array after sort
        ArrayMethods.printArray(myArray);




    }//end main


}//end class
