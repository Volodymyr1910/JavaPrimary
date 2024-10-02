package Day1.employee.model;
//- создадим класс Employee (работник):
//  - поля
//  - конструктор
//  - геттеры и сеттеры
//  - метод display
//- создадим класс FirmaAppl, в котором:
//  - создаем объекты типа Employee
//  - определим зарплату и вычислим ее общую сумму.

import Day1.car_object.model.Car;

public class Employee {
    //создаем поля нашего класса
    private int id;  //имя полей
    private String name;
    private String lastName;
    private double salary;
    private boolean gender;
    //private Adress adress;
    //private Car car;

    //конструктор собирает поля и дает возможность создать обьект нашего класса
    public Employee(int id, String name, String lastName, double salary, boolean gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.gender = gender;
    }//end employee


    //setters  меняют значения полей после создания
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //создаем getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public double getSalary() {
        return salary;
    }
    public boolean isGender() {
        return gender;
    }

    public String displayEmployee(){
        return String.format("ID: %d, name: %s, last name: %s, salary: %.2f, gender: %s", id, name, lastName, salary, gender);
        // метод format когда печатает данные типа boolean, воспринимает их как String
    }//end displayEmployee




}//end class
