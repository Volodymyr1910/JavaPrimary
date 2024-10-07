package HW7.house;

import HW1.pet.model.Pet;
import HW7.house.cat.Cat;
import HW7.house.dog.Dog;

public class HouseApplication {

    public static void main(String[] args) {

        Dog dog1 = new Dog(1, "Dog", 2, "Charlie", "Bulldog", 22.3, 7.5 );
        Dog dog2 = new Dog(3, "Dog", 3.5, "Rewe", "Doberman", 48, 16 );

        Cat cat1 = new Cat(2, "Cat", 2, "Pinky", "Maine-Coon", 17, 4 );
        Cat cat2 = new Cat(4, "Cat", 4, "Champion", "Burmila", 20, 6 );
        Cat cat3 = new Cat(5, "Cat", 1.5, "Alien", "Devon-Rex", 17, 4.3 );

        System.out.println(" Now is morning.");

        dog1.sleep();
        cat3.play();
        cat1.play();
        dog2.makeLoud();
        cat2.walking();

        System.out.println("13 O'clock ! Time to eat !");

        dog2.makeLoud();
        cat1.makeLoud();
        cat3.makeLoud();
        cat2.makeLoud();
        dog2.makeLoud();

        System.out.println("It's almost evening...");

        cat2.sleep();
        cat1.eat();
        dog2.play();
        cat3.play();
        dog1.makeLoud();

    }//end main




}//end class
