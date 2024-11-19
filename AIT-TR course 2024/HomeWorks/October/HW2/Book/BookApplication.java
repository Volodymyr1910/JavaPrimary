package HW2.Book;

import HW2.Book.model.Dictionary;

public class BookApplication {

    public static void main(String[] args) {

        Dictionary dictionary1 = new Dictionary("978-966-97824-4-1", "Wolve Night", "Brad Pitt", 1987, "Novel", "English", 15, 200000);
        Dictionary dictionary2 = new Dictionary("978-966-97824-4-2", "Sunny day", "Jouseppe Werdi", 1970, "Romance novel", "English", 30, 500000);
        Dictionary dictionary3 = new Dictionary("978-966-97824-4-3", "Mask In Front Of You", "Nicolas Keige", 2014, "Thriller", "English", 90, 3700000);


        System.out.println(dictionary1.display());
        System.out.println(dictionary2.display());
        System.out.println(dictionary3.display());


    }//end main
}//end class
