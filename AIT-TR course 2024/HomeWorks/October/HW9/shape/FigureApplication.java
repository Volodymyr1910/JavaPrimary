package HW9.shape;

import HW9.shape.model.Circle;
import HW9.shape.model.Shape;
import HW9.shape.model.Square;
import HW9.shape.model.Triangle;

//Задача 4.(*)
//
//Создайте абстрактный класс Shape с типом поля double (одно) и абстрактными методами calcArea и calcPerimeter.
//Создать классы Circle, Triangle, Square, расширяющие класс Shape и реализующие абстрактные методы.
//Напишите класс FigureAppl с методом main. В методе создайте массив фигур. Добавьте в массив два круга, один треугольник и один квадрат. Рассчитайте общую площадь и общий периметр всех фигур из массива фигур.
//Задача 5.(*) Рассчитайте общую площадь кругов из задачи 2.
public class FigureApplication {

    public static void main(String[] args) {

        Shape figureArray [] = new Shape[4];

        Circle circle1 = new Circle(0,2);
        Circle circle2 = new Circle(0,2);
        Triangle triangle = new Triangle(0, 6, 14, 18);
        Square square = new Square(0,4.5);

        figureArray[0] = circle1;
        figureArray[1] = circle2;
        figureArray[2] = triangle;
        figureArray[3] = square;

        // находим сумму площадей всех кругов в массиве, сумму периметров всех фигур массива и сумму площадей всех фигур массива

        double sumOfCirclesSquares = 0;
        double sumOfTrianglesSquares = 0;
        double sumOfSquareSquares = 0;

        double sumOfCirclesPerimeters = 0;
        double sumOfTrianglesPerimeters = 0;
        double sumOfSquarePerimeters = 0;


        for (int i = 0; i < figureArray.length; i++) {
            if(figureArray[i] instanceof Circle){
                sumOfCirclesSquares += Circle.calcArea(((Circle) figureArray[i]).getR());
                sumOfCirclesPerimeters += Circle.calcPerimeter(((Circle) figureArray[i]).getR());
            } else if (figureArray[i] instanceof Triangle) {
                sumOfTrianglesSquares += Triangle.calcArea((((Triangle) figureArray[i]).getA()), (((Triangle) figureArray[i]).getB()), (((Triangle) figureArray[i]).getC()));
                sumOfTrianglesPerimeters += Triangle.calcPerimeter((((Triangle) figureArray[i]).getA()), (((Triangle) figureArray[i]).getB()), (((Triangle) figureArray[i]).getC()));
            } else if (figureArray[i] instanceof Square) {
                sumOfSquareSquares += Square.calcArea(((Square) figureArray[i]).getA());
                sumOfSquarePerimeters += Square.calcPerimeter(((Square) figureArray[i]).getA());
            } //end else
        }//end for
        System.out.printf("Total of squares our circles -> %.2f", sumOfCirclesSquares);
        System.out.println();
        double sumOfSquares = sumOfCirclesSquares + sumOfSquareSquares + sumOfTrianglesSquares;
        double sumOfPerimeters = sumOfCirclesPerimeters + sumOfSquarePerimeters + sumOfTrianglesPerimeters;

        System.out.printf("Total perimeter value of all figures in array is -> %.2f", sumOfPerimeters);
        System.out.println();
        System.out.printf("Total square value of all figures in array is -> %.2f", sumOfSquares);
        System.out.println();
    }//end main

}//end class

