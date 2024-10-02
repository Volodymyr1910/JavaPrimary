package HW2.equation;

import HW2.equation.model.QuadraticEquation;

import java.util.Scanner;

public class QuadraticEquationApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuadraticEquation quadraticEquation = new QuadraticEquation(1, -3, 2);

        quadraticEquation.display();
        System.out.println("Enter number for variable a:");
        double temp = scanner.nextDouble();
        if(temp == 0){
            while( temp == 0){
                System.out.println("Wrong input ! Variable a can't be a zero, for quadratic equation !");
                System.out.println("Input another number for a:");
                temp = scanner.nextDouble();
            }//end while
        }//end if
        quadraticEquation.setA(temp);
        System.out.println("Enter number for variable b:");
        quadraticEquation.setB(scanner.nextDouble());
        System.out.println("Enter number for variable c:");
        quadraticEquation.setC(scanner.nextDouble());

        String result = quadraticEquation.display2();
        System.out.println(result);
        quadraticEquation.deltaChecker(quadraticEquation.delta(quadraticEquation.getA(), quadraticEquation.getB(), quadraticEquation.getC()));

        System.out.println("Fist root of the equation is -> " + quadraticEquation.quantityRootsX1() + ", second root is -> " + quadraticEquation.quantityRootsX2() + ".");
        System.out.println("Quadratic equation is complete -> " + quadraticEquation.quantityEquationChecker() + ".");
    }//end main
}//end class
