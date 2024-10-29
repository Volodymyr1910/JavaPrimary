package my_projects.animal_house.model_v2;

import java.util.Objects;

public class Dog_v2 extends DomesticAnimals {

    private static double training_coefficient = 1;

    private String breed;


    public double calcBreed_coefficient(String breed) {
        double breed_coefficient = 1.15;
        if ((breed.equals("Doberman")) | (breed.equals("Shepherd dog") )) breed_coefficient = 1;
        return breed_coefficient;
    }// end calcBreed_coefficient

    public Dog_v2(int id, double height, double weight, double age, boolean health, double trainingHourCost, int trainingHours, int friendlyLevel, String breed) {
        super(id, height, weight, age, health, trainingHourCost, trainingHours, friendlyLevel);
        this.breed = breed;
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
        if (!(o instanceof Dog_v2 dogV2)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(breed, dogV2.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dog_v2{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", health=").append(health);
        sb.append(", trainingHourCost=").append(trainingHourCost);
        sb.append(", trainingHours=").append(trainingHours);
        sb.append(", friendlyLevel=").append(getFriendlyLevel());
        sb.append(", breed='").append(breed).append('\'');
        sb.append('}');
        return sb.toString();
    }


    @Override
    public double calcSumOfMonthTraining() {
        double trainingHoursTemp = trainingHours + (((trainingHours * 10) / getFriendlyLevel()) * 0.1);
        double trainingHourCostTemp = trainingHourCost * (getWeight() / 15);
        double calcSum = trainingHourCostTemp * trainingHoursTemp * training_coefficient * calcBreed_coefficient(breed);
        return ensureTrainingCost(calcSum);

    }// end calcSumOfMonthTraining


}//end class
