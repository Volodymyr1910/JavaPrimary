package Day29.time_api_exercises;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimeApplication {

    public static void main(String[] args) {

        //How much time is it now? -> ISO format: YYYY-mm-DD

        LocalDate localDate = LocalDate.now();
       int year1 =  localDate.getYear();
       int months =  localDate.getMonthValue();
       int day = localDate.getDayOfYear();
        System.out.println("year -> " + year1 + " month -> " + months + " day -> " + day);
        System.out.println("---------------localDate--------------");
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("---------------localTime--------------");
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("---------------localDateTime--------------");
        System.out.println(localDateTime);

        System.out.println("============================================================================");

        LocalDate gagarin = LocalDate.of(1961, 04, 12);
        System.out.println("---------------gagarin--------------");
        System.out.println(gagarin); // будет напечатано в формате ISO, пока не задано другого
        //какой это был день недели
        System.out.println(gagarin.getDayOfWeek()); // WEDNESDAY
        //какой это день года
        System.out.println(gagarin.getDayOfYear()); // 102
        System.out.println("============================================================================");
        System.out.println("---------------is leap year?--------------");
        int year = 2024;
        System.out.println("Is year " + year + " leap: " + Year.isLeap(year));
        System.out.println("-------------------isBefore()-----------------------------------------------");
        System.out.println(gagarin.isBefore(localDate)); //true
        System.out.println("-------------------isAfter()-----------------------------------------------");
        System.out.println(gagarin.isAfter(localDate)); //false
        System.out.println("-------------------days between two dates-----------------------------------------------");
       long days = ChronoUnit.DAYS.between(gagarin, localDate);
        System.out.println(days);
        System.out.println("-------------------years between two dates-----------------------------------------------");
        long years = ChronoUnit.YEARS.between(gagarin, localDate);
        System.out.println(years);

        System.out.println("========================DateTimeFormatter====================================================");

        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE; // ISO format: YYYY-mm-DD
        String date = gagarin.format(df); // localDate to String
        System.out.println("--------------в формате ISO_LOCAL_DATE ------------------------");
        System.out.println(date); // 1961-04-12

        // смена формата для DateTimeFormatter
        df = DateTimeFormatter.BASIC_ISO_DATE;
        date = gagarin.format(df);
        System.out.println("--------------в формате BASIC_ISO_DATE ------------------------");
        System.out.println(date); // 19610412


        // задаем свой собственный формат строки с датой
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = gagarin.format(df);
        System.out.println("--------------в формате dd/MM/yyyy ------------------------");
        System.out.println(date); // 12/04/1961


        // задаем свой собственный формат строки с датой
        df = DateTimeFormatter.ofPattern("dd/M/yy"); //делаем разные форматы
        date = gagarin.format(df);
        System.out.println("--------------в формате dd/M/yy ------------------------");
        System.out.println(date); // 12/4/61

        df = DateTimeFormatter.ofPattern("dd/MMM/yy"); //делаем разные форматы
        date = gagarin.format(df);
        System.out.println("--------------в формате dd/MMM/yy ------------------------");
        System.out.println(date); // 12/квіт./61

        df = DateTimeFormatter.ofPattern("dd/MMMMM/yyyy"); //делаем разные форматы
        date = gagarin.format(df);
        System.out.println("--------------в формате dd/MMMMM/yyyy ------------------------");
        System.out.println(date); // 12/к/1961

        System.out.println("===============================================================");
        //задаем locale
        df = DateTimeFormatter.ofPattern(" dd MMMM yyyy", Locale.ITALIAN);
        date = gagarin.format(df);
        System.out.println("--------------в формате \" dd MMMM yyyy\", Locale.ITALIAN) ------------------------");
        System.out.println(date); //   12 aprile 1961

        df = DateTimeFormatter.ofPattern(" dd MM YYYY", Locale.ITALIAN);
        date = gagarin.format(df);
        System.out.println("--------------в формате \" dd MMMM YYYY\", Locale.ITALIAN) ------------------------");
        System.out.println(date); //   12 aprile 1961



        //вытащить дату со строки parsing LogalDate from String
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        String stringDate = "01:12-2024";
        LocalDate parsFromStringToLocalDate = LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("[dd:MM:yyyy][dd/MM/yyyy][dd-MM-yyyy][dd:MM-yyyy]"));
        System.out.println(parsFromStringToLocalDate); // получим дату в ISO формате

        System.out.println("--------------------------------------------------------------------------------------------");
        String dianaBirthday = "23.06.1983";
        LocalDate dianaBirth = LocalDate.parse(dianaBirthday, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(dianaBirth);

        df = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);
       String d = dianaBirth.format(df);
        System.out.println(d);
    }//end main


}//end class
