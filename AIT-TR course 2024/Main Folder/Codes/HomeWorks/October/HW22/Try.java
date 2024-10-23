package HW22;

import MyMethods.array_methods.ArrayMethods;

public class Try extends OddEvenComparator {

    public static void main(String[] args) {

        int[] array = {2, 5, 6, 10, 11, 18, 3};

        new OddEvenComparator(array);
        ArrayMethods.printArray(array);

    }
}
