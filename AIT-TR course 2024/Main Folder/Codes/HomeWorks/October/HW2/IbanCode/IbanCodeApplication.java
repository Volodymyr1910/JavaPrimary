package HW2.IbanCode;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class IbanCodeApplication {

    public static void main(String[] args) {
        IbanCode ibanCode1 = new IbanCode("XX00 0000 0000 0000 0000 00", "00/00", "00/00");
        Scanner scanner = new Scanner(System.in);

        //determine the current date
        int currentMonth = 10;
        int currentYear = 24;
        String currentDate = currentMonth + "/" + currentYear;
        // the expiration date must be in range from -10 to +10 of the current year
        // our rule: if expiration date has gone - the IBAN is not valid

        //determine the expiration date
        System.out.println("Enter the month of your card expiration date:");
        int userExpirationDatemonth = scanner.nextInt();
        while (userExpirationDatemonth < 1 | userExpirationDatemonth > 12) {
            System.out.println("Wrong input. Number of month from 1 till 12 ! Try again, please");
            userExpirationDatemonth = scanner.nextInt();
        }//end while
        System.out.println("Enter the year of your card expire date (after slash):");
        String userExpirationDatemonthF = Integer.toString(userExpirationDatemonth);
        if(userExpirationDatemonthF.length() != 2){
            userExpirationDatemonthF= "0" + userExpirationDatemonthF;
        }//end if
        String userExpirationDateFinal = userExpirationDatemonthF + "/";
        System.out.print(userExpirationDateFinal);
        int userExpirationDateYear = scanner.nextInt();
        if ((userExpirationDateYear < (currentYear - 10))) {
            System.out.println("I am sorry, but your bank account is overdue !");
        } else if (userExpirationDateYear > (currentYear + 10)) {
            System.out.println("Wrong input. Year of expiration date can't be higher than " + (currentYear + 10) + "!");
        } else {
            String expirationDate = userExpirationDateFinal + userExpirationDateYear;

            //define the IBAN
            System.out.println("Enter your IBAN, please (in format XXYY-YYYY-YYYY-YYYY-YYYY-YY): ");
            String first = scanner.next();
            while (Character.isLetter(first.charAt(0)) == false | Character.isLetter(first.charAt(1)) == false | first.length() !=2){
                System.out.println("Error. Must contains two letters! Enter the correct data: ");
                first = scanner.next();
            }//end while
            String firstNew = first.toUpperCase(Locale.ROOT);
            System.out.print(firstNew + "-");
            String second = scanner.next();
            while(Character.isDigit(second.charAt(0)) == false | Character.isDigit(second.charAt(1)) == false | Character.isDigit(second.charAt(2)) == false | Character.isDigit(second.charAt(3)) == false | second.length() != 4  ){
                System.out.println("Error. Must contains four numbers! Enter the correct data: ");
                second = scanner.next();
            }//end while
            System.out.print(firstNew + "-" + second + "-");
            String third = scanner.next();
            while(Character.isDigit(third.charAt(0)) == false | Character.isDigit(third.charAt(1)) == false | Character.isDigit(third.charAt(2)) == false | Character.isDigit(third.charAt(3)) == false | third.length() != 4 ){
                System.out.println("Error. Must contains four numbers! Enter the correct data: ");
                third = scanner.next();
            }//end while
            System.out.print(firstNew + "-" + second + "-" + third + "-");
            String fourth = scanner.next();
            while(Character.isDigit(fourth.charAt(0)) == false | Character.isDigit(fourth.charAt(1)) == false | Character.isDigit(fourth.charAt(2)) == false | Character.isDigit(fourth.charAt(3)) == false | fourth.length() != 4){
                System.out.println("Error. Must contains four numbers! Enter the correct data: ");
                fourth = scanner.next();
            }//end while
            System.out.print(firstNew + "-" + second + "-" + third + "-" + fourth + "-");
            String fifth = scanner.next();
            while(Character.isDigit(fifth.charAt(0)) == false | Character.isDigit(fifth.charAt(1)) == false | Character.isDigit(fifth.charAt(2)) == false | Character.isDigit(fifth.charAt(3)) == false | fifth.length() != 4){
                System.out.println("Error. Must contains four numbers! Enter the correct data: ");
                fifth = scanner.next();
            }//end while
            System.out.print(firstNew + "-" + second + "-" + third + "-" + fourth + "-" + fifth + "-");
            String sixth = scanner.next();
            while(Character.isDigit(sixth.charAt(0)) == false | Character.isDigit(sixth.charAt(1)) == false | Character.isDigit(sixth.charAt(2)) == false | Character.isDigit(sixth.charAt(3)) == false | sixth.length() != 4){
                System.out.println("Error. Must contains four numbers! Enter the correct data: ");
                sixth = scanner.next();
            }//end while

            //Connect the parts of IBAN to one sentence in a format convenient for inspection
            String iBanForLooking = firstNew + "-" + second + "-" + third + "-" + fourth + "-" + fifth + "-" + sixth;

            //Connect the parts of IBAN to one sentence in a format convenient for futher processing
            String iBanFinal = firstNew + second + third + fourth + fifth + sixth;

            //update the fields data of the object
            ibanCode1.setCurrentDate(currentDate);
            ibanCode1.setexpirationDate(expirationDate);
            //String ibanArray [] = getiBAN().split("");
            //String iBanFinal = firstNew + second + third + fourth + fifth + "jjjj";
            ibanCode1.setiBAN(iBanFinal);
            ibanCode1.display(iBanForLooking);

            //turn on the methods
            System.out.println("Lenght of IBAN is -> " + ibanCode1.lengthCode());
            System.out.println("Your IBAN is correct -> " + ibanCode1.isValid());
            System.out.println("The sum of the ASCII codes first two symbols of the IBAN is -> " + ibanCode1.controlCode() + ".");

















        }//end else





    }//end main


}//end class
