package Day14.book_library.model;

// Создать класс Book с полями:
// long isbn, String title, String author, int yearOfPublishing.
// Проверить ISBN на корректное количество цифр = 13.

import java.util.Objects;

public class Book {

    // ЗАДАНИЕ КОНСТАНТЫ для класса Book
    public static final int ISBN_LENGHT = 13;

    //fields
    private String title;
    private String author;
    private long isbn;
    private int yearOfPublishing;

    //constructor
    public Book(String title, String author, long isbn, int yearOfPublishing) {
        this.title = title;
        this.author = author;
//        this.isbn = isbn;
//             if (isIsbnValid) {
//                 this.isbn = isbn;
//             }//end if

        this.isbn = checkIsbn (isbn);
        this.yearOfPublishing = yearOfPublishing;
    }

    private long checkIsbn (long isbn) {
        //проверить длину isbn
        if (countDigit(isbn)) {
            return isbn;
        }//end if
        return -1; // сигнал того что isbn неверный
    }//end checkIsbn

    private boolean countDigit(long isbn) {
        int count  = 0;
        while(!(isbn / 10 == 0)){
            count++;
        }//
        // можно циклом for т.к. известно сколько раз он должен отработать
        //return (String.valueOf(isbn).length() == ISBN_LENGTH);  ИЛИ (String.valueOf(isbn).length() == 13); --> ТАКОЙ МЕТОД ТЯНЕТ МНОГО ВЫЧИСЛИТЕЛЬНЫХ РЕСУРСОВ
        return count == ISBN_LENGHT; //  в return поставлено логическое выражение
    }//countDigit

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    // TODO предусмотреть защиту по поводу 13 цифр и в этом случае
    public void setIsbn(long isbn) {
       if(checkIsbn(isbn) > 0) this.isbn = isbn;
       else System.out.println(" ISBN is not correct !");
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", isbn=").append(isbn);
        sb.append(", yearOfPublishing=").append(yearOfPublishing);
        sb.append('}');
        return sb.toString();
    }
}//end class
