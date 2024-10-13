package HW11.best_offer.model;

import java.util.Objects;

public class OfferAppartaments extends OfferHouse {

    private double livingArea;
    private int numberOfRooms;
    private boolean balcony;

    public OfferAppartaments(String town, String postIndex, String rangeToNearestPublicTransportStop, String parkingSquare, boolean parkingIsUnderGround, int floor, boolean elevator, double livingArea, int numberOfRooms, boolean balcony) {
        super(town, postIndex, rangeToNearestPublicTransportStop, parkingSquare, parkingIsUnderGround, floor, elevator);
        this.livingArea = livingArea;
        this.numberOfRooms = numberOfRooms;
        this.balcony = balcony;
    }

    public double getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(double livingArea) {
        this.livingArea = livingArea;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    @Override
    public String toString() {
        return "OfferAppartaments{" +
                "livingArea=" + livingArea +
                ", numberOfRooms=" + numberOfRooms +
                ", balcony=" + balcony +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferAppartaments that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(livingArea, that.livingArea) == 0 && numberOfRooms == that.numberOfRooms && balcony == that.balcony;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livingArea, numberOfRooms, balcony);
    }

    //проверяет соответствие требованиям:
    //double livingArea; // from 80 to 130 m^2
    //int numberOfRooms; // from 3 to 5
    //boolean balcony; //true
    public boolean checker1 (double n, int num, boolean x){
        if ((n >= 80 && n <= 130) && (num > 2 && num < 6) && (x == true) ) return true;
        else return false;
    }





}//end class
