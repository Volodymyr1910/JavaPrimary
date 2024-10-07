package Day7.computer_shop.model;

public class Laptop extends Computer{


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
        return "Laptop{" +
                "screenSize=" + screenSize +
                ", weight=" + weight +
                ", batteryCapasity=" + batteryCapasity +
                ", color='" + color + '\'' +
                "} " + super.toString();
    }







}//end class
