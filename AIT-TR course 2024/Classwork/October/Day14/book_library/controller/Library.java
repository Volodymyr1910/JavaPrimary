package Day14.book_library.controller;
//Реализовать методы:
//- печать списка всех книг в библиотеке;
//- получение кол-ва книг в библиотеке;
//- поиска книги по ISBN;
//- добавление книги в библиотеку с учетом требований:
//  - не добавлять null
//  - не добавлять дубликат
//  - не добавлять больше, чем может вместить в себя библиотека.
//- удаление книги из библиотеки.
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

    public boolean addBook(Book book){
        if(book == null) return false; // попытка добавить пустую книгу
        if (size == books.length)return false; // попытка добавить книгу в полную библиотеку
        if (!(findBook(book.getIsbn()) == null))return false; // попытка добавить книгу, которая уже есть

        //positive case
        books[size] = book; // ставим новую книжку на первое свободное место
        size++;                    // size  показывает последнее свободное место
        return true;
    }//end addBook


    // void - printBooks---> ничего на вход не получает, ничего не отдает
    public void printBooks(){
        for (int i = 0; i < size; i++) { // должен печатать только те книги которые в библиотеке !!!
            System.out.println(books[i]);
        }//end fori
    }//end printBooks


    //Book findBook(long isbn) ---> получает на вход поле ISBN, обьекта book типа Book, а отдает обьект book, если нашел, или null, если не нашел
    public Book findBook(long isbn){
        for (int i = 0; i < size; i++) {
            if(books[i].getIsbn() == isbn){
                return books[i];
            }//end if
        }//end fori
        return null;
    }// end findBook


    //Book или boolean - removeBook(long isbn)---> Вариант 1 получает на вход поле ISBN, обьекта book типа Book, а отдает обьект book, если удалил, или null, если не удалил
    //                                        ---> Вариант 2 получает на вход поле ISBN, обьекта book типа Book, а отдает ответ: true - удалил, false - не удалил
    //size-- если книгу удаляют, то текущее ко-во книг, имеющихся в обьекте (массиве) Book [] books падает на 1
    public  Book removeBook(long isbn){
        for (int i = 0; i < size; i++) {
            if(books[i].getIsbn() == isbn){
                Book victim = books[i];
                books[i] = books [size - 1];
                books [size - 1] = null;
                // copie of last book put instead victim
                // delete last book from her place, затираем последний элемент массива
                size--;
                return victim;
            }//end if
        }//end for
        return null;
    }//end removeBook





    // boolean - updateBook() ---> ничего на вход не получает, а отдает ответ: true - изменил, false - не изменил


    //int - size () ---> ничего на вход не получает, отдает цифру, сколько обьектов book в обьекте books
    public int size (){
        return  size; //параметр автоматически отслеживает величину своего значения, принимая стартовое значение 0, и потом ориентируясь на методы addBook и removeBook
    }//end size

}//end Library
