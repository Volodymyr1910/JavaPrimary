package HW11.best_offer;

import HW11.best_offer.model.OfferAppartaments;
import HW11.best_offer.model.OfferHouse;
import HW11.best_offer.model.OfferTown;
import HW11.dream_home.model.Town;
import MyMethods.array_methods.ArrayMethods_String;

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
        /*
        //проверка предложений на предмет соответствия требованиям заказчика
        // в цикле обращаемся к методам расположенным в супер-классе и дочерних классах
        for (int i = 0; i < offerArray.length; i++) {
            if (offerArray[i] instanceof OfferAppartaments) {
                if (offerArray[i].checkerOfferTown(offerArray[i])) {
                    if (((OfferAppartaments) offerArray[i]).checkerOfferHouse(offerArray[i])) {
                        if (((OfferAppartaments) offerArray[i]).checker1(((OfferAppartaments) offerArray[i]).getLivingArea(), ((OfferAppartaments) offerArray[i]).getNumberOfRooms(), ((OfferAppartaments) offerArray[i]).isBalcony())) {
                            System.out.println("Perfect offer has founded! -> offer " + (i+1) + " <-"); //если найдено предложение соответствующее всем затребованням условиям,
                            dreamAppartamentsTest = (OfferAppartaments) offerArray[i];                  // оно записывается в исходное нулевое поле и улетает по email заказчику
                            System.out.println(dreamAppartamentsTest.toString());
                        }else System.out.println("Offer " + (i + 1) + " proposed living area, number of rooms or absence of a balcony is unaccetable !");
                    }else System.out.println("Offer " + (i + 1) + " proposed parking, flor or absence of an elevator is unaccetable !");
                }else System.out.println("Offer " + (i + 1) + " proposed town or post index is unaccetable !");
            }else System.out.println("Offer " + (i + 1) + " does not have complete information !");
        }//end for


         */

        dreamAppartamentsTest = validator (offerArray);

    }//end main

    //проверка предложений на предмет соответствия требованиям заказчика
    // в цикле обращаемся к методам расположенным в супер-классе и дочерних классах
    public static OfferAppartaments validator (OfferTown [] offerArray){
        OfferAppartaments temp = null;

    for (int i = 0; i < offerArray.length; i++) {
        if (offerArray[i] instanceof OfferAppartaments) {
            if (offerArray[i].checkerOfferTown(offerArray[i])) {
                if (((OfferAppartaments) offerArray[i]).checkerOfferHouse(offerArray[i])) {
                    if (((OfferAppartaments) offerArray[i]).checker1(((OfferAppartaments) offerArray[i]).getLivingArea(), ((OfferAppartaments) offerArray[i]).getNumberOfRooms(), ((OfferAppartaments) offerArray[i]).isBalcony())) {
                        System.out.println("Perfect offer has founded! -> offer " + (i+1) + " <-"); //если найдено предложение соответствующее всем затребованням условиям,
                        temp = (OfferAppartaments) offerArray[i];                  // оно записывается в исходное нулевое поле и улетает по email заказчику
                        System.out.println(temp.toString());
                    }else System.out.println("Offer " + (i + 1) + " proposed living area, number of rooms or absence of a balcony is unaccetable !");
                }else System.out.println("Offer " + (i + 1) + " proposed parking, flor or absence of an elevator is unaccetable !");
            }else System.out.println("Offer " + (i + 1) + " proposed town or post index is unaccetable !");
        }else System.out.println("Offer " + (i + 1) + " does not have complete information !");
    }//end for
        return temp;
    }//end validator




}//end class
