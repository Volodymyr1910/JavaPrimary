package HW18.people.model;

public class Human {

    boolean gender; // default modifier - not presents. Классы лежащие в пакете model будут видеть друг друга,
    double height;     // модификаторы по умолчанию видны в пределах пакета
    double weight;
    String race;
    String country;
    String eyeColor;

    public Human(boolean gender, double height, double weight, String race, String country, String eyeColor) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.race = race;
        this.country = country;
        this.eyeColor = eyeColor;
    }


    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }


    @Override
    public String toString() {
        return "Human{" +
                "gender=" + gender +
                ", height=" + height +
                ", weight=" + weight +
                ", race='" + race + '\'' +
                ", country='" + country + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }







}//end class
