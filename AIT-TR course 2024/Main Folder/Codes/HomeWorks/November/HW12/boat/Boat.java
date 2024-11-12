package HW12.boat;

import org.w3c.dom.ls.LSOutput;

//производитель(верфь);
//страна (флаг);
//год выпуска;
//длина;
//материал корпуса (дерево, пластик, металл);
//стоимость.
public class Boat {

    private String manufacturer;
    private String country;
    private int year;
    private double lenght;
    private String material;
    private  int price;

    public Boat(String manufacturer, String country, int year, double lenght, String material, int price) {
        this.manufacturer = manufacturer;
        this.country = country;
        this.year = year;
        this.lenght = lenght;
        this.material = material;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getLenght() {
        return lenght;
    }

    public String getMaterial() {
        return material;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Boat: " + "manufacturer -> " + manufacturer + ", country -> " + country + ", year -> " + year + ", lenght -> " + lenght + ", material -> " + material + ", price -> " + price;
    }
}//end class
