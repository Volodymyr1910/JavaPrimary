package HW18.product_v2.model_v2;

import java.util.Objects;

public abstract class Product_v2 {

    protected double price;
    protected String name;
    protected long barCode;
    protected int quantityInStorage;


    public Product_v2(double price, String name, long barCode, int quantityInStorage) {
        this.price = price;
        this.name = name;
        this.barCode = barCode;
        this.quantityInStorage = quantityInStorage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public int getQuantityInStorage() {
        return quantityInStorage;
    }

    public void setQuantityInStorage(int quantityInStorage) {
        this.quantityInStorage = quantityInStorage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product_v2{");
        sb.append("price=").append(price);
        sb.append(", name='").append(name).append('\'');
        sb.append(", barCode=").append(barCode);
        sb.append(", quantityInStorage=").append(quantityInStorage);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product_v2 productV2)) return false;
        return Double.compare(price, productV2.price) == 0 && barCode == productV2.barCode && quantityInStorage == productV2.quantityInStorage && Objects.equals(name, productV2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, barCode, quantityInStorage);
    }
}//end class
