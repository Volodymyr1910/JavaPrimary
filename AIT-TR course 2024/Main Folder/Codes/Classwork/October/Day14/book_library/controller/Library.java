package Day14.book_library.controller;

import Day14.book_library.model.Book;

public class Library {

    //fields
    // private  Book [] books -> массив - содержащий обьекты, которые содержат множество полей -  сам становиться полем
    private  Book [] books; // capasity = books.lenght ; -> capasity это вместительность
    private int size; // текущее количество книг, т.е. текущая длина массива books -> т.е. поле size отображает ТЕКУЩЕЕ количество елементов поля books;


    //constructor создаст обьект типа Library (по имени класса)

    //стандартный конструктор
     /*
    public Library(Book[] books, int size) {
        this.books = books;
        this.size = size;
    }
    */

    //измененный конструктор, создает новый обьект Library, размер его - это capasity, а все элементы - пусты, на момент создания обьекта
    public Library(int capasity) {
        this.books = new Book[capasity];
        this.size = 0;
    }

    // CRUD methods


    //boolean - addBook(Book book) ---> получает на вход обьект book типа Book, а отдает ответ: true - добавил, false - не добавил
    //size++ если добавил книгу, то текущее ко-во книг, имеющихся в обьекте (массиве) Book [] books выростет на 1

    // void - printBooks---> ничего на вход не получает, ничего не отдает

    //Book findBook(long ISBN) ---> получает на вход поле ISBN, обьекта book типа Book, а отдает обьект book, если нашел, или null, если не нашел
    public Book findBook(long ISBN){

        Book foundedBook = null;

        return foundedBook;
    }


    //Book или boolean - removeBook(long ISBN)---> Вариант 1 получает на вход поле ISBN, обьекта book типа Book, а отдает обьект book, если удалил, или null, если не удалил
    //                                        ---> Вариант 2 получает на вход поле ISBN, обьекта book типа Book, а отдает ответ: true - удалил, false - не удалил
    //size-- если книгу удаляют, то текущее ко-во книг, имеющихся в обьекте (массиве) Book [] books падает на 1


    // boolean - updateBook() ---> ничего на вход не получает, а отдает ответ: true - изменил, false - не изменил


    //int - size () ---> ничего на вход не получает, отдает цифру, сколько обьектов book в обьекте books
    public int size (){
        return  size; //параметр автоматически отслеживает величину своего значения, принимая стартовое значение 0, и потом ориентируясь на методы addBook и removeBook

    }

}//end Library
