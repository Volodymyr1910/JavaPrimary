package HW17.car_parts.details.model;

public class Lever extends Detail{

    private double power;
    private double discountCost; //при заказе 500 и более штук - акционная цена 80%

    public Lever(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOderedSparePart, double power, double discountCost) {
        super(barCode, size, material, weight, vendor, sparePartCost, quantityOfOderedSparePart);
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
    public double calcOderSum() {
        double orderSum;
        if(getQuantityOfOderedSparePart() >= 500) orderSum = discountCost * getSparePartCost() * getQuantityOfOderedSparePart();
        else orderSum = getSparePartCost() * getQuantityOfOderedSparePart();
        return ensureOderSum(orderSum);
    }//end calcOderSum
}//end class
