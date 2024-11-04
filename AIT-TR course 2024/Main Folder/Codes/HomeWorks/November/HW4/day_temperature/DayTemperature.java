package HW4.day_temperature;

import java.time.LocalDate;

//Задача 1. Имеются результаты измерений температуры в городе за последнюю неделю октября и первую неделю ноября. Создайте класс DayTemperature c полями:
//
//LocalDate date;
//double temperature; Сформируйте два ArrayList и внесите в них данные измерений температуры. Рассчитайте среднюю температуру в городе за прошедшие две недели. В какой день была минимальная температура? В какой день максимальная?
public class DayTemperature {

   private LocalDate date;
    private double temperature;

    public DayTemperature(LocalDate date, double temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DayTemperature{");
        sb.append("date=").append(date);
        sb.append(", temperature=").append(temperature);
        sb.append('}');
        return sb.toString();
    }
}//end class
