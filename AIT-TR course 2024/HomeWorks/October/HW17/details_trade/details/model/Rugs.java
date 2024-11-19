package HW17.details_trade.details.model;

public class Rugs extends Detail{


    private boolean premiumQuality; // премиум класс на 25 % дороже


    public Rugs(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOrderedSparePart, boolean premiumQuality) {
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
    public double calcOrderSum() {
        double orderSum;
        if(premiumQuality) orderSum = 1.25 * getSparePartCost() * getQuantityOfOrderedSparePart();
        else orderSum = getSparePartCost() * getQuantityOfOrderedSparePart();
        return ensureOrderSum(orderSum);
    }//end calcOderSum
}//end class
