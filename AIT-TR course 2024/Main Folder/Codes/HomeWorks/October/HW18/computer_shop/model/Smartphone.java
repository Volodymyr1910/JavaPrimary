package HW18.computer_shop.model;

public class Smartphone extends Laptop {

    private long imei;


    public Smartphone(String cpu, int ram, int ssd, String brand, double price, double screenSize, double weight, int batteryCapasity, String color, long imei) {
        super(cpu, ram, ssd, brand, price, screenSize, weight, batteryCapasity, color);
        this.imei = imei;
    }


    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }


    @Override
    public String toString() {
        return "Smartphone{" +
                "cpu='" + getCpu() + '\'' +
                ", ram=" + getRam() +
                ", ssd=" + getSsd() +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", screenSize=" + getScreenSize() +
                ", weight=" + getWeight() +
                ", batteryCapasity=" + getBatteryCapasity() +
                ", color='" + getColor() + '\'' +
                ", imei=" + imei +
                '}';
    }


}//end class

