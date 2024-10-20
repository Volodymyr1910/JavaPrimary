package HW18.animal_house.test_v2;

import HW18.animal_house.controller_v2.AnimalHouseImplementation;
import HW18.animal_house.dao_v2.AnimalHouse_v2;
import HW18.animal_house.model_v2.*;
import HW18.document_archive_v2.model_v2.Document_v2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalHouseImplementationTest {

 AnimalHouseImplementation animalHouse;
    Animal [] animal;

    @BeforeEach
    void setUp() {
        animalHouse = new AnimalHouseImplementation (10);
         animal = new Animal [9];

        animal [0] = new Cat_v2(1, 10, 3.0,2,true, 10, 100,5, "B1");
        animal [1] = new Dog_v2(2, 11, 3.0,3,true, 11, 110,7, "B2");
        animal [2] = new Kangaroo(3, 12, 3,3,false, 12, 120,false, 2.5);
        animal [3] = new Volf(4, 13, 3,4,true, 13, 130,true, 4);
        animal [4] = new Dog_v2(5, 14, 3,1,true, 14, 140,8, "Doberman");
        animal [5] = new Kangaroo(6, 15, 3,2,true, 15, 150,false, 1.8);
        animal [6] = new Cat_v2(7, 16, 3,3,false, 16, 160,2, "B4");
        animal [7] = new Volf(8, 17, 3,5,false, 17, 170,true, 6);
        animal [8] = new Cat_v2(9, 18, 3,5,true, 18, 180,4, "B6");


        for (int i = 0; i < 9; i++) {
           animalHouse.addAnimal(animal[i]);
        }//end fori
    }//end setUp

    @Test
    void addAnimalTest() {

        assertFalse(animalHouse.addAnimal(null));
        assertFalse(animalHouse.addAnimal(animal[0])); // пробуем добавить животное с дубликатом id

        //пробуем добавить кoгда есть место
        Animal an = new Dog_v2(10, 11, 3.1,3,true, 11, 110,7, "B10");
        assertTrue(animalHouse.addAnimal(an));

        //проверяем количество
        assertEquals(10, animalHouse.quantityOfAnimals());

        //пробуем добавить кoгда нет места
        Animal an0 = new Cat_v2(9, 18, 3.8,5,true, 18, 180,4, "B6");
        assertFalse(animalHouse.addAnimal(an0));

    }//end addAnimal

    @Test
    void findAnimalTest() {

        assertEquals(animal [6], animalHouse.findAnimal(7));

    }//end findAnimal

    @Test
    void removeAnimalTest() {

        //удаляем животное которого нет
        assertNull(animalHouse.removeAnimal(100009));

        //удаляем животное
        assertEquals(animal[2], animalHouse.removeAnimal(3));

        //проверяем количество
        assertEquals(8, animalHouse.quantityOfAnimals());

    }//end removeAnimal

    @Test
    void findSickAnimalsTest() {
        Animal [] sickAn = animalHouse.findSickAnimals();

        assertEquals(animal [2], sickAn[0]);
        assertEquals(animal [6], sickAn[1]);
        assertEquals(animal [7], sickAn[2]);
    }//end findSickAnimals

    @Test
    void findPredatorAnimalsTest() {
        Animal [] predators = animalHouse.findPredatorAnimals();

        assertEquals(animal [3], predators[0]);
        assertEquals(animal [7], predators[1]);
    }//endfindPredatorAnimalsTest

    @Test
    void findOldestAnimalTest() {
        Animal [] any = new Animal[2];
       any [0] = animal [7];
       any [1] = animal [8];

        assertArrayEquals(any, animalHouse.findOldestAnimal());

    }//end findOldestAnimalTest

    @Test
    void averageWeightOfAnimalsTest() {
        assertEquals(3, animalHouse.averageWeightOfAnimals());
    }//end

    @Test
    void quantityOfAnimalsTest() {
        assertEquals(9, animalHouse.quantityOfAnimals());
    }//endquantityOfAnimals

    @Test
    void printAnimalsTest() {
        System.out.println("-------------");
       animalHouse.printAnimals();
    }//end printAnimals
}//end class