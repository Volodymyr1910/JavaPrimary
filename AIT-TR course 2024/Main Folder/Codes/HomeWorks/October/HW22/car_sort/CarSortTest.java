package HW22.car_sort;

import Day22.wine.Wine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CarSortTest {
    CarSort[] car;

    @BeforeEach
    void setUp() {

        car = new CarSort[5];

        car[0] = new CarSort("Mercedes", "Black", 15_000, 2000);
        car[1] = new CarSort("BMW", "Red", 18_000, 2016);
        car[2] = new CarSort("Porshe", "Green", 30_000, 2023);
        car[3] = new CarSort("Audi", "White", 22_000, 2020);
        car[4] = new CarSort("Opel", "Red", 12_000, 2019);

    }//end setUp


    @Test
    void carSortByModelTest() {
        System.out.println("-----------------List cars as is--------------------");
        printCarSort();
        Arrays.sort(car);
        System.out.println("-----------------List cars after sort by Model--------------------");
        printCarSort();
    }//end carSortByModelTest

    @Test
    void carSortByColorTest() {
        System.out.println("-----------------List cars as is--------------------");
        printCarSort();
        Comparator<CarSort> compColor = new Comparator<CarSort>() {
            @Override
            public int compare(CarSort o1, CarSort o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };
        Arrays.sort(car, compColor);
        System.out.println("-----------------List cars after sort by Color--------------------");
        printCarSort();
    }//end carSortByColorTest

    @Test
    void carSortByPriceTest() {
        System.out.println("-----------------List cars as is--------------------");
        printCarSort();
        Comparator<CarSort> compPrice = new Comparator<CarSort>() {
            @Override
            public int compare(CarSort o1, CarSort o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        };
        Arrays.sort(car, compPrice);
        System.out.println("-----------------List cars after sort by Price--------------------");
        printCarSort();
    }//end carSortByPriceTest

    @Test
    void carSortByYearTest() {
        System.out.println("-----------------List cars as is--------------------");
        printCarSort();
        Comparator<CarSort> compYear = new Comparator<CarSort>() {
            @Override
            public int compare(CarSort o1, CarSort o2) {
                return o1.getYear() - o2.getYear();
            }
        };
        Arrays.sort(car, compYear);
        System.out.println("-----------------List cars after sort by Year--------------------");
        printCarSort();
    }//end carSortByYearTest

    @Test
    void printCarSort() {
        for (int i = 0; i < car.length; i++) {
            System.out.println(car[i]);
        }//end for
    }//end printCarSort


}//end class