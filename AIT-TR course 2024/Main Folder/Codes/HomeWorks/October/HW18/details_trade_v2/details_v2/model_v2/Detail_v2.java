package HW18.details_trade_v2.details_v2.model_v2;

import java.util.Objects;

public abstract class Detail_v2 {

    protected static int minOrderFromVendor = 3000;

    protected long barCode;
    protected double size;
    protected String material;
    protected double weight;
    protected String vendor;
    protected double sparePartCost;
    protected int quantityOfOrderedSparePart;

    public static int getMinOrderFromVendor (){
        return minOrderFromVendor;
    }//int getMinOrderFromVendor

    //не позволить оформить заказ на сумму меньше минимальной
    public static void setMinOrderFromVendor (int minOrderFromVendor){
        if(minOrderFromVendor > Detail_v2.minOrderFromVendor){
            Detail_v2.minOrderFromVendor = minOrderFromVendor;
        }//end if
    }//end setMinOrderFromVendor

    public Detail_v2(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOrderedSparePart) {
        this.barCode = barCode;
        this.size = size;
        this.material = material;
        this.weight = weight;
        this.vendor = vendor;
        this.sparePartCost = sparePartCost;
        this.quantityOfOrderedSparePart = quantityOfOrderedSparePart;
    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getSparePartCost() {
        return sparePartCost;
    }

    public void setSparePartCost(double sparePartCost) {
        this.sparePartCost = sparePartCost;
    }

    public int getQuantityOfOrderedSparePart() {
        return quantityOfOrderedSparePart;
    }

    public void setQuantityOfOderedSparePart(int quantityOfOrderedSparePart) {
        this.quantityOfOrderedSparePart = quantityOfOrderedSparePart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail_v2 detail)) return false;
        return barCode == detail.barCode;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(barCode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Detail{");
        sb.append("barCode=").append(barCode);
        sb.append(", size=").append(size);
        sb.append(", material='").append(material).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", vendor='").append(vendor).append('\'');
        sb.append(", sparePartCost=").append(sparePartCost);
        sb.append(", quantityOfOrderedSparePart=").append(quantityOfOrderedSparePart);
        sb.append('}');
        return sb.toString();
    }

    public abstract double calcOrderSum ();

    protected double ensureOrderSum (double orderSum){
        if (minOrderFromVendor > quantityOfOrderedSparePart * sparePartCost){
            System.out.println("Your order sum is " + orderSum + "$. Min oder sum is " + minOrderFromVendor + "$. You will pay this any way.");
            System.out.println("You must reorder another " + (minOrderFromVendor - orderSum) + "$ to the min order, which is an additional " + ((minOrderFromVendor - orderSum) / sparePartCost) + " pieces of spare parts." );
            orderSum = minOrderFromVendor;
        }//end if
        return orderSum;
    }//end ensureOrderCost

}//end class
