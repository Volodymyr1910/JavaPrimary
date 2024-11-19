package my_projects.computer_shop.model;

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
        final StringBuilder sb = new StringBuilder("Smartphone{");
        sb.append("cpu='").append(getCpu()).append('\'');
        sb.append(", ram=").append(getRam());
        sb.append(", ssd=").append(getSsd());
        sb.append(", brand='").append(getBrand()).append('\'');
        sb.append(", price=").append(getPrice());
        sb.append("screenSize=").append(getScreenSize());
        sb.append(", weight=").append(getWeight());
        sb.append(", batteryCapasity=").append(getBatteryCapasity());
        sb.append(", color='").append(getColor()).append('\'');
        sb.append("imei=").append(imei);
        sb.append('}');
        return sb.toString();
    }
}//end class

