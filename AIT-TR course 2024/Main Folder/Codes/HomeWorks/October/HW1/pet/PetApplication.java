package HW1.pet;

import HW1.pet.model.Pet;

public class PetApplication {

    public static void main(String[] args) {

        Pet pet = new Pet(1, "Bulldog", 2, "Charlie" );
        Pet pet2 = new Pet(2, "Fox", 4, "Root" );
        Pet pet3 = new Pet(3, "Doberman", 3.5, "Rewe" );
        Pet pet4 = new Pet(4, "Wolf", 3, "Moon Shine" );

        System.out.println("Good morning, my friends ! 8 O'Clock ! Time to get up.");

        pet3.sleep();
        System.out.println("Number " + pet3.getId() + " present." + " Cammon, buddy, " + pet3.getPetName() + " get up !");
        pet4.eat();
        System.out.println("Number " + pet4.getId() + " is here." + " Don't look so strange " + pet4.getPetName() + " you allready have your food.");
        pet2.walking();
        System.out.println("Friend number " + pet2.getId() + " , I see. " + pet2.getPetName() + ", all is fine ?  Let me scratch yor back. Good, yes?");
        System.out.println("And the last one....");
        pet.play();
        pet.makeLoud();
        System.out.println("Hey !!! Take it easy !!! " + pet.getPetName() + " !!! Number " + pet.getId() + ". Good ! You really know what you want !");

        System.out.println(pet);
        System.out.println(pet2);
        System.out.println(pet3);
        System.out.println(pet4);
        System.out.println("Checking complete. Wait a minute...");
        System.out.println(pet.getPetName() + " you are got older. An important day! I need make notifications.");
        pet.setAge(3);
        System.out.println(pet + " Now all is correct !");

    }// end main

}//end class
