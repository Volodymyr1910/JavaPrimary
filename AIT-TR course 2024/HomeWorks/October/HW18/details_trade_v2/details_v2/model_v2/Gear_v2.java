package HW18.details_trade_v2.details_v2.model_v2;

public class Gear_v2 extends Detail_v2 {

    private double radius;
    private int tooth;
    private int piecesInSet;

    public Gear_v2(long barCode, double size, String material, double weight, String vendor, double sparePartCost, int quantityOfOrderedSparePart, double radius, int tooth, int piecesInSet) {
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gear_v2{");
        sb.append(", barCode=").append(barCode);
        sb.append(", size=").append(size);
        sb.append(", material='").append(material).append('\'');
        sb.append(", weight=").append(weight);
        sb.append(", vendor='").append(vendor).append('\'');
        sb.append(", sparePartCost=").append(sparePartCost);
        sb.append(", quantityOfOrderedSparePart=").append(quantityOfOrderedSparePart);
        sb.append("radius=").append(radius);
        sb.append(", tooth=").append(tooth);
        sb.append(", piecesInSet=").append(piecesInSet);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public double calcOrderSum() {
        double orderSum = piecesInSet * getQuantityOfOrderedSparePart() * getSparePartCost();
        return ensureOrderSum(orderSum);
    }//end calcOderSum
}//end class
