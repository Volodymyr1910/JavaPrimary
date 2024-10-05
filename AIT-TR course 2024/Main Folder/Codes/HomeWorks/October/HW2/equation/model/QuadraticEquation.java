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


    public String display2() {
        return "Good! We have input values for a quadratic equation {" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    // Создать методы public double delta() и public int quantityRoots() для вычисления дискриминанта и количества решений уравнения соответственно.
    public void display (){
        System.out.println("We have quadratic equation -> a*x^2 - b*x + c = 0");
        System.out.println("Set values for variable a, b and c, please. ");
    }//end display

    public void deltaChecker (double D){
        if(D >= 0 ){
            System.out.println("Discriminator of the equation is -> " + D + ".");
        }else{
            System.out.println(" Discriminant is less than 0. There's no roots in our quadratic equation !");
        }
    }//end delta

    public double delta (double a, double b, double c){
        return b * b - 4 * a * c;
    }//end delta

    public double quantityRootsX1 (){

        return (-b - (Math.sqrt(delta(a, b, c)))) / (2 * a);
    }//end quantityRootsX1

    public double quantityRootsX2 (){
        return (-b + (Math.sqrt(delta(a, b, c)))) / (2 * a);
    }//end quantityRootsX2

    public boolean quantityEquationChecker (){
        boolean flag = false;
        if ((a * quantityRootsX1() * quantityRootsX1() - (b * quantityRootsX2()) + c) == 0){
            flag = true;
        }//ernd if
        return flag;
    }//end quantityRoots

}//end class
