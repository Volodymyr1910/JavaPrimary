package HW2.equation;

import HW2.equation.model.QuadraticEquation;

public class QuadraticEquationApplication {
    public static void main(String[] args) {

        QuadraticEquation quadraticEquation = new QuadraticEquation(5, 3, 9);

         double x1 = quadraticEquation.quantityRootsX1();
         double x2 = quadraticEquation.quantityRootsX2();
        System.out.println("Fist root of the equation is -> " + x1 + ", second root is -> " + x2 + ".");
        System.out.println("Quadratic equation is incomplete -> " + quadraticEquation.quantityEquationChecker() + ".");


    }//end main




}//end class
