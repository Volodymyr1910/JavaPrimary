package HW18.product_v2.model_v2;

import java.util.Objects;

public class Food_v2 extends Product_v2 {


    private String expDate;

    public Food_v2(double price, String name, long barCode, int quantityInStorage, String expDate) {
        super(price, name, barCode, quantityInStorage);
        setExpDate(expDate);
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        if (checker (expDate)) this.expDate = expDate;
        else System.out.println("Expire date wrong format.");
    }//end setExpDate

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Food_v2{");
        sb.append("price=").append(price);
        sb.append(", name='").append(name).append('\'');
        sb.append(", barCode=").append(barCode);
        sb.append(", quantityInStorage=").append(quantityInStorage);
        sb.append(", expDate='").append(expDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food_v2 foodV2)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(expDate, foodV2.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expDate);
    }

    public boolean checker (String expDate){
        if(expDate.matches("([0-9][0-9][0-9][1-9]|[0-9][0-9][1-9][0-9]|[0-9][1-9][0-9][0-9]|[1-9][0-9][0-9][0-9])(-|.|_)([0][1-9]|[1][1-2]|[a-z][a-z][a-z]|[A-Z][a-z][a-z]|[A-Z][A-Z][A-Z]|[a-z][a-z]|[A-Z][a-z]|[A-Z][A-Z]|[A-Z][A-Z][A-Z][A-Z]|[a-z][a-z][a-z][a-z]|[A-Z][a-z][a-z][a-z])(-|.|_)([0][1-9]|[1-2][0-9]|[3][0-1])")) return true;
        else return false;
    }//end checker



}//end class
