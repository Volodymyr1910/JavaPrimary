package projectsInProcess.organizer.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ggggg {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);


        System.out.println(dateFromUserToSystem());
        /*LocalDate date = null;
        do {
            System.out.println("Enter the finish date (example 12-12-2022):");
            dateTemp = scanner.nextLine();
            if (!checkDateFormat(dateTemp)) {
                System.out.println("Incorect date format.");
            }//end if
        } while (!checkDateFormat(dateTemp));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy]");
        try {
             date = LocalDate.parse(dateTemp, dtf);

        } catch (DateTimeParseException e) {
            System.out.println("Incorrect date format. Please try again.");
        }
        DateTimeFormatter finFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String finDateTemp = date.format(finFormat);
        LocalDate finalDate = LocalDate.parse(finDateTemp, finFormat);
        System.out.println(finalDate);*/
    }//end main

    public static LocalDate dateFromUserToSystem() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        String dateTemp;
        do {
            System.out.println("Enter the finish date (example 12-12-2022):");
            dateTemp = scanner.nextLine();
            if (!checkDateFormat(dateTemp)) {
                System.out.println("Incorect date format.");
            }//end if
        } while (!checkDateFormat(dateTemp));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy]");
        try {
            date = LocalDate.parse(dateTemp, dtf);

        } catch (
                DateTimeParseException e) {
            System.out.println("Incorrect date format. Please try again.");
        }
        return date;
    }//end dateFromUserToSystem

    public static boolean checkDateFormat(String str) {
        return str.matches("((((([0][1-9]|[1-2][0-9]|[3][0-1]))(-|.|/||:|,|_)(12))|(([0][1-9]|[1][0-9]|[2][0-8])(-|.|/||:|,|_)(02))|(([0][1-9]|[1-2][0-9]|30)(-|.|_)((01|[0][3-9]|[1][0-1])|)))(-|.|/||:|,|_)(([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])))");
    }//end checkDateFormatEU



}



