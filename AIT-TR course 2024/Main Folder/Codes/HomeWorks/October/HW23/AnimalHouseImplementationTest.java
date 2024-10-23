package HW23;

import HW18.animal_house.dao_v2.AnimalHouse_v2;
import HW18.animal_house.model_v2.*;
import HW23.dog_sort.DogSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AnimalHouseImplementationTest {

    static Animal[] any;

    @BeforeEach
    void setUp() {

        any = new Animal[]{

                /*new Cat_v2(1, 12, 3.0, 2, true, 20, 100, 5, "B1"),
                new Dog_v2(8, 30, 8, 3, true, 16, 205, 7, "B2"),
                new Kangaroo(24, 180, 60, 5, false, 38, 12, false, 2.5),
                new Volf(73, 46, 46, 7, true, 54, 70, true, 4),
                new Dog_v2(5, 49, 44, 3, true, 13, 92, 8, "Doberman"),
                new Kangaroo(44, 130, 46, 3, true, 36, 34, false, 1.8),
                new Cat_v2(104, 16, 4, 4, false, 18, 2, 2, "B4"),
                new Volf(12, 37, 32, 10, false, 54, 29, true, 6),
                new Cat_v2(66, 14, 4, 5, true, 22, 150, 4, "B6"),*/


        };
    }//end setUp

    @Test
    void sortById() {
        System.out.println("---------------------Before--------------");
        printAnimal();
        Arrays.sort(any);
        System.out.println("---------------------after native sort--------------");
        printAnimal();

    }//end sortById

    public static void printAnimal() {

        for (int i = 0, count = 0; i < any.length; i++, count++) {
            System.out.println(count + " " + any[i]);
        }//end for
    }//end printAnimal


}//end class