package HW17.car_parts.details.model;

import Day17.ait.employee.model.Employee;

import java.util.Objects;

public abstract class Detail {

    protected static int minOrderFromVendor = 3000;

    protected long barCode;
    protected double size;
    protected String material;
    protected double weight;
    protected String vendor;
    protected double sparePartCost;
    protected int quantityOfOderedSparePart;

    public static int getMinOrderFromVendor (){
        return minOrderFromVendor;
    }//int getMinOrderFromVendor

    //не позволить оформить заказ на сумму меньше минимальной
    public static void setMinOrderFromVendor (int minOrderFromVendor){
        if(minOrderFromVendor > Detail.minOrderFromVendor){
            Detail.minOrderFromVendor = minOrderFromVendor;
        }//end if
    }//end setMinOrderFromVendor

    public Detail(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOderedSparePart) {
        this.barCode = barCode;
        this.size = size;
        this.material = material;
        this.weight = weight;
        this.vendor = vendor;
        this.sparePartCost = sparePartCost;
        this.quantityOfOderedSparePart = quantityOfOderedSparePart;
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

    public int getQuantityOfOderedSparePart() {
        return quantityOfOderedSparePart;
    }

    public void setQuantityOfOderedSparePart(int quantityOfOderedSparePart) {
        this.quantityOfOderedSparePart = quantityOfOderedSparePart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail detail)) return false;
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
        sb.append(", quantityOfOderedSparePart=").append(quantityOfOderedSparePart);
        sb.append('}');
        return sb.toString();
    }

    public abstract double calcOderSum ();

    protected double ensureOderSum (double oderSum){
        if (minOrderFromVendor > quantityOfOderedSparePart * sparePartCost){
            oderSum = minOrderFromVendor;
            System.out.println("Min oder sum is " + minOrderFromVendor + "$. You will pay this. Order a lager quantity.");
        }//end if
        return oderSum;
    }//end ensureOderCost

}//end class
