package my_projects;
//Марафон: Классы-сущности -> Интерфейс -> Тесты -> Имплементация -> Приложение
//Во всех класcах должен быть некий id (штрих-код, isbn и т.д.)
//
//Book - Library, найти все книги по автору

//Document - Archive, поиск документов по автору, по названию   ------------------------------------------------------------OK

//Computer (Laptop, SmartPhone) - Shop, найти компьютеры со скидкой на BlackFriday ------------------------------------------

//Product (Product, Food, MeatFood, MilkFood) - Supermarket, искать продукты по сроку годности (срок задается строкой вида yyyy-MM-dd), общая стоимость всех товаров, средняя стоимость, ... ------------------------------------------------------------------------------------------------------

//Pets (Cat, Dog) - Hotel, подсчитать выручку от отеля, найти всех животных по породе, ... -------------------------------------OK

//Student, Aspirant, Professor - High school - средний балл, выбрать студентов со средним баллом от и до, ...---------------------

import MyMethods.array_methods.ArrayMethods_String;

//можно предложить свой вариант
//По методам - должны быть CRUD-операции:
//С - create
//R - read, find
//U - update (не обязательно)
//D - delete, remove
//Главное - не ШИРОКАЯ функциональность, а последовательность разработки от классов через интерфейс к тестированию и имплементации.
//
//Полный марафон - 5 проектов, полумарафон - 3 проекта.
public class Start {

    public static void main(String[] args) {

        String[] array = new String[5];

        array[0] = new String("AAX");
        array[1] = new String("AAQ");
        array[2] = new String("AAB");
        array[3] = new String("AAA");
        array[4] = new String("AAA");

        ArrayMethods_String.bubleSortFrom_Z_to_A_WithReturn(array);
        ArrayMethods_String.printArrayString(array);
    }//end main


}//end class
