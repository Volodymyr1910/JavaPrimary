package HW11.best_offer.model;

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
}//end class
