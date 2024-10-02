package Day18;
//Возведите 3 в степень 10, выведите на печать все промежуточные результаты.
public class Power {
    public static void main(String[] args) {
        int pow = (int) Math.pow(3, 10); // Math.pow - работает с переменными типа double,
                                         // поэтому (int) показывает что хотим результат в типе int
                                         // casting - преобразование типов
        int count = 0; //параметр цикла
        int res = 1;
        System.out.println(pow);

        while (count < 10){
            res = res * 3; // возведение 3 в степень
            count ++; // изменение параметра цикла
            System.out.println(res + " = 3 in power " + count + ".");

        }//end of while

    }//end of main
}//end of class
