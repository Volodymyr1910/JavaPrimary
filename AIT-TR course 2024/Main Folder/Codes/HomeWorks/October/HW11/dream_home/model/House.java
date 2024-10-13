package HW11.dream_home.model;

import java.util.Objects;

public class House extends Town{

    private String rangeToNearestPublicTransportStop;
    private String parkingSquare;
    private boolean parkingIsUnderGround;
    private int floor;
    private boolean elevator;

    public House(String town, String postIndex, String rangeToNearestPublicTransportStop, String parkingSquare, boolean parkingIsUnderGround, int floor, boolean elevator) {
        super(town, postIndex);
        setRangeToNearestPublicTransportStop(rangeToNearestPublicTransportStop);
        setParkingSquare(parkingSquare);
        setParkingIsUnderGround(parkingIsUnderGround);
        setFloor(floor);
       setElevator(elevator);

    }

    public String getRangeToNearestPublicTransportStop() {
        return rangeToNearestPublicTransportStop;
    }

    public void setRangeToNearestPublicTransportStop(String rangeToNearestPublicTransportStop) {
        if (checker3(rangeToNearestPublicTransportStop)) this.rangeToNearestPublicTransportStop = rangeToNearestPublicTransportStop;
        else System.out.println("The proposed range to nearest public transport stop is unaccetable !");
    }

    public String getParkingSquare() {
        return parkingSquare;
    }

    public void setParkingSquare(String parkingSquare) {
        if (checker4(parkingSquare)) this.parkingSquare = parkingSquare;
        else System.out.println("The proposed parking is unaccetable !");
    }

    public boolean getParkingIsUnderGround() {
        return parkingIsUnderGround;
    }

    public void setParkingIsUnderGround(boolean parkingIsUnderGround) {
        if (checker5(parkingIsUnderGround)) this.parkingIsUnderGround = parkingIsUnderGround;
        else System.out.println("Underground parking is unaccetable !");
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        if (checker6(floor)) this.floor = floor;
        else System.out.println("The proposed floor is unaccetable !");
    }

    public boolean getElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        if (checker7(elevator)) this.elevator = elevator;
        else System.out.println("The absence of an elevator is unaccetable !");
    }

    @Override
    public String toString() {
        return "House{" +
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
        if (!(o instanceof House house)) return false;
        if (!super.equals(o)) return false;
        return parkingIsUnderGround == house.parkingIsUnderGround && floor == house.floor && elevator == house.elevator && Objects.equals(rangeToNearestPublicTransportStop, house.rangeToNearestPublicTransportStop) && Objects.equals(parkingSquare, house.parkingSquare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rangeToNearestPublicTransportStop, parkingSquare, parkingIsUnderGround, floor, elevator);
    }

    //проверяет соответствие требованиям:
    //String RangeToNearestPublicTransportStop; // not clother than 100 m, not futher than 500 m
    public boolean checker3 (String str){
        String temp = str.substring(0,str.indexOf(' '));
        int tempp = Integer.parseInt(temp);
        if (((str.substring(str.indexOf(' ')+1)).equals("m")) &&  (tempp >= 100 && tempp <= 500)) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //String parkingSquare; // square not less than 1500 m^2
    public boolean checker4 (String str){
        String temp = str.substring(0,str.indexOf(' '));
        int tempp = Integer.parseInt(temp);
        if((((str.substring(str.indexOf(' ')+1)).equals("m^2")) &&  (tempp >= 1500))) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //boolean parkingIsUnderGround; // false
    public boolean checker5 (boolean x){
        if (x == false) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //int floor; // 2, 3, or 4
    public boolean checker6 (int n){
        if(n > 1 && n < 5) return true;
        else return false;
    }

    //проверяет соответствие требованиям:
    //boolean elevator; // true
    public boolean checker7 (boolean x){
        return x;
    }

}//end class
