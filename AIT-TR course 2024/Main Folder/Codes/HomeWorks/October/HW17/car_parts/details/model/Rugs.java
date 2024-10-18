package HW17.car_parts.details.model;

public class Rugs extends Detail{


    private boolean premiumQuality; // премиум класс на 25 % дороже


    public Rugs(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOderedSparePart, boolean premiumQuality) {
        super(barCode, size, material, weight, vendor, sparePartCost, quantityOfOderedSparePart);
        this.premiumQuality = premiumQuality;
    }

    public boolean isPremiumQuality() {
        return premiumQuality;
    }

    public void setPremiumQuality(boolean premiumQuality) {
        this.premiumQuality = premiumQuality;
    }

    @Override
    public double calcOderSum() {
        double orderSum;
        if(premiumQuality) orderSum = 1.25 * getSparePartCost() * getQuantityOfOderedSparePart();
        else orderSum = getSparePartCost() * getQuantityOfOderedSparePart();
        return ensureOderSum(orderSum);
    }//end calcOderSum
}//end class
