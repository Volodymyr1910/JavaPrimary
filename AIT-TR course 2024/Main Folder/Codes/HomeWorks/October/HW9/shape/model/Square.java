package HW9.shape.model;

import java.util.Objects;

public class Square extends Shape{

    double a;

    public Square(double first, double a) {
        super(first);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public static double calcArea (double a){
        return a * a;
    }//end calcArea

    public static double calcPerimeter (double a){
        return 4 * a;
    }//end calcPerimeter




    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", first=" + first +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square square)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(a, square.a) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a);
    }
}//end class
