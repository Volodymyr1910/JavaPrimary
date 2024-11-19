package HW11.dream_home;

import HW11.dream_home.model.Appartaments;
import HW11.dream_home.model.House;
import HW11.dream_home.model.Town;

public class DreamHomeOfferApplication {

    public static void main(String[] args) {

        // требования заказчика к жилью
        //String town; //Berlin
        //String postIndex; // 10117 or 10178 or 10179 индексы центальных раенов
        //String RangeToNearestPublicTransportStop; // not clother than 100 m, not futher than 500 m
        //String parkingSquare; // square not less than 1500 m^2
        //boolean parkingIsUnderGround; //false
        //int floor; // 2, 3, or 4
        //boolean elevator; //true
        //double livingArea; // from 80 to 130 m^2
        //int numberOfRooms; // from 3 to 5
        //boolean balcony; //true

        // у нас "дресс-код", всякие-разные не отвечающие требованиям - в "клуб" не зайдут !
        // проверка происходит на этапе конструктора и сеттеров
        System.out.println("-----Perfect Offer-----");
        Appartaments dreamAppartaments = new Appartaments("Berlin","10117","444 m","4444 m^2",false,4,true,100,4,true); // этот зайдет, все параметры в рамках требований
        System.out.println("-----Offer 1-----");
        Town offer1 = new Town("Leipzig", "04288");
        System.out.println("-----Offer 2-----");
        House offer2 = new House("Haale", "06124","2 km", "800 m^2", true, 4, false);
        System.out.println("-----Offer 3-----");
        Appartaments offer3 = new Appartaments("Berlin", "10178","200 m", "300 m^2",false,4,true,90.5, 4,true);
        System.out.println("-----Offer 4-----");
        Appartaments offer4 = new Appartaments("Berlin", "10179","3400 m", "2000 m^2",false,3,true,120, 5,false);
        System.out.println("-----Offer 5-----");
        Appartaments offer5 = new Appartaments("Berlin", "10178","350 m", "1600 m^2",false,3,false,83, 5,true);
        System.out.println("-----Offer 6-----"); // этот зайдет, все параметры в рамках требований
        Appartaments offer6 = new Appartaments("Berlin", "10117","400 m", "1800 m^2",false,2,true,85, 5,true);
        System.out.println("-----Offer 7-----");
        Appartaments offer7 = new Appartaments("Merseburg", "10117","400 m", "1800 m^2",false,2,true,85, 5,true);


        System.out.println("--------------------C-O-N-T-R-O-L---T-E-S-T-------------------");

        //проверка -> сеттер не дал установить значение LivingArea на не соответствующее требованиям заказчика
        dreamAppartaments.setLivingArea(200);
        System.out.println("No changes have been made. " + dreamAppartaments.getLivingArea() + " is still actual living area.");
        System.out.println("---***---");

        //проверка -> сеттер не дал установить значение Town на не соответствующее требованиям заказчика
        dreamAppartaments.setTown("Guantanamo");
        System.out.println("No changes have been made. " + dreamAppartaments.getTown() + " is still actual town.");
        System.out.println("---***---");

        //проверка -> сеттер не дал установить значение elevator на не соответствующее требованиям заказчика
        dreamAppartaments.setElevator(false);
        System.out.println("No changes have been made. " + dreamAppartaments.getElevator() + " is still actual requirement.");

    }//end main


}//end class
