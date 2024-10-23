package Day23.soldier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    Soldier[] soldiers;
//- "John", 182, 82.3, 91
//- "Peter", 175, 77.1, 75
//- "Robin", 162, 55.1, 91
//- "Mary", 159, 55.1, 91
//- "Ann", 162, 55, 88
    @BeforeEach
    void setUp() {

        soldiers = new Soldier[]{

                new Soldier("John", 182, 82.3, 91),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("John", 162, 55.1, 91),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Ann", 162, 55, 88),

        };
    }//end setUp

    //- отсортировать солдат "естественным" образом - по росту
    @Test
    void nativeSortingTest() {
        System.out.println("----------------------Print as is----------------------");
        printArray(soldiers);
        System.out.println("----------------------Print after native sorting----------------------");
        Arrays.sort(soldiers); //native by default
        printArray(soldiers);

    }//end nativeSortingTest

    //- отсортировать по имени
    @Test
    void sortByNameTest() {

        Comparator<Soldier> compByName = new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                return -o1.getName().compareTo(o2.getName()); // сортировка по имени в обратном порядке
                //return o2.getName().compareTo(o1.getName()); // сортировка по имени в обратном порядке
                //return o1.getName().compareTo(o2.getName()); // сортировка по имени в алфавитном порядке
            }
        };
        System.out.println("----------------------Print as is----------------------");
        printArray(soldiers);
        Arrays.sort(soldiers, compByName);
        System.out.println("----------------------Print after sorting by name----------------------");
        printArray(soldiers);
    }//end sortByNameTest

    //- по весу
    @Test
    void sortByWeightTest() {
        System.out.println("----------------------Print as is----------------------");
        printArray(soldiers);
        //Arrays.sort(soldiers, (o1, o2) -> (int) (o1.getWeight() - o2.getWeight())); //так массив сортанет неверно, т.к. int не видит дробную часть числа.
        Arrays.sort(soldiers, (o1, o2) -> Double.compare(o1.getWeight(), o2.getWeight()));
        System.out.println("----------------------Print after sorting by weight----------------------");
        printArray(soldiers);
    }// end sortByWeightTest


    //- по имени и росту  TWO and MORE factors for sorting;
    @Test
    void sortByNameAndHeight() {
        Comparator<Soldier> compNameAndHeight = new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                int res = o1.getName().compareTo(o2.getName());

                //return res != 0 ? res : Integer.compare(o1.getHeight(),o2.getHeight());
                return res != 0 ? res : o1.getHeight() - o2.getHeight();
            }
        };
        System.out.println("----------------------Print as is----------------------");
        printArray(soldiers);
        Arrays.sort(soldiers, compNameAndHeight);
        System.out.println("----------------------Print after sorting by name and height----------------------");
        printArray(soldiers);
    }//end sortByNameAndHeight


    // методу Arrays.sort передаем массив soldiers и условие предиката описанное с помощью тернарного оператора
    @Test
    void testSortSoldiersByProfileAndHeight() {
        printArray(soldiers);
        Arrays.sort(soldiers, (s1, s2) -> {
            int res = -(s1.getProfile() - s2.getProfile()); // сортировка по профилю в обратном порядке
            //return res !=0 ? res : - (s1.getHeight() - s2.getHeight()); //  А ЗАТЕМ сортировка по росту в обратном порядке
            //return res !=0 ? res : - Integer.compare(s1.getHeight(), s2.getHeight());
            return res != 0 ? res : Integer.compare(s2.getHeight(), s1.getHeight()); // все варианты одинаковы

        });
        printArray(soldiers);
    }//end testSortSoldiersByProfileAndHeight

    // сортировка по 3 параметрам
    @Test
    void testSortSoldiersByProfileHeightAndName() {

        System.out.println("----------------------Print as is----------------------");
        printArray(soldiers);

        Arrays.sort(soldiers, (s1, s2) -> {
            int res = s1.getProfile() - s2.getProfile(); // сортировка по профилю
            int res2 = s1.getHeight() - s2.getHeight(); //  А ЗАТЕМ сортировка по росту
            return (res != 0) ? res : (res2 != 0) ? res2 : s1.getName().compareTo(s2.getName()); // а ЗАТЕМ сорт по имени

        });
        System.out.println("----------------------Print after sorting by prifile, height and name----------------------");
        printArray(soldiers);


    }//end testSortSoldiersByProfileHeightAndName


    //- проверить работу метода binarySearch на массиве объектов
    @Test
    void binarySearchTest() {
        System.out.println("----------------------Print as is----------------------");
        printArray(soldiers);
        Arrays.sort(soldiers, (o1, o2) -> o1.profile - o2.profile);
        System.out.println("----------------------Print after sorting by profile----------------------");
        printArray(soldiers);

        // create object - pattern for searching
        Soldier pattern = new Soldier(null, 0, 0, 91);

        int index = Arrays.binarySearch(soldiers, pattern, (o1, o2) -> o1.profile - o2.profile);
        System.out.println("Index = " + index);

    }//end binarySearchTest


    public void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }//end for
    }//end printArray


}//end class