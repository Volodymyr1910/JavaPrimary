package Day12;

import static java.lang.Math.PI;

public class Circle {
//    Вычислить длину окружности по ее радиусу.
//    Задайте радиус окружности как переменную типа double.
//    Реализуйте метод, который вернет тип double и вычислит длину окружности по ее радиусу.
    public static void main(String[] args) {
        double PI = 3.14159;
        double r = 100;

        double lengthOfCircle = 2 * PI * r;
        System.out.println("Радіус кола: " + lengthOfCircle);

        //solution with method

        double l = lengthOfCircleMethod(r);
        System.out.println("Length of Circle with radius " + r + " = " + l);
    }//end of main

    private static double lengthOfCircleMethod(double r) {
        return 2 * PI * r;


    }//end of lengthOfCircleMethod


}//end of class
