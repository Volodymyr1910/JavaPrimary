package day16;
/*Проверка положительное или отрицательное число.
Проверка четное или нечетное целое число.
Проверка возраста. Если пользователю 18 лет и менее, то сообщить "Вам надо
прийти вместе с вашим опекуном", иначе сообщить "Вам разрешено действовать самостоятельно".*/
    public class ConditionEx {
    public static void main(String[] args) {
        int x = 19;
        if ( x > 0 ){
            System.out.println("Число " + x + " більше нуля.");
        }//end of if

        if (x<0) {
            System.out.println("Число " + x + " меньше нуля.");
        }//end of if

        x = -88;

        if(x >= 0){
            System.out.println("Число " + x + " більше нуля.");
        }else {
            System.out.println("Число " + x + " меньше нуля.");
        }//end of else

        x=112;

        if (x % 2 == 0){
            System.out.println("Number " + x + " is even.");;
        }else{
            System.out.println("Number " + x + " is odd.");
        }//end  of else

        int age = 12;
        if(age<18){
            System.out.println("Your age " + age + " is too low. Come back with your parents.");
        }else{
            System.out.println("Your age " + age + " is ok. You can go futher.");
        }//end of else

         /* **Задание 2:**
    Объявите две переменные целого типа a и b и присвойте им произвольные значения натуральных чисел.
    Создайте третью переменную res и выведите ее значение на экран таким образом:
    Если a = b, то res будет равно (a + b) * 5 a если нет, то (a - b) * 5.*/

        int a = 10;
        int b = 20;
        int res;
        if(a == b ){
            res = (a+b)*5;
            System.out.println("Numbers " + a + " and " + b + " is equal. Result is " +  res + ".");
        } else if (a > b) {
            res = (a-b) * 5;
            System.out.println(a + " is bigger than " + b + ".Result is " +  res + ".");
        }else {
            res = (a-b) * 5;
            System.out.println(a + " is less than " + b + ".Result is " +  res + ".");
        }//end of else

        // **Задание 3.** Написать метод, возвращающий максимальное из двух целых чисел.
        //Реализовать метод, который возвращает максимальное из трех целых чисел. Числа задаются в программе.
        //Написать метод, возвращающий максимальное из двух целых чисел, использовать тернарный оператор. */

        int c = 45;
        int v = 34;
        int max = theBiggestNumber(c,v);
        System.out.println("We have two numbers: " + a + " and " + b + ". " + max + " is bigger.");



    }//end of main
    private static int theBiggestNumber (int a, int b){
        int max = 0;
        if (a >= b ){
           max = a;
        }else {
            max = b;
        }
        return max;
    }// end of theBiggestNumber




}//end of class
