package HW18.product_v2.model_v2;

import java.util.Objects;

public class MilkFood_v2 extends Food_v2 {


    private String milkType;
    private double fat;


    public MilkFood_v2(double price, String name, long barCode, int quantityInStorage, String expDate, String milkType, double fat) {
        super(price, name, barCode, quantityInStorage, expDate);
        this.milkType = milkType;
        this.fat = fat;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MilkFood_v2{");
        sb.append("price=").append(price);
        sb.append(", name='").append(name).append('\'');
        sb.append(", barCode=").append(barCode);
        sb.append(", quantityInStorage=").append(quantityInStorage);
        sb.append(", milkType='").append(milkType).append('\'');
        sb.append(", fat=").append(fat);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilkFood_v2 that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(fat, that.fat) == 0 && Objects.equals(milkType, that.milkType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), milkType, fat);
    }
}//end class
