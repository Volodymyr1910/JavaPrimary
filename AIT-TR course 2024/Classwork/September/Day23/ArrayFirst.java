package Day23;
//**Задача 1.**
//Создайте массив и заполните его целыми числами от 1 до 20.
public class ArrayFirst {
    public static void main(String[] args) {

        int[] numbers = new int[20]; // size 20, indexes from 0 till 19
        // numbers[0] - first element of array
        // numbers[19] - last element of array
        // numbers[numbers.lenght -1] - обращение к последнему елементу массива
        //numbers.lenght = 20

        //fill numbers in to array
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; //в этом случае индексі лягут в массив,  индексы будут совпадать с елементами массива
            System.out.print(numbers[i] + ", ");

        }//end for i

        //print array numbers
        //for (int i = 0; i < numbers.length; i++) {
           // System.out.print(numbers[i] + ", ");
        //}//end for i

        System.out.println();
        System.out.println(numbers); // ссылка на то место где храниться наш массив в оперативной памяти компьютера
    }//end main


}//end class
