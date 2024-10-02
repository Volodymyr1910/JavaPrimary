package HW16;

public class HomeWork16extra {
    //Задание 4.(*) Разработать аппликацию для решения квадратного уравнения по коэффициентам квадратного трехчлена а, b и с.
    // Дискриминант вычислить по формуле: d = bb - 4ac Если d > 0, то x1 = (-b + Math.sqrt(d))/(2a), x2 = (-b - Math.sqrt(d))/(2a).
    // Если d = 0, то x = -b / (2a). Если d < 0, то сообщить, что корней нет.
    public static void main(String[] args) {
    double a = 1;
    double b = 6;
    double c = 9;
    double d = b * b - 4 * a * c;
    if (d>0){
        double firstRoot = findFirstRoot(a, b, d);
        double secondRoot = findSecondRoot(a, b, d);
        System.out.println("Three values a, b, c was entered respectively: " + a + ", " + b + ", " + c + ".");
        System.out.println("First root of the equation is: " + firstRoot + ", the second root is: " + secondRoot + ". Discriminator is: " + d + ".");
    }
    if (d==0) {
        double root = -b / (2 * a);
        System.out.println("Three values a, b, c was entered respectively: " + a + ", " + b + ", " + c + ".");
        System.out.println("The root of the equation is: " + root + ". Discriminator is: " + d + ".");
    }
    if (d<0) {
        System.out.println("Three values a, b, c was entered respectively: " + a + ", " + b + ", " + c + ".");
        System.out.println("There is no roots in this equation.");
    }


    }//end of main
    private static double findFirstRoot (double a, double b, double d){
        double x1 = (-b + Math.sqrt(d)) / (2 * a);
        return x1;
    }//end of findFirstRoot

    private static double findSecondRoot (double a, double b, double d){
        double x2 = (-b - Math.sqrt(d)) / (2 * a);
        return x2;
    }//end of findSecondRoot


}//end of class
