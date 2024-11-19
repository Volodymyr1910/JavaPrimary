package HW23.dog_sort;

import java.util.Objects;

public class DogSort implements Comparable <DogSort> {

    private int id;
    private double height;
    private double weight;
    private double age;
    private boolean health;
    private double trainingHourCost;
    private int trainingHours;
    private int friendlyLevel;
    private String breed;


    public DogSort(int id, double height, double weight, double age, boolean health, double trainingHourCost, int trainingHours, int friendlyLevel, String breed) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.health = health;
        this.trainingHourCost = trainingHourCost;
        this.trainingHours = trainingHours;
        this.friendlyLevel = friendlyLevel;
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isHealth() {
        return health;
    }

    public void setHealth(boolean health) {
        this.health = health;
    }

    public double getTrainingHourCost() {
        return trainingHourCost;
    }

    public void setTrainingHourCost(double trainingHourCost) {
        this.trainingHourCost = trainingHourCost;
    }

    public int getTrainingHours() {
        return trainingHours;
    }

    public void setTrainingHours(int trainingHours) {
        this.trainingHours = trainingHours;
    }

    public int getFriendlyLevel() {
        return friendlyLevel;
    }

    public void setFriendlyLevel(int friendlyLevel) {
        this.friendlyLevel = friendlyLevel;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DogSort dogSort)) return false;
        return id == dogSort.id && Double.compare(height, dogSort.height) == 0 && Double.compare(weight, dogSort.weight) == 0 && Double.compare(age, dogSort.age) == 0 && health == dogSort.health && Double.compare(trainingHourCost, dogSort.trainingHourCost) == 0 && trainingHours == dogSort.trainingHours && friendlyLevel == dogSort.friendlyLevel && Objects.equals(breed, dogSort.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, weight, age, health, trainingHourCost, trainingHours, friendlyLevel, breed);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DogSort{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", health=").append(health);
        sb.append(", trainingHourCost=").append(trainingHourCost);
        sb.append(", trainingHours=").append(trainingHours);
        sb.append(", friendlyLevel=").append(friendlyLevel);
        sb.append(", breed='").append(breed).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(DogSort o) {
        return this.getId() - o.getId();
    }//end compareTo
}//end class
