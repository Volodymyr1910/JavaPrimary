package HW18.animal_house.dao_v2;

import HW18.animal_house.model_v2.Animal;
import HW18.details_trade_v2.details_v2.model_v2.Detail_v2;

public interface AnimalHouse_v2 {

    //добавить животное
    boolean addAnimal(Animal animal);

    //найти животное по id
    Animal findAnimal(int id);

    //удалить животное
    Animal removeAnimal(int id);

    //найти всех больных животных
    Animal [] findSickAnimals();

    //найти всех хищных животных
    Animal [] findPredatorAnimals();

    //самые старые животные
    Animal [] findOldestAnimal();

    //средний вес постояльцев
    double averageWeightOfAnimals();

    // ко-во животных в приюте
    int quantityOfAnimals ();

    //распечатать список животных
    void printAnimals ();














}//end interface
