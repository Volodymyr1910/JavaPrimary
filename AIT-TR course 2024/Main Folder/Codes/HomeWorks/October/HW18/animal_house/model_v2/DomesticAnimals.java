package HW18.animal_house.model_v2;

import java.util.Objects;

public abstract class DomesticAnimals extends Animal{

    private int friendlyLevel; // from 1 to 10 -> 10 is completely friendly; 1 -> is neutral

    public DomesticAnimals(int id, double height, double weight, double age, boolean health, double trainingHourCost, int trainingHours, int friendlyLevel) {
        super(id, height, weight, age, health, trainingHourCost, trainingHours);
        this.friendlyLevel = friendlyLevel;
    }

    public int getFriendlyLevel() {
        return friendlyLevel;
    }

    public void setFriendlyLevel(int friendlyLevel) {
        this.friendlyLevel = friendlyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DomesticAnimals that)) return false;
        if (!super.equals(o)) return false;
        return friendlyLevel == that.friendlyLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), friendlyLevel);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DomesticAnimals{");
        sb.append("id=").append(id);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", health=").append(health);
        sb.append(", trainingHourCost=").append(trainingHourCost);
        sb.append(", trainingHours=").append(trainingHours);
        sb.append(", friendlyLevel=").append(friendlyLevel);
        sb.append('}');
        return sb.toString();
    }



}//end class
