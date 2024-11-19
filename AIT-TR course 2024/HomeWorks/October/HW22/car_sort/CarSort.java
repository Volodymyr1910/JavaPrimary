package HW22.car_sort;

import java.util.Objects;

//Задание 1. - это приоритет! На примере класса Car с полями модель, цвет, стоимость, год выпуска повторить все то, что делали с классом Wine на занятии. Получить сортированные списки объектов типа Car:
//
//по моделям
//по цвету
//по стоимости
//по году выпуска Реализовать в отдельном пакете car_sorting по аналогии (Car, CarTest)
public class CarSort implements Comparable <CarSort>{

private String model;
private String color;
private double price;
private int year;


    public CarSort(String model, String color, double price, int year) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarSort carSort)) return false;
        return Double.compare(price, carSort.price) == 0 && year == carSort.year && Objects.equals(model, carSort.model) && Objects.equals(color, carSort.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color, price, year);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarSort{");
        sb.append("model='").append(model).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", price=").append(price);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(CarSort o) {
        return this.model.compareTo(o.model);
    }//end compareTo
}//end class
