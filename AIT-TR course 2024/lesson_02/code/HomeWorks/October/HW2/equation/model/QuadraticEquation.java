package HW2.equation.model;
//поля private double a; private double b; private double c;.
// Создать конструктор public QuadraticEquation(double a, double b, double c) для инициализации полей. Создать геттеры и сеттеры.
// Создать метод public void display() для печати в консоль квадратного уравнения.
// Создать методы public double delta() и public int quantityRoots() для вычисления дискриминанта и количества решений уравнения соответственно.
//
public class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }


    public String display() {
        return "QuadraticEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    // Создать методы public double delta() и public int quantityRoots() для вычисления дискриминанта и количества решений уравнения соответственно.

    public double delta (double a, double b, double c){
        return b * b - 4 * a * c;  }//end delta

    public double quantityRootsX1 (){
       return (-b - Math.sqrt(delta(a, b, c)) / (2 * a));
    }//end quantityRootsX1

    public double quantityRootsX2 (){
        double x1 =
        return (-b + Math.sqrt(delta(a, b, c)) / (2 * a));
    }//end quantityRootsX2

    public boolean quantityEquationChecker (){
        boolean flag = false;
        if (a * x1 * x1 + b * x2 + c == 0){
            flag = true;
        }//ernd if
        return flag;
    }//end quantityRoots

}//end class
