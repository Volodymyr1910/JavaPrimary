package Day9_lesson20.wrapper_classes_examples;

import java.math.BigInteger;

public class WrapperClassApplication {
    public static void main(String[] args) {

        int k = 1234567890;
        System.out.println(k);
        System.out.println("----------------------------------------------");

        //тип String переганяем в Integer
        Integer integer =  Integer.parseInt("100");
        System.out.println(integer);
        integer = integer + 15;
        System.out.println(integer);
        System.out.println("-----------------------------");

        int value1=123;
        Integer a = new Integer(value1);
        System.out.println(value1);


        System.out.println("---------------Автоупаковка--------------");
        Integer x = 5;
        System.out.println(x * 10);


        System.out.println("---------------Автораспаковка--------------");
        integer = 10;
        int z = x + integer;
        System.out.println(z);

        System.out.println("---------------BigInteger--------------");
        BigInteger myBigInt = new BigInteger("12345678901234567890");
        System.out.println(myBigInt);


        //количество цифр в числе

        int b = 1234567890;
        //перепаковываем int в Integer
        Integer bInt = b;

        //смена типа  c int на String
        String str = bInt.toString();
        int l = str.length();
        System.out.println("Number: " + b + " contains " + l + " digits.");

        String str2 = Integer.toString(b);
        System.out.println(str2.length());

        System.out.println("---------------константы класса Integer--------------");

        System.out.println(" Max value of int:" + bInt.MAX_VALUE);
        System.out.println(" Max value of int:" + bInt.MIN_VALUE);

        Double d = 0.0;
        System.out.println("Max value of double " + d.MAX_VALUE);
        System.out.println("Max value of double " + d.MIN_VALUE);

        System.out.println("---------------mathematic operations--------------");

        int n = 20;
        Integer m = 10;
        m = n + m;
        System.out.println(m);
        n = n + m;
        System.out.println(n + 1);

        Double pi = 3.14;
        double circleLenght = 2 * pi * 10;
        System.out.println(circleLenght);
        System.out.printf("%.2f ",circleLenght);
        System.out.println();

        System.out.println("-----------------------------");
        double p = 20 / 0.0;

        if((Double.isNaN(p)) || Double.isInfinite(p)) {
            System.out.println("Wrong operation, division by Zero.");
        }else System.out.println(p);

        System.out.println("-----------смена типа  c String  на int------------------");
        String str1 = "0098765432100";
        long num = Long.parseLong(str1);
        System.out.println(num);



    }//end main

}//end class
