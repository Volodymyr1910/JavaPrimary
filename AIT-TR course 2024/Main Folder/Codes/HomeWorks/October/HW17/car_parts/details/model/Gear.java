package HW17.car_parts.details.model;

public class Gear extends Detail{

    private double radius;
    private int tooth;
    private int piecesInSet;

    public Gear(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOderedSparePart, double radius, int tooth, int piecesInSet) {
        super(barCode, size, material, weight, vendor, sparePartCost, quantityOfOderedSparePart);
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
    public double calcOderSum() {
        double oderSum = piecesInSet * getQuantityOfOderedSparePart() * getSparePartCost();
        return ensureOderSum(oderSum);
    }//end calcOderSum
}//end class
