package HW9.shape.model;

import java.util.Objects;

public class Circle extends Shape{


    double r;

    public Circle(double first, double r) {
        super(first);
        this.r = r;
    }

    public static double calcArea (double r){
        return Math.PI * r * r;
    }//end calcArea

    public static double calcPerimeter (double r){
        return 2 * Math.PI * r;
    }//end calcPerimeter

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                ", first=" + first +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle circle)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(r, circle.r) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), r);
    }
}//end class
