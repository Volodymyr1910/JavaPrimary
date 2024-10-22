package HW18.product_v2.model_v2;

import java.util.Objects;

public class MeatFood_v2 extends Food_v2 {

    String meatType;

    public MeatFood_v2(double price, String name, long barCode, int quantityInStorage, String expDate, String meatType) {
        super(price, name, barCode, quantityInStorage, expDate);
        this.meatType = meatType;
    }


    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MeatFood_v2{");
        sb.append("price=").append(price);
        sb.append(", name='").append(name).append('\'');
        sb.append(", barCode=").append(barCode);
        sb.append(", quantityInStorage=").append(quantityInStorage);
        sb.append(", meatType='").append(meatType).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeatFood_v2 that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(meatType, that.meatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), meatType);
    }
}//end class
