package Day1.car_object.model;

public class Car {
    //field
    //заполнили поля нашего обьекта car
    private String brand;
    private int year;
    private double price;
    private String color;
    private boolean isNew;


    //constructor - метод, который ничего не возвращает; всегда имеет название класса, принадлежит всему классу даже без аргумента static
    //в какой последовательности выделять поля в generate-constructor - в такой последовательности метод их отобразит
    //generate-constructor-выбираем все поля
    public Car(String brand, int year, double price, String color, boolean isNew) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.color = color;
        this.isNew = isNew;
    }

    //getters and setters помогают менять значения полей уже созданных обьектов
    //generate-getters and setters-выбираем все поля

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    //выводит на печать созданный нами обьект
    //generate-toString()-concat+-выбираем все поля

    public String display() { //изменили имя метода с toString на display. Потом удалили @Override
        return "Car{" +
                "brand='" + brand + '\'' +      // если оставить toString, то это лучше
                ", year=" + year +               // тогда в классе куда будем этот метод вызывать можно сразу в аргумент sout ложить
                ", price=" + price +            // имя переменной, принимающей результаты работы конструктора
                ", color='" + color + '\'' +
                ", isNew=" + isNew +
                '}';
    } // end of display

    public void move(){
        System.out.println("Car is moving...");
    }//end move

    public void stop(){
        System.out.println("Car is stopped.");
    }//end stop


}//end class
