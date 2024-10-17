package Day14.book_library;

import Day14.book_library.controller.Library;
import Day14.book_library.model.Book;

public class LibraryApplication {
    public static void main(String[] args) {

        Book [] books = new Book[6];
        books[0] = new Book("1984", "Orwell", 1_111_111_111_110l, 2010);
        books[1] = new Book("T1", "A1", 1_111_111_111_111l, 2011);
        books[2] = new Book("T2", "A2", 1_111_111_111_112l, 2012);
        books[3] = new Book("T3", "A3", 1_111_111_111_113l, 2013);


        Library library = new Library(6);
        for (int i = 0; i < books.length-2; i++) { // кладем книги в библиотеку
            library.addBook(books[i]);
        }
        library.printBooks();
        System.out.println(library.size());
        System.out.println("----------------Adding book-------------------");

        Book newBook = new Book("War and piese", "L. N. Tolstoy", 1_111_111_111_114l, 2014);
        library.addBook(newBook);
        library.printBooks();
        System.out.println(library.size());

        System.out.println("--------------Removing book---------------------");
        library.removeBook(1_111_111_111_111l);
        library.printBooks();
        System.out.println(library.size());



    }//end main





}//end class
