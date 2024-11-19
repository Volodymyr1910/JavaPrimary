package MyMethods.work_with_TimeAPI.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {


    //  Этот метод принимает дату рождения в виде стринга,
    //  и возвращающий возраст.

    public static int getAge(String birthDate) {
        // TODO Homework
        LocalDate userDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        return (int) ChronoUnit.YEARS.between(userDate, LocalDate.now());
    }// end getAge


    public static String[] sortStringDates(String[] dates) {
        //решение с помощью stream
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][dd/MM/yyyy]");
        return Arrays.stream(dates).sorted((d1, d2)-> LocalDate.parse(d1, dateTimeFormatter).compareTo(LocalDate.parse(d2, dateTimeFormatter))).toArray(String[]::new);

        /*

        // TODO Homework

        //нахожу элемент, не такой как все. Сохраняю его в переменную
        String pattern = ("([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])-([0][1-9]|[1][1-2])-([0][1-9]|[1-2][0-9]|[3][0-1])");
        int ind = 0;
        String strForInsert = null;
        for (int i = 0; i < dates.length; i++) {
            if (!(dates[i].matches(pattern))) {
                strForInsert = dates[i];
                i = dates.length;
            }
        }
        // перевожу стринг-не такой как все-элемент в localDate и получаю образец для сравнивания
        LocalDate strForInsertLD = LocalDate.parse(strForInsert, DateTimeFormatter.ofPattern("[dd/MM/yyyy]"));
        // все элементы парсим в localDate
        LocalDate[] array = new LocalDate[dates.length];
        for (int k = 0, j = 0; k < dates.length; k++, j++) {
            array[j] = LocalDate.parse(dates[k], DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
        }//end for
        //сортируем массив
        Comparator<LocalDate> ld = new Comparator<LocalDate>() {
            @Override
            public int compare(LocalDate o1, LocalDate o2) {
                return o1.compareTo(o2);
            }
        };
        Arrays.sort(array, ld);

        //находим индекс где в массиве localDate стоит наш не такой как все элемент, используя образец
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(strForInsertLD)) ind = i;
        }

        // перегоняем localDate назад в стринг
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        for (int m = 0, j = 0; m < array.length; j++, m++) {
            dates[m] = array[j].format(df);
        }
        // по ранее найденному индексу, заменяем элемент массива, придавая ему первоначальный формат
        dates[ind] = strForInsert;

        return dates; */




    }//end sortStringDates


}//end
