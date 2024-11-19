package HW9.shape.model;

import java.util.Objects;
//Создайте абстрактный класс Shape с типом поля double (одно) и абстрактными методами calcArea и calcPerimeter
public class Shape {

    double first;

    public Shape(double first) {
        this.first = first;
    }


    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public static void calcArea (){
    }//end calcArea

    public static double calcPerimeter (){
        return 0;
    }//end calcPerimeter




    @Override
    public String toString() {
        return "Shape{" +
                "first=" + first +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape shape)) return false;
        return Double.compare(first, shape.first) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(first);
    }
}//end class
