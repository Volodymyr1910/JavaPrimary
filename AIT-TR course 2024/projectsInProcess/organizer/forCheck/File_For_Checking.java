package projectsInProcess.organizer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class File_For_Checking {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


         String dateTemp;
        LocalDate date = null;
        do {
            System.out.println("Enter the finish date (example 12-12-2022):");
            dateTemp = scanner.nextLine();
            if (!checkDateFormat(dateTemp)) {
                System.out.println("Incorect date format.");
            }//end if
        } while (!checkDateFormat(dateTemp));

        try {
            // Створюємо універсальний DateTimeFormatter для різних форматів вводу
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy]");

            // Парсимо дату
            LocalDate date1 = LocalDate.parse(dateTemp, inputFormatter);

            // Форматуємо дату у потрібний формат (приклад: dd/MM/yyyy)
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = date1.format(outputFormatter);

            // Перетворюємо знову у LocalDate, якщо потрібен результат саме цього типу
            LocalDate finalDate = LocalDate.parse(formattedDate, outputFormatter);

            System.out.println("Фінальна дата (LocalDate): " + finalDate);
        } catch (DateTimeParseException e) {
            System.out.println("Некоректний формат дати. Спробуйте ще раз.");
        }

        /*
        // Форматери
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy]");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = null;

        // Цикл для вводу дати
        while (date == null) {
            System.out.println("Enter the finish date (example 12-12-2022):");
            String dateTemp = scanner.nextLine();
            try {
                // Парсинг дати за можливими форматами
                date = LocalDate.parse(dateTemp, inputFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date format. Please try again.");
            }
        }

        // Вивід результату
        System.out.println("Parsed date (ISO format): " + date);
        DateTimeFormatter finFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String finDateTemp = date.format(finFormat);
        LocalDate finalDate = LocalDate.parse(finDateTemp, finFormat);
        System.out.println(finalDate);


        System.out.println(------------------------------------------------------------------------------------------------------------------);
        /*
        Scanner scanner = new Scanner(System.in);
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
         LocalDate date = LocalDate.parse(dateTemp, dtf);

        } catch (DateTimeParseException e) {
            System.out.println("Incorrect date format. Please try again.");
        }
        DateTimeFormatter finFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String finDateTemp = date.format(finFormat);
        LocalDate finalDate = LocalDate.parse(finDateTemp, finFormat); */


        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    /*
        String dateTemp;
        // Форматер для вводу
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy][dd:MMM:yyyy][dd/MMM/yyyy][dd-MMM-yyyy][dd.MMM.yyyy][dd,MMM,yyyy][dd_MMM_yyyy][d:MMM:yyyy][d/MMM/yyyy][d-MMM-yyyy][d.MMM.yyyy][d,MMM,yyyy][d_MMM_yyyy]");

        // Перевірка та парсинг дати
        LocalDate date = null;
        do {
            System.out.println("Enter the finish date, please:");
            dateTemp = scanner.nextLine();
            try {
                date = LocalDate.parse(dateTemp, dtf);  // Спроба розпарсити
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date format. Try again.");
            }
        } while (date == null);

        // Форматування у фінальний вигляд
        DateTimeFormatter finFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String finDateTemp = date.format(finFormat);
        LocalDate finalDate = LocalDate.parse(finDateTemp, finFormat);

        System.out.println("Final date: " + finalDate);


 DateTimeFormatter fd = DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd.MM.yyyy][dd,MM,yyyy][dd_MM_yyyy][dd:MMM:yyyy][dd/MMM/yyyy][dd-MMM-yyyy][dd.MMM.yyyy][dd,MMM,yyyy][dd_MMM_yyyy]");


        DateTimeFormatter finFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String finDateTemp = fd.format(finFormat);
        LocalDate finalDate = LocalDate.parse(finDateTemp, finFormat);

        */


    }//end main

    //DateFormatEU - dd-MM-yyyy
    public static boolean checkDateFormat(String str) {
        // TODO Homework checkDateFormatEU
        return str.matches("((((([0][1-9]|[1-2][0-9]|[3][0-1]))(-|.|/||:|,|_)(12))|(([0][1-9]|[1][0-9]|[2][0-8])(-|.|/||:|,|_)(02))|(([0][1-9]|[1-2][0-9]|30)(-|.|_)((01|[0][3-9]|[1][0-1])|)))(-|.|/||:|,|_)(([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])))");
    }//end checkDateFormatEU

}//end class
