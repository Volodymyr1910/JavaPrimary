package my_projects.animal_house.model_v2;

import java.util.Objects;

public abstract class WildAnimal extends Animal {

    protected boolean predator;


    public WildAnimal(int id, double height, double weight, double age, boolean health, double trainingHourCost, int trainingHours, boolean predator) {
        super(id, height, weight, age, health, trainingHourCost, trainingHours);
        this.predator = predator;
    }


    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WildAnimal that)) return false;
        if (!super.equals(o)) return false;
        return predator == that.predator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), predator);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WildAnimal{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", health=").append(health);
        sb.append(", trainingHourCost=").append(trainingHourCost);
        sb.append(", trainingHours=").append(trainingHours);
        sb.append(", predator=").append(predator);
        sb.append('}');
        return sb.toString();
    }

}//end class
