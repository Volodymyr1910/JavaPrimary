package my_projects.findLivingPlace.best_offer;

import my_projects.findLivingPlace.best_offer.model.OfferAppartaments;
import my_projects.findLivingPlace.best_offer.model.OfferHouse;
import my_projects.findLivingPlace.best_offer.model.OfferTown;

public class BestOfferApplication {

    public static void main(String[] args) {


        // исходное нулевое поле, в случае заполения - отправляется заказчику по email
        OfferAppartaments dreamAppartamentsTest = new OfferAppartaments("", "", "", "", false, 0 , false, 0, 0, false);

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

        // список предложений может содержать сколько-угодно предложений
        OfferTown offer1 = new OfferTown("Leipzig", "04288");
        OfferHouse offer2 = new OfferHouse("Haale", "06124", "2 km", "800 m^2", true, 4, false);
        OfferAppartaments offer3 = new OfferAppartaments("Berlin", "10178", "200 m", "300 m^2", false, 4, true, 90.5, 4, true);
        OfferAppartaments offer4 = new OfferAppartaments("Berlin", "10179", "3400 m", "2000 m^2", false, 3, true, 120, 5, false);
        OfferAppartaments offer5 = new OfferAppartaments("Berlin", "10178", "350 m", "1600 m^2", false, 3, false, 83, 5, true);
        OfferAppartaments offer6 = new OfferAppartaments("berlin", "10117", "400 m", "1800 m^2", false, 2, true, 85, 5, true); //correct offer
        OfferAppartaments offer7 = new OfferAppartaments("Merseburg", "10117", "400 m", "1800 m^2", false, 2, true, 85, 5, true);

        OfferTown offerArray[] = new OfferTown[7]; //размер массива должен соответсвовать ко-ву предложений
        offerArray[0] = offer1;
        offerArray[1] = offer2;
        offerArray[2] = offer3;
        offerArray[3] = offer4;
        offerArray[4] = offer5;
        offerArray[5] = offer6;
        offerArray[6] = offer7;

        //печать общего списка предложений
        for (int i = 0; i < offerArray.length; i++) {
            System.out.println(offerArray[i].toString());
        }

        System.out.println("----------------------------------------------------------------------");

        dreamAppartamentsTest = OfferTown.validator (offerArray);

    }//end main

}//end class
