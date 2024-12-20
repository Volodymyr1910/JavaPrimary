package my_projects.findLivingPlace.best_offer.model;

import java.util.Objects;

public class OfferTown {

    private String town; //Berlin
    private String postIndex; // 10117 or 10178 or 10179

    public OfferTown(String town, String postIndex) {
        this.town = town;
        this.postIndex = postIndex;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    @Override
    public String toString() {
        return "OfferTown{" +
                "town='" + town + '\'' +
                ", postIndex='" + postIndex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferTown offerTown)) return false;
        return Objects.equals(town, offerTown.town) && Objects.equals(postIndex, offerTown.postIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, postIndex);
    }
    //метод-начальник обращается к двум методам-подчиненным
    public boolean checkerOfferTown (OfferTown array){
        if(checker1(getTown()) && checker2(getPostIndex())) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //String town; // Berlin
    public boolean checker1 (String str){
        if(str.equalsIgnoreCase("Berlin"))  return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //String postIndex; // 10117 or 10178 or 10179
    public boolean checker2 (String str){
        if(str.equals("10117") | str.equals("10178") | str.equals("10179")) return true;
        else return false;
    }

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
