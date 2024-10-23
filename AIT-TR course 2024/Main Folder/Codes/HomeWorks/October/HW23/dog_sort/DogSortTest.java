package HW23.dog_sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DogSortTest {
    static DogSort[] dogs;

    @BeforeEach
    void setUp() {
        dogs = new DogSort[]{

                new DogSort(1, 12, 3.0, 2, true, 20, 100, 5, "Layka"),
                new DogSort(8, 49, 8, 3, true, 16, 205, 7, "Bulldog"),
                new DogSort(24, 180, 60, 5, false, 38, 12, 8, "Malamut"),
                new DogSort(73, 46, 46, 7, true, 54, 70, 10, "Spaniell"),
                new DogSort(5, 49, 44, 3, true, 13, 92, 3, "Doberman"),
                new DogSort(44, 49, 35, 3, true, 36, 34, 2, "Spaniel"),
                new DogSort(104, 16, 4, 4, false, 18, 2, 2, "Chau Chau"),
                new DogSort(12, 37, 32, 10, false, 54, 29, 1, "Shepherd dog"),
                new DogSort(66, 14, 4, 5, true, 22, 150, 4, "Doberman"),
        };
    }//end setUp

    @Test
    void sortById() {
        System.out.println("---------------------Before--------------");
        printDogs();
        Arrays.sort(dogs);
        System.out.println("---------------------after native sort--------------");
        printDogs();

    }//end sortById

    public static void printDogs() {
        for (int i = 0, count = 0; i < dogs.length; i++, count++) {
            System.out.println(count + " " + dogs[i]);
        }//end for
    }//end printAnimal

    @Test
    void sortByBreed() {
        System.out.println("---------------------Before--------------");
        printDogs();
        Comparator<DogSort> compBreed = new Comparator<DogSort>() {
            @Override
            public int compare(DogSort o1, DogSort o2) {
                return o1.getBreed().compareTo(o2.getBreed());
            }
        };
        Arrays.sort(dogs, compBreed);
        System.out.println("---------------------after sort by breed--------------");
        printDogs();
    }//end sortById

    @Test
    void sortByBreed_Age() {
        System.out.println("---------------------Before--------------");
        printDogs();
        Comparator<DogSort> compBreed_Age = new Comparator<DogSort>() {
            @Override
            public int compare(DogSort o1, DogSort o2) {
                int check0 = o1.getBreed().compareTo(o2.getBreed());
                return (check0 != 0) ? check0 : Double.compare(o1.getAge(), o2.getAge());
            }
        };
        Arrays.sort(dogs, compBreed_Age);
        System.out.println("---------------------after sort by breed and age--------------");
        printDogs();

        //---------------------after sort by breed and age--------------
        //2 DogSort{id=5, height=49.0, weight=44.0, age=3.0, health=true, trainingHourCost=13.0, trainingHours=92, friendlyLevel=3, breed='Doberman'}
        //3 DogSort{id=66, height=14.0, weight=4.0, age=5.0, health=true, trainingHourCost=22.0, trainingHours=150, friendlyLevel=4, breed='Doberman'}
        //7 DogSort{id=44, height=49.0, weight=35.0, age=3.0, health=true, trainingHourCost=36.0, trainingHours=34, friendlyLevel=2, breed='Spaniel'}
        //8 DogSort{id=73, height=46.0, weight=46.0, age=7.0, health=true, trainingHourCost=54.0, trainingHours=70, friendlyLevel=10, breed='Spaniell'}

    }//end sortByBreed_Age

    @Test
    void sortByAge_Height_Weight() {
        System.out.println("---------------------Before--------------");
        printDogs();
        Comparator<DogSort> compAge_Height_Weight = new Comparator<DogSort>() {
            @Override
            public int compare(DogSort o1, DogSort o2) {
                int check0 = Double.compare(o1.getAge(), o2.getAge());
                int check1 = Double.compare(o1.getHeight(), o2.getHeight());
                return (check0 != 0) ? check0 : (check1 != 0) ? check1 : Double.compare(o1.getWeight(), o2.getWeight());
            }
        };
        Arrays.sort(dogs, compAge_Height_Weight);
        System.out.println("---------------------after sort by age, height and weight--------------");
        printDogs();

        //-------------------after sort by age, height and weight--------------
        //1 DogSort{id=8, height=49.0, weight=8.0, age=3.0, health=true, trainingHourCost=16.0, trainingHours=205, friendlyLevel=7, breed='Bulldog'}
        //2 DogSort{id=44, height=49.0, weight=35.0, age=3.0, health=true, trainingHourCost=36.0, trainingHours=34, friendlyLevel=2, breed='Spaniel'}
        //3 DogSort{id=5, height=49.0, weight=44.0, age=3.0, health=true, trainingHourCost=13.0, trainingHours=92, friendlyLevel=3, breed='Doberman'}

    }//end sortByAge_Height_Weight

    @Test
    void sortByHealth_TrainingHours() {
        System.out.println("---------------------Before--------------");
        printDogs();
        Comparator<DogSort> compsortByHealth_TrainingHours = new Comparator<DogSort>() {
            @Override
            public int compare(DogSort o1, DogSort o2) {
                int check0 = -Boolean.compare(o1.isHealth(), o2.isHealth()); //reverse
                return (check0 != 0) ? check0 : o1.getTrainingHours() - o2.getTrainingHours();
            }
        };
        Arrays.sort(dogs, compsortByHealth_TrainingHours);
        System.out.println("---------------------after sort by health and training hours--------------");
        printDogs();
    }//end sortByHealth_TrainingHours

        //---------------------after sort by health and training hours--------------
        //0 DogSort{id=44, height=49.0, weight=35.0, age=3.0, health=true, trainingHourCost=36.0, trainingHours=34, friendlyLevel=2, breed='Spaniel'}
        //1 DogSort{id=73, height=46.0, weight=46.0, age=7.0, health=true, trainingHourCost=54.0, trainingHours=70, friendlyLevel=10, breed='Spaniell'}
        //2 DogSort{id=5, height=49.0, weight=44.0, age=3.0, health=true, trainingHourCost=13.0, trainingHours=92, friendlyLevel=3, breed='Doberman'}
        //3 DogSort{id=1, height=12.0, weight=3.0, age=2.0, health=true, trainingHourCost=20.0, trainingHours=100, friendlyLevel=5, breed='Layka'}
        //4 DogSort{id=66, height=14.0, weight=4.0, age=5.0, health=true, trainingHourCost=22.0, trainingHours=150, friendlyLevel=4, breed='Doberman'}
        //5 DogSort{id=8, height=49.0, weight=8.0, age=3.0, health=true, trainingHourCost=16.0, trainingHours=205, friendlyLevel=7, breed='Bulldog'}
        //6 DogSort{id=104, height=16.0, weight=4.0, age=4.0, health=false, trainingHourCost=18.0, trainingHours=2, friendlyLevel=2, breed='Chau Chau'}
        //7 DogSort{id=24, height=180.0, weight=60.0, age=5.0, health=false, trainingHourCost=38.0, trainingHours=12, friendlyLevel=8, breed='Malamut'}
        //8 DogSort{id=12, height=37.0, weight=32.0, age=10.0, health=false, trainingHourCost=54.0, trainingHours=29, friendlyLevel=1, breed='Shepherd dog'}

    @Test
    void binarySearchDogSort (){
        System.out.println("---------------------Before--------------");
        printDogs();

        Arrays.sort(dogs, ((o1, o2) -> Double.compare(o1.getTrainingHourCost(), o2.getTrainingHourCost())));
        System.out.println("---------------------after sort by health and training hours--------------");
        printDogs();

        DogSort example = new DogSort( 0,0,0,0,false,54, 0, 0, null);
        System.out.println("Index of dog with trainig cost 20$ is -> " + Arrays.binarySearch(dogs, example, (o1,o2) ->  Double.compare(o1.getTrainingHourCost(), o2.getTrainingHourCost())));

        //---------------------after sort by health and training hours--------------
        //0 DogSort{id=5, height=49.0, weight=44.0, age=3.0, health=true, trainingHourCost=13.0, trainingHours=92, friendlyLevel=3, breed='Doberman'}
        //1 DogSort{id=8, height=49.0, weight=8.0, age=3.0, health=true, trainingHourCost=16.0, trainingHours=205, friendlyLevel=7, breed='Bulldog'}
        //2 DogSort{id=104, height=16.0, weight=4.0, age=4.0, health=false, trainingHourCost=18.0, trainingHours=2, friendlyLevel=2, breed='Chau Chau'}
        //3 DogSort{id=1, height=12.0, weight=3.0, age=2.0, health=true, trainingHourCost=20.0, trainingHours=100, friendlyLevel=5, breed='Layka'}
        //4 DogSort{id=66, height=14.0, weight=4.0, age=5.0, health=true, trainingHourCost=22.0, trainingHours=150, friendlyLevel=4, breed='Doberman'}
        //5 DogSort{id=44, height=49.0, weight=35.0, age=3.0, health=true, trainingHourCost=36.0, trainingHours=34, friendlyLevel=2, breed='Spaniel'}
        //6 DogSort{id=24, height=180.0, weight=60.0, age=5.0, health=false, trainingHourCost=38.0, trainingHours=12, friendlyLevel=8, breed='Malamut'}
        //7 DogSort{id=73, height=46.0, weight=46.0, age=7.0, health=true, trainingHourCost=54.0, trainingHours=70, friendlyLevel=10, breed='Spaniell'}
        //8 DogSort{id=12, height=37.0, weight=32.0, age=10.0, health=false, trainingHourCost=54.0, trainingHours=29, friendlyLevel=1, breed='Shepherd dog'}

        //Index of dog with trainig cost 20$ is -> 7






    }//end binarySearchDogSort










}//end class