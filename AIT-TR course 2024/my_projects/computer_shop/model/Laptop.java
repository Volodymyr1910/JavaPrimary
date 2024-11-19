package my_projects.computer_shop.model;

public class Laptop extends Computer {


    private double screenSize;
    private double weight;
    private int batteryCapasity;
    private String color;

    public Laptop(String cpu, int ram, int ssd, String brand, double price, double screenSize, double weight, int batteryCapasity, String color) {
        super(cpu, ram, ssd, brand, price);
        this.screenSize = screenSize;
        this.weight = weight;
        this.batteryCapasity = batteryCapasity;
        this.color = color;
    }


    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getBatteryCapasity() {
        return batteryCapasity;
    }

    public void setBatteryCapasity(int batteryCapasity) {
        this.batteryCapasity = batteryCapasity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Laptop{");
        sb.append("cpu='").append(getCpu()).append('\'');
        sb.append(", ram=").append(getRam());
        sb.append(", ssd=").append(getSsd());
        sb.append(", brand='").append(getBrand()).append('\'');
        sb.append(", price=").append(getPrice());
        sb.append("screenSize=").append(screenSize);
        sb.append(", weight=").append(weight);
        sb.append(", batteryCapasity=").append(batteryCapasity);
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}//end class
