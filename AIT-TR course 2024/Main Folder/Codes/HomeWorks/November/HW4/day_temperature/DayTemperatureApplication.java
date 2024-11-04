package HW4.day_temperature;

import MyMethods.list.list_methods.ListMethods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DayTemperatureApplication {

    private static final LocalDate NOW_DATE = LocalDate.of(2024, 10, 31); // дата "средины" выбраного периода
    private static final int PERIOD = 14;

    public static void main(String[] args) {

        // создаем лист дат, заполняем null, чтоб использовать метод list.size()
        List<DayTemperature> list = new ArrayList<>(PERIOD);
        for (int i = 0; i < 14; i++) {
            list.add(i, null);
        }//end for

        // создаем и заполняем лист температур
        List<Double> listOfTemp = ListMethods.fillArrayRandomDouble(5, 9, PERIOD);

        //заполняем общий лист с датами и температурами
        for (int i = 0; i < list.size(); i++) {
            if(i < list.size() / 2)list.set(i, new DayTemperature(NOW_DATE.minusDays(list.size() / 2 - i - 1), listOfTemp.get(i)));
            else if (i == list.size() / 2) list.set(i, new DayTemperature(NOW_DATE.plusDays(list.size() / 2 - i + 1), listOfTemp.get(i)));
            else list.set(i, new DayTemperature(NOW_DATE.plusDays((i - list.size() / 2) + 1),listOfTemp.get(i)));
        }//end for
        ListMethods.printList(list, " with data");

        //находим среднюю температуру за период
        double sumTemp = 0;
        for (DayTemperature dayTemp : list) {
            sumTemp += dayTemp.getTemperature();
        }//end for
        double avgTemp = sumTemp / list.size();

        // с помощью сортировки находим наибольшую и наименьшую температуры
        Collections.sort(list, Comparator.comparing(DayTemperature::getTemperature));

        System.out.println();
        System.out.printf("For period 25.10 - 7.11.2024 the average temperature is -> %.2f", avgTemp);
        System.out.println(" , highest temp " + list.getLast().getTemperature() + " was " + list.getLast().getDate() + ", the lowest " + list.getFirst().getTemperature() + " was " + list.getFirst().getDate() + ".");
    }//end main

}//end class
