package HW18.details_trade_v2.details_v2.model_v2;

public class Lever_v2 extends Detail_v2 {

    private double power;
    private double discountCost; //при заказе 500 и более штук - акционная цена 80%

    public Lever_v2(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOrderedSparePart, double power, double discountCost) {
        super(barCode, size, material, weight, vendor, sparePartCost, quantityOfOrderedSparePart);
        this.power = power;
        this.discountCost = discountCost;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getDiscountCost() {
        return discountCost;
    }

    public void setDiscountCost(double discountCost) {
        this.discountCost = discountCost;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lever_v2{");
        sb.append(", barCode=").append(barCode);
        sb.append(", size=").append(size);
        sb.append(", material='").append(material).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", vendor='").append(vendor).append('\'');
        sb.append(", sparePartCost=").append(sparePartCost);
        sb.append(", quantityOfOrderedSparePart=").append(quantityOfOrderedSparePart);
        sb.append("power=").append(power);
        sb.append(", discountCost=").append(discountCost);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcOrderSum() {
        double orderSum;
        if(getQuantityOfOrderedSparePart() >= 500) orderSum = discountCost * getSparePartCost() * getQuantityOfOrderedSparePart();
        else orderSum = getSparePartCost() * getQuantityOfOrderedSparePart();
        return ensureOrderSum(orderSum);
    }//end calcOderSum
}//end class
