package Day14.book_library.test;

import Day14.book_library.controller.Library;
import Day14.book_library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    Library library;
     Book [] books;
     int size = 0;


    @BeforeEach
    void setUp() {
        library = new Library(5);
        books[0] = new Book("1984", "Oruell", 1_111_111_111_110l, 2010);
        books[1] = new Book("T1", "A1", 1_111_111_111_111l, 2011);
        books[2] = new Book("T2", "A2", 1_111_111_111_112l, 2012);
        books[3] = new Book("T3", "A3", 1_111_111_111_113l, 2013);

        //TODO
        //положить обьекты в массив, который "внутри" обьекта library
    }

    @Test
    void findBookTest (){
        Book foundedBook = library.findBook(1_111_111_111_110l);

        assertEquals(books [0], library.findBook(1_111_111_111_110l), "Method Failed"); //find existed book 1 вариант ОДНО И ТОЖЕ
        assertEquals(foundedBook, library.findBook(1_111_111_111_110l), "Method Failed"); //find existed book 2 вариант ОДНО И ТОЖЕ

        assertNull(library.findBook(1_111_111_111_117l)); // find absent book

    }



}//end class