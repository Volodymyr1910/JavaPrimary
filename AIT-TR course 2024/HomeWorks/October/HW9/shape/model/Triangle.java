package HW9.shape.model;

import java.util.Objects;

public class Triangle extends Shape{

    double a;
    double b;
    double c;

    public Triangle(double first, double a, double b, double c) {
        super(first);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static double calcArea (double a, double b, double c){
        double p = calcPerimeter() /2 ;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }//end calcArea

    public static double calcPerimeter (double a, double b, double c){
        return a + b + c;
    }//end calcPerimeter

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

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", first=" + first +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle triangle)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b, c);
    }
}//end class
