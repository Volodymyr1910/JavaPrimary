package HW17.details_trade.details.model;

public class Gear extends Detail{

    private double radius;
    private int tooth;
    private int piecesInSet;

    public Gear(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOrderedSparePart, double radius, int tooth, int piecesInSet) {
        super(barCode, size, material, weight, vendor, sparePartCost, quantityOfOrderedSparePart);
        this.radius = radius;
        this.tooth = tooth;
        this.piecesInSet = piecesInSet;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getTooth() {
        return tooth;
    }

    public void setTooth(int tooth) {
        this.tooth = tooth;
    }

    public int getPiecesInSet() {
        return piecesInSet;
    }

    public void setPiecesInSet(int piecesInSet) {
        this.piecesInSet = piecesInSet;
    }

    @Override
    public double calcOrderSum() {
        double orderSum = piecesInSet * getQuantityOfOrderedSparePart() * getSparePartCost();
        return ensureOrderSum(orderSum);
    }//end calcOderSum
}//end class
