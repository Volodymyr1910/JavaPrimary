package HW23;

//Создайте массив из 20 целых чисел в интервале от 10 до 30. Выведите массив на печать.
// Поменяйте местами первый и последний элементы массива и снова выведите массив на печать.
public class Number {
    public static void main(String[] args) {

        int[] numbers = new int[30];

        for (int i = 10; i < numbers.length; i++) {
            numbers[i] = i;
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
        int[] numbers1 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};

        for (int i = 0; i < numbers1.length; i++) {
            System.out.print(numbers1[i] + ", ");
        }
        System.out.println();
        int temp = numbers1[numbers1.length-1];
        numbers1[numbers1.length-1] = numbers1[0];
        numbers1[0] = temp;
        for (int i = 0; i < numbers1.length; i++) {
            System.out.print(numbers1[i] + " ");
        }//end for

    }//end main

    /*int[] numbers = new int[30];

        for(int i = 10;i<numbers.length;i++)

    {
        numbers[i] = i;
        System.out.print(numbers[i] + ", ");
    }
        System.out.println();
    int[] numbers1 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};

        for(
    int i = 0;
    i<numbers1.length;i++)

    {
        numbers1[i] = i;
        System.out.print(numbers1[i] + ", ");
    }

    int temp = numbers1[0];
    numbers1[0]=numbers1[numbers1.length -1];
    numbers1[numbers1.length -1]=temp;
        System.out.println();
        for(
    int i = numbers1.length - 1;
    i >=0;i--)

    {
        numbers1[i] = i;
        System.out.print(numbers1[i] + ", ");
    }*/


}//end class
