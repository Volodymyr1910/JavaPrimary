package my_projects.findLivingPlace.best_offer.model;

import java.util.Objects;

public class OfferHouse extends OfferTown {

    private String rangeToNearestPublicTransportStop; // not clother than 100 m, not futher than 500 m
    private String parkingSquare; // square not less than 1500 m^2
    private boolean parkingIsUnderGround; //false
    private int floor; // 2, 3, or 4
    private boolean elevator; //true

    public OfferHouse(String town, String postIndex, String rangeToNearestPublicTransportStop, String parkingSquare, boolean parkingIsUnderGround, int floor, boolean elevator) {
        super(town, postIndex);
        this.rangeToNearestPublicTransportStop = rangeToNearestPublicTransportStop;
        this.parkingSquare = parkingSquare;
        this.parkingIsUnderGround = parkingIsUnderGround;
        this.floor = floor;
        this.elevator = elevator;
    }

    public String getRangeToNearestPublicTransportStop() {
        return rangeToNearestPublicTransportStop;
    }

    public void setRangeToNearestPublicTransportStop(String rangeToNearestPublicTransportStop) {
        this.rangeToNearestPublicTransportStop = rangeToNearestPublicTransportStop;
    }

    public String getParkingSquare() {
        return parkingSquare;
    }

    public void setParkingSquare(String parkingSquare) {
        this.parkingSquare = parkingSquare;
    }

    public boolean isParkingIsUnderGround() {
        return parkingIsUnderGround;
    }

    public void setParkingIsUnderGround(boolean parkingIsUnderGround) {
        this.parkingIsUnderGround = parkingIsUnderGround;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    @Override
    public String toString() {
        return "OfferHouse{" +
                "rangeToNearestPublicTransportStop='" + rangeToNearestPublicTransportStop + '\'' +
                ", parkingSquare='" + parkingSquare + '\'' +
                ", parkingIsUnderGround=" + parkingIsUnderGround +
                ", floor=" + floor +
                ", elevator=" + elevator +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferHouse that)) return false;
        if (!super.equals(o)) return false;
        return parkingIsUnderGround == that.parkingIsUnderGround && floor == that.floor && elevator == that.elevator && Objects.equals(rangeToNearestPublicTransportStop, that.rangeToNearestPublicTransportStop) && Objects.equals(parkingSquare, that.parkingSquare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rangeToNearestPublicTransportStop, parkingSquare, parkingIsUnderGround, floor, elevator);
    }

    //метод-начальник обращается к методу-подчиненному
    public boolean checkerOfferHouse (OfferTown array){
        if(checker1(getRangeToNearestPublicTransportStop(), parkingIsUnderGround, getFloor()) && checker1(getParkingSquare(), elevator)) return true;
        else return false;

    }

    //проверяет соответствие требованиям:
    //String RangeToNearestPublicTransportStop; // not clother than 100 m, not futher than 500 m
    //boolean parkingIsUnderGround; // false
    //int floor; // 2, 3, or 4
    public boolean checker1 (String str, boolean x, int n){
        String temp = str.substring(0,str.indexOf(' '));
        int tempp = Integer.parseInt(temp);
        if (((str.substring(str.indexOf(' ')+1)).equals("m")) &&  (tempp >= 100 && tempp <= 500) && (x == false) && (n > 1 && n < 5)) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //String parkingSquare; // square not less than 1500 m^2
    //boolean elevator; // true
    public boolean checker1 (String str, boolean x){
        String temp = str.substring(0,str.indexOf(' '));
        int tempp = Integer.parseInt(temp);
        if((((str.substring(str.indexOf(' ')+1)).equals("m^2")) &&  (tempp >= 1500)) && (x == true)) return true;
        else return false;
    }
}//end class
