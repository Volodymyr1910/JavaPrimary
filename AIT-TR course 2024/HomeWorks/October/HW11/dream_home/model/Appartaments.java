package HW11.dream_home.model;

import java.util.Objects;

public class Appartaments extends House{

    private double livingArea;
    private int numberOfRooms;
    private boolean balcony;

    public Appartaments(String town, String postIndex, String rangeToNearestPublicTransportStop, String parkingSquare, boolean parkingIsUnderGround, int floor, boolean elevator, double livingArea, int numberOfRooms, boolean balcony) {
        super(town, postIndex, rangeToNearestPublicTransportStop, parkingSquare, parkingIsUnderGround, floor, elevator);
        setLivingArea(livingArea);
        setNumberOfRooms(numberOfRooms);
        setBalcony(balcony);
    }

    public double getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(double livingArea) {
        if (checker8 (livingArea)) this.livingArea = livingArea;
        else System.out.println("The proposed living area is unaccetable !");
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        if (checker9(numberOfRooms)) this.numberOfRooms = numberOfRooms;
        else System.out.println("The proposed number of rooms is unaccetable !");
    }

    public boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        if(checker10(balcony)) this.balcony = balcony;
        else System.out.println("The absence of a balcony is unaccetable");
    }

    @Override
    public String toString() {
        return "Appartaments{" +
                "livingArea=" + livingArea +
                ", numberOfRooms=" + numberOfRooms +
                ", balcony=" + balcony +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appartaments that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(livingArea, that.livingArea) == 0 && numberOfRooms == that.numberOfRooms && balcony == that.balcony;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), livingArea, numberOfRooms, balcony);
    }

    //проверяет соответствие требованиям:
    //double livingArea; // from 80 to 130 m^2
    public boolean checker8 (double n){
        if (n >= 80 && n <= 130) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //int numberOfRooms; // from 3 to 5
    public boolean checker9 (int n){
        if (n > 2 && n < 6) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //boolean balcony; //true
    public boolean checker10 (boolean x){
        return x;
    }
}//end class
