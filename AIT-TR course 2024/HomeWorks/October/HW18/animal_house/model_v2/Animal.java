package HW18.animal_house.model_v2;

import java.util.Objects;

public abstract class Animal {

    private static double trainingHour_minCost = 10.05;

    protected final int id;
    protected double height;
    protected double weight;
    protected double age;
    protected boolean health;
    protected double trainingHourCost;
    protected int trainingHours;


    public static double getTrainingHour_minCost (){
        return trainingHour_minCost;
    }//end getTrainingHour_minCost

    public static void setTrainingHour_minCost ( double t){
        if (trainingHour_minCost > Animal.trainingHour_minCost) Animal.trainingHour_minCost = trainingHour_minCost;
    }// setTrainingHour_minCost

    public Animal(int id, double height, double weight, double age, boolean health, double trainingHourCost, int trainingHours) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.health = health;
        this.trainingHourCost = trainingHourCost;
        this.trainingHours = trainingHours;
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return id == animal.id && Double.compare(height, animal.height) == 0 && Double.compare(weight, animal.weight) == 0 && Double.compare(age, animal.age) == 0 && health == animal.health && Double.compare(trainingHourCost, animal.trainingHourCost) == 0 && trainingHours == animal.trainingHours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, height, weight, age, health, trainingHourCost, trainingHours);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", health=").append(health);
        sb.append(", trainingHourCost=").append(trainingHourCost);
        sb.append(", trainingHours=").append(trainingHours);
        sb.append('}');
        return sb.toString();
    }


    public abstract double calcSumOfMonthTraining ();

    public double ensureTrainingCost (double sumOfMonthTraining){
        if (sumOfMonthTraining < trainingHourCost * trainingHours) {
            System.out.println("Sum of month training can't be lower than minimum. Setting min value. ");
            sumOfMonthTraining = trainingHourCost * trainingHours;
        }//end if
        return sumOfMonthTraining;
    }//end ensureTrainingCost




}//end class
