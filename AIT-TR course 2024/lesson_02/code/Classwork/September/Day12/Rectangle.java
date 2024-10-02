package Day12;

public class Rectangle {
//    Вычислить площадь прямоугольника.
//    Задайте длину и ширину прямоугольника как переменные типа double.
//    Создайте метод, который получает на вход два числа типа double и возвращает тип double площадь прямоугольника
    public static void main(String[] args) {
        double a = 125.37d;
        double b = 35.0;
        //solution 1
        double area = a * b;
        System.out.println("Area of rectangle: " + area);

        //solution 2 with method

        area = areaOfRectangle(a, b);
        System.out.println(area);

    }//end of main

    public static double areaOfRectangle(double x, double y){
        double res = x * y;
        return res;


    }//end of areaOfRectangle



}//end of class
