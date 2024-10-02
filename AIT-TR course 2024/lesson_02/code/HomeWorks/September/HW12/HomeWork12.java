package HW12;

public class HomeWork12 {
    /*Метод вычисляющий площадь квадрата по его стороне;
    Метод вычисляющий площадь круга по его радиусу;
    Метод вычисляющий периметр прямоугольника по двум сторонам; В методе main вызвать вышеуказанные методы с различными аргументами, и результаты вывести в консоль. Например:
    площадь круга для R = 200 равна ...
    площадь квадрата со стороной 500 составляет ...
    периметр прямоугольника со сторонами 1000 и 2000 равен ...
    Добавить методы, вычисляющие (*)
Величину 3-го угла треугольника по известным первым двум.
Площадь треугольника по стороне и высоте треугольника.
Гипотенузу по двум катетам (теорема Пифагора).*/
    public static void main(String[] args) {
        double a = 12; //Введіть величину сторони квадрата
        double r = 18; //Введіть величину радіусу кола
        double PI = 3.14; //Введіть величину константи РІ
        double b = 19; //Введіть величину першої сторони прямокутника
        double c = 10; //Введіть величину другої сторони прямокутника



        double s = areaOfSquare(a); // вказує що результати розрахунку в методі areaOfSquare повернути в цю строку
        System.out.println("Square's sidesize is " + a + ". Square area = " + s + "."); // Виведення на консоль результату розрахунку площі квадрата

        double ss = areaOfCircle(r,PI); // вказує що результати розрахунку в методі areaOfCircle повернути в цю строку
        System.out.println("Circle's radius is " + r + ". Circle area  = " + ss + "."); // Виведення на консоль результату розрахунку площі кола

        double p = perimetrOfRectangle(b,c); // вказує що результати розрахунку в методі perimetrOfRectangle повернути в цю строку
        System.out.println("Rectangle's sides is " + b + " and " + c + ". Perimetr of this Rectagle = " + p + "."); // Виведення на консоль результату розрахунку периметру прямокутника

        System.out.println("Додаткові завдання.");

        double ab = 50; //Введіть величину першого кута трикутника
        double bc = 78; //Введіть величину другого кута трикутника

        double ac = thirdTriangleCorner(ab, bc); // вказує що результати розрахунку в методі thirdTriangleCorner повернути в цю строку
        System.out.println("Triangle has two known angles: " + ab + " and " + bc + ". The third angle is: " + ac + "."); // Виведення на консоль результату розрахунку третього кута трикутника

        double aa = 25; //Введіть величину сторони трикутника
        double h = 15; //Введіть величину висоти трикутника

        s = triangleSquare(aa, h); // вказує що результати розрахунку в методі triangleSquare повернути в цю строку
        System.out.println("Triangle has side " + aa + " and height " + h + ". Triangle square is " + s + "."); // Виведення на консоль результату розрахунку площі трикутника

        double k1 = 2; //Введіть величину першого катета
        double k2 = 4; //Введіть величину другого катета

        double g = gipotenuza(k1, k2); // вказує що результати розрахунку в методі gipotenuza повернути в цю строку
        System.out.println("Triangle has 2 katets: " + k1 + " and " + k2 + ". Gipotenuse is: " + Math.sqrt(g) + "."); // Виведення на консоль результату розрахунку гіпотенузи


    }//End of main
    public static double gipotenuza (double x, double y){ // Метод що виконує розрахунки гіпотенузи
        return y + x * x; // формула розрахунку і команда на повернення отриманого результату в метод main
    }// end of gipotenuza


    public static double triangleSquare (double aa, double h){ // Метод що виконує розрахунки площі трикутника
        return 180 - (aa + h); //  формула розрахунку і команда на повернення отриманого результату в метод main
    }// end of triangleSquare


    public static double thirdTriangleCorner (double ab, double bc){ // Метод що виконує розрахунки третього кута трикутника
        return 180 - (ab + bc); // формула розрахунку і команда на повернення отриманого результату в метод main
    }// end of thirdTriangleCorner

    public static double areaOfCircle (double r, double PI){ // Метод що виконує розрахунки площі кола
        return 2 * PI * r; // формула розрахунку і на повернення отриманого результату в метод main
    }// end of areaOfCircle

    public static double areaOfSquare (double a){ // Метод що виконує розрахунки площі квадрата
        return a * a; // формула розрахунку і на повернення отриманого результату в метод main
    }// end of areaOfSquare

    public static double perimetrOfRectangle (double b, double c){ // Метод що виконує розрахунки периметра прямокутника
        return 2 * (b + c); // формула розрахунку і на повернення отриманого результату в метод main
    }// end of perimetrOfRectangle

}//end of class
