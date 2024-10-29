package my_projects.computer_shop;

import my_projects.computer_shop.model.Computer;
import my_projects.computer_shop.model.Laptop;
import my_projects.computer_shop.model.Smartphone;


//Найти общий вес всех мобильных устройств в ComputerShop.
//Какой общий объем памяти у всех устройств на складе?
//Какова общая стоимость всех устройств на складе?
public class ShopApplication {
    public static void main(String[] args) {


        Computer computer = new Computer("i7", 8,256, "Acer", 1200);
        System.out.println(computer);

        Laptop laptop = new Laptop("M2", 16,256,"HP", 1850, 22.5, 1.5, 10, "Blue");
        System.out.println(laptop);

        Computer[] computers = new Computer[6]; // тип данных Computer (родительский класс), computers - название массива

        computers[0] = new Computer("i7", 8,256, "Acer", 1200);
        computers[1] = new Computer("i5", 16,256, "HP", 1500);
        computers[2] = new Computer("AMD", 8,256, "NoName", 2000); // no casting
        computers[3] = new Laptop("Apple", 8,256, "MacBook", 2000,14.3,1.5,10,"White"); // down casting
        computers[4] = new Laptop("iCore12", 16,1024, "MacBook Air", 2500,18.3,1.8,12,"Black"); // down casting
        computers[5] = new Smartphone("Snap Dragon", 8, 128, "Samsung", 400, 7.5,0.150, 20, "Silver",123456789012345l); // down casting

        //finding weight
        double totalWeight = 0;

        for (int i = 0; i < computers.length; i++) {
            if (computers[i] instanceof Laptop){
                Laptop myLaptop = (Laptop)computers[i]; // upper casting
                totalWeight += myLaptop.getWeight();
            }//end if
        }//end for
        System.out.println("Total weight -> " + totalWeight);
        System.out.println("=====================================");




        //--------------------
        int totalSsd = 0;

        for (int i = 0; i < computers.length; i++) {
            totalSsd += computers[i].getSsd();
        }//end for
        System.out.println("Total SSD is -> " + totalSsd + ".");

        double totalPrice = 0;

        for (int i = 0; i < computers.length; i++) {
            totalPrice += computers[i].getPrice();
        }//end for
        System.out.println("Total price is -> " + totalPrice + ".");

        for (int i = 0; i < computers.length; i++) {
            System.out.println(computers[i]);
        }//end for
        System.out.println("----------------------------");

        for (int i = 0; i < computers.length; i++) {
            System.out.println(computers[i].getBrand());
        }//end for

        Smartphone smartphone = new Smartphone("Snap Dragon", 8, 128, "Samsung", 400, 7.5,0.150, 20, "Silver",123456789012345l);
        System.out.println(smartphone.toString());






    }//end main
}//end class
