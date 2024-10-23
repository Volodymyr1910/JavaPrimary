package Day22.wine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class WineTest {

    Wine[] wines;

    @BeforeEach
    void setUp() {

        wines = new Wine[5];

        wines[0] = new Wine("type1", "AAA", 2021, 6);
        wines[1] = new Wine("type2", "CCC", 2024, 3);
        wines[2] = new Wine("type3", "XXX", 2022, 5);
        wines[3] = new Wine("type1", "OOO", 2015, 7);
        wines[4] = new Wine("type2", "SSS", 2000, 20);


    }//end setUp

    @Test
    void sortWineByPriceTest() {

        Comparator<Wine> comparatorByPrice = new Comparator<Wine>() {
            @Override
            public int compare(Wine o1, Wine o2) {
                //return (int) (o1.getPrice() - o2.getPrice());
                return Double.compare(o1.getPrice(), o2.getPrice());
            }//end compare
        };//end comparatorByPrice
        System.out.println("-----------------List wines as is--------------------");
        printWine();

        Arrays.sort(wines, comparatorByPrice);
        System.out.println("-----------------List wines after sort by price--------------------");
        printWine();
    }//end sortWineByPriceTest

    @Test
    void sortWineByTitleTest (){
        System.out.println("-----------------List wines as is--------------------");
        printWine();
        Comparator <Wine> comparatorByTitle = new Comparator<Wine>() {
            @Override
            public int compare(Wine w1, Wine w2) {
                return w1.getTitle().compareTo(w2.getTitle());
            }
        };
        Arrays.sort(wines, comparatorByTitle);
        System.out.println("-----------------List wines after sort by Title--------------------");
        printWine();


    }//end sortWineByTitleTest



    @Test
    void sortWineByAgeTest() {
        System.out.println("-----------------List wines as is--------------------");
        printWine();
        Arrays.sort(wines);
        System.out.println("-----------------List wines after sort by age--------------------");
        printWine();

    }//end sortWineByAgeTest


    @Test
    void printWine() {
        for (int i = 0; i < wines.length; i++) {
            System.out.println(wines[i]);
        }//end for
    }//end printWine


}//end class