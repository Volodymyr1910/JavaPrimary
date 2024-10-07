package HW7.house.cat;

import HW1.pet.model.Pet;

public class Cat extends Pet {


    private String breed;
    private double height;
    private double weight;


    public Cat(int id, String type, double age, String petName, String breed, double height, double weight) {
        super(id, type, age, petName);
        this.breed = breed;
        this.height = height;
        this.weight = weight;
    }


    public void makeLoud() {
        System.out.println(getType() + " " + breed + " " + getPetName() + " making big noise meow meow !");
    }//end makeLoud










}//end class
