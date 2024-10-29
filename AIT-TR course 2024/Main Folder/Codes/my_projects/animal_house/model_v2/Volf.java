package my_projects.animal_house.model_v2;

import java.util.Objects;

public class Volf extends WildAnimal {

    private static double training_coefficient = 4;

    private int agressionLevel;


    public Volf(int id, double height, double weight, double age, boolean health, double trainingHourCost, int trainingHours, boolean predator, int agressionLevel) {
        super(id, height, weight, age, health, trainingHourCost, trainingHours, predator);
        this.agressionLevel = agressionLevel;
    }

    public int getAgressionLevel() {
        return agressionLevel;
    }

    public void setAgressionLevel(int agressionLevel) {
        this.agressionLevel = agressionLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volf volf)) return false;
        if (!super.equals(o)) return false;
        return agressionLevel == volf.agressionLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), agressionLevel);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Volf{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", health=").append(health);
        sb.append(", trainingHourCost=").append(trainingHourCost);
        sb.append(", trainingHours=").append(trainingHours);
        sb.append(", predator=").append(isPredator());
        sb.append(", agressionLevel=").append(agressionLevel);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcSumOfMonthTraining() {

        double trainingHourCostTemp = (((trainingHourCost * (weight / 10)) + ((((age / 100)  * 3) * trainingHourCost) + trainingHourCost) + (trainingHourCost + (trainingHourCost * (agressionLevel / 3.5)))) / 3);
        double calcSum = trainingHourCostTemp * trainingHours * training_coefficient;
        return ensureTrainingCost(calcSum);



    }//end calcSumOfMonthTraining


}//end class
