package HW18;

import java.util.Scanner;


public class HW18TotalOfDigits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive number, please: ");
        String number = scanner.nextLine();
        String startNumber = number;
        String lastSymbol = String.valueOf(number.charAt(number.length()-1));
        int res = Integer.parseInt(lastSymbol);
        int newnumber = Integer.parseInt(number);

        while (newnumber >= 10){
            newnumber = newnumber / 10;
            String newnumber1 = Integer.toString(newnumber);
            String lastSymbol1 = String.valueOf(newnumber1.charAt(newnumber1.length()-1));
            int newlastSymbol1 = Integer.parseInt(String.valueOf(lastSymbol1));
            res = res + newlastSymbol1;
        }

        System.out.println(" Total of digits in number " + startNumber + " is: " + res + ".");

    }
}
