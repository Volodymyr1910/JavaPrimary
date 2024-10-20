package HW18.details_trade_v2.details_v2.model_v2;

public class Rugs_v2 extends Detail_v2 {


    private boolean premiumQuality; // премиум класс на 25 % дороже


    public Rugs_v2(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOrderedSparePart, boolean premiumQuality) {
        super(barCode, size, material, weight, vendor, sparePartCost, quantityOfOrderedSparePart);
        this.premiumQuality = premiumQuality;
    }

    public boolean isPremiumQuality() {
        return premiumQuality;
    }

    public void setPremiumQuality(boolean premiumQuality) {
        this.premiumQuality = premiumQuality;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rugs_v2{");
        sb.append(", barCode=").append(barCode);
        sb.append(", size=").append(size);
        sb.append(", material='").append(material).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", vendor='").append(vendor).append('\'');
        sb.append(", sparePartCost=").append(sparePartCost);
        sb.append(", quantityOfOrderedSparePart=").append(quantityOfOrderedSparePart);
        sb.append("premiumQuality=").append(premiumQuality);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double calcOrderSum() {
        double orderSum;
        if(premiumQuality) orderSum = 1.25 * getSparePartCost() * getQuantityOfOrderedSparePart();
        else orderSum = getSparePartCost() * getQuantityOfOrderedSparePart();
        return ensureOrderSum(orderSum);
    }//end calcOderSum
}//end class
