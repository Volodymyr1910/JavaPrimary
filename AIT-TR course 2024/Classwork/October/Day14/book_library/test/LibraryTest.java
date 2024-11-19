package Day14.book_library.test;

import Day14.book_library.controller.Library;
import Day14.book_library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library;
    Book[] books;
    int size = 0;


    @BeforeEach
    void setUp() {
        library = new Library(5);
        books = new Book[5];

        books[0] = new Book("1984", "Oruell", 1_111_111_111_110l, 2010);
        books[1] = new Book("T1", "A1", 1_111_111_111_111l, 2011);
        books[2] = new Book("T2", "A2", 1_111_111_111_112l, 2012);
        books[3] = new Book("T3", "A3", 1_111_111_111_113l, 2013);


        //TODO
        //положить обьекты в массив, который "внутри" обьекта library ---ложим книги в библиотеку
        for (int i = 0; i < 4; i++) { // т.к. имеем на данный момент 4 книги, которые кладем в library
            library.addBook(books[i]);// size = 4


        }//end for


    }//end setUp

    // method addBook ----> is boolean !!!!!
    @Test
    void addBookTest() {

        //- не добавлять null
        assertFalse(library.addBook(null));

        //- не добавлять дубликат
        assertFalse(library.addBook(books[2])); //  assertFalse(library.addBook(books[0])); индекс елемента может быть любым

        //добавляем новую книгу когда в библиотеке есть место
        Book newBook = new Book("T4", "A4", 1_111_111_111_114l, 2024);
        assertTrue(library.addBook(newBook));
        assertEquals(5, library.size());

        //добавляем новую книгу когда в библиотеке нет места
        Book oneMorebook = new Book("T5", "A5", 1_111_111_111_115l, 2025);
        assertFalse(library.addBook(oneMorebook));


    }//end addBookTest


    @Test
    void findBookTest() {
        Book foundedBook = library.findBook(1_111_111_111_110l);

        assertEquals(books[0], library.findBook(1_111_111_111_110l), "Method Failed"); //find existed book 1 вариант ОДНО И ТОЖЕ
        assertEquals(foundedBook, library.findBook(1_111_111_111_110l), "Method Failed"); //find existed book 2 вариант ОДНО И ТОЖЕ

        assertNull(library.findBook(1_111_111_111_117l)); // find absent book

    }//end findBookTest

    @Test
    void removeBookTest() {
        // сделали удаление существующей в библиотеке книжки, метод должен вернуть удаленную книжку
        assertEquals(books[0], library.removeBook(1_111_111_111_110l));

        assertEquals(3, library.size());

        //попытка удалить не существующую в библиотеке книжку
        assertNull(library.removeBook(1_111_111_111_119l));


    }// end removeBookTest

    @Test
    void sizeTest() {
        assertEquals(4, library.size());
    }

    @Test
    void printBookTest() {
        System.out.println("=====================");
        library.printBooks();
    }//printBookTest

    @Test
    void updateBookTest (){
        Book newBook = new Book("Play Boy", "Super Puper", 1_111_111_111_114l, 2025);
        library.addBook(newBook);
        //library.updateBook ();



    }//end updateBookTest




}//end class