package my_projects.animal_house.controller_v2;

import MyMethods.predicates.Predicate_method_notFinished;
import my_projects.animal_house.dao_v2.AnimalHouse_v2;
import my_projects.animal_house.model_v2.Animal;
import my_projects.animal_house.model_v2.WildAnimal;

public class AnimalHouseImplementation implements AnimalHouse_v2 {

    private Animal[] animals;
    private int size;

    public AnimalHouseImplementation(int capasity) {
        this.animals = new Animal[capasity];
        this.size = size;
    }


    @Override
    public boolean addAnimal(Animal animal) {

        if (animal == null) return false;
        if (size == animals.length) return false;
        if (animal == findAnimal(animal.getId())) return false;
        animals[size] = animal;
        size++;
        return true;

    }//end addAnimal

    @Override
    public Animal findAnimal(int id) {
        for (int i = 0; i < size; i++) {
            if (animals[i].getId() == id) return animals[i];
        }//end
        return null;
    }//findAnimal

    @Override
    public Animal removeAnimal(int id) {

        for (int i = 0; i < size; i++) {
            if (animals[i].getId() == id) {
                Animal victim = animals[i];
                //animals[i] = animals[size - 1];
                //size--;
                System.arraycopy(animals, i + 1, animals, i, animals.length - i - 1);
                animals[size--] = null;
                return victim;
            }//end if
        }//end fori
        return null;
    }//removeAnimal

    @Override
    public Animal[] findSickAnimals() {
        //Animal a = animal.isHealth();
        //return Predicate_method_notFinished.findObjectByPredicateWithReturnObjectArray(animals -> animals.() == false, animals);


        int count = 0;
        for (int i = 0; i < size; i++) {
            if (!(animals[i].isHealth())) count++;
        }//end fori
        if (count == 0) return  null;
        Animal sickAnimals [] = new Animal[count];
        for (int i = 0, j = 0; i < size; i++) {
            if(animals[i].isHealth() == false){
                sickAnimals[j] = animals[i];
                j++;
            }//end if
        }//end for
        return sickAnimals;
    }//end findSickAnimals

    @Override
    public Animal[] findPredatorAnimals() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (animals[i] instanceof WildAnimal){
               if (((WildAnimal) animals[i]).isPredator()) count++;
            }//end if
        }//end fori
        if (count == 0) return  null;
        Animal predators [] = new Animal[count];
        for (int i = 0, j = 0; i < size; i++) {
            if (animals[i] instanceof WildAnimal) {
                if ((((WildAnimal) animals[i]).isPredator()) == true) {
                    predators[j] = animals[i];
                    j++;
                }//end if
            }//end if
        }//end for
        return predators;
    }//end findPredatorAnimals

    @Override
    public Animal[] findOldestAnimal() {
        Animal oldAnimal = animals [0];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (animals[i].getAge() > oldAnimal.getAge()){
                oldAnimal = animals [i];
            }//end if
        }//end for
        //считаем сколько стариков
        double oldestYear = oldAnimal.getAge();
        for (int i = 0; i < size ; i++) {
            if(animals[i].getAge() == oldAnimal.getAge()){
                count++;
            }//end if
        }//end for
        //переносим всех стариков в новый массив
        Animal oldestAnimals [] = new Animal[count];
        for (int i = 0, j = 0; i < size; i++) {
            if(animals[i].getAge() == oldestYear){
                oldestAnimals[j] = animals[i];
                j++;
            }//end if
        }//end fori
        return oldestAnimals;
    }//end findOldestAnimal

    @Override
    public double averageWeightOfAnimals() {
        double sumOfWeight = 0;
        for (int i = 0; i < size; i++) {
            sumOfWeight += animals[i].getWeight();
        }//end for
        double averageWeight = sumOfWeight / size;
        return averageWeight;
    }//end averageWeightOfAnimals

    @Override
    public int quantityOfAnimals() {
        return size;
    }//end quantityOfAnimals

    @Override
    public void printAnimals() {
        for (int i = 0; i < size; i++) {
            System.out.println(animals[i]);
        }//end for
    }// end printAnimals
}//end class
