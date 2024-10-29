package my_projects.animal_house.model_v2;

import java.util.Objects;

public class Kangaroo extends WildAnimal {

    private static double training_coefficient = 2.5;

    private double jumpLenght;

    public Kangaroo(int id, double height, double weight, double age, boolean health, double trainingHourCost, int trainingHours, boolean predator, double jumpLenght) {
        super(id, height, weight, age, health, trainingHourCost, trainingHours, predator);
        this.jumpLenght = jumpLenght;
    }


    public double getJumpLenght() {
        return jumpLenght;
    }

    public void setJumpLenght(double jumpLenght) {
        this.jumpLenght = jumpLenght;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kangaroo kangaroo)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(jumpLenght, kangaroo.jumpLenght) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jumpLenght);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Kangaroo{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", health=").append(health);
        sb.append(", trainingHourCost=").append(trainingHourCost);
        sb.append(", trainingHours=").append(trainingHours);
        sb.append(", predator=").append(isPredator());
        sb.append(", jumpLenght=").append(jumpLenght);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcSumOfMonthTraining() {
        double trainingHourCostTemp = (((trainingHourCost * (weight / 10)) + ((((age / 100)  * 3) * trainingHourCost) + trainingHourCost) + (trainingHourCost + (trainingHourCost * (jumpLenght / 30)))) / 3);
        double calcSum = trainingHourCostTemp * trainingHours * training_coefficient;
        return ensureTrainingCost(calcSum);

    }//end calcSumOfMonthTraining


}//end class
