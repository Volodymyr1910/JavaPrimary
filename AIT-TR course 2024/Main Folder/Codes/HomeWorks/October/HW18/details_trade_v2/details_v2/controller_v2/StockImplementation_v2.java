package HW18.details_trade_v2.details_v2.controller_v2;

import HW18.details_trade_v2.details_v2.dao_v2.Stock_v2;
import HW18.details_trade_v2.details_v2.model_v2.Detail_v2;

public class StockImplementation_v2 implements Stock_v2 {

    private Detail_v2[] details;
    private int size;

    public StockImplementation_v2(int capasity) {
        this.details = new Detail_v2[capasity];
        this.size = size;
    }

    @Override
    public boolean addSparePart(Detail_v2 detail) {
        if (detail == null) return false;
        if (size == details.length) return false;
        if (detail == findSparePart(detail.getBarCode())) return false;
        details[size] = detail;
        size++;
        return true;
    }//end addSparePart

    @Override
    public Detail_v2 findSparePart(long barCode) {
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == barCode) return details[i];
        }//end
        return null;
    }//end

    @Override
    public Detail_v2[] findSparePartByVendor(String vendor) {
        return new Detail_v2[0];
    }

    @Override
    public Detail_v2[] findSparePartByMaterial(String material) {
        return new Detail_v2[0];
    }

    @Override
    public Detail_v2[] findSparePartWithDiscount() {
        return new Detail_v2[0];
    }

    @Override
    public Detail_v2[] findSparePartWithFixedDiscount(double n) {
        return new Detail_v2[0];
    }

    @Override
    public Detail_v2[] findSetSparePart() {
        return new Detail_v2[0];
    }

    @Override
    public Detail_v2 findCheapestSparePart() {
        return null;
    }

    //делаю допущение - на заводе поставщика прошла перестандартизация.
    // Деталь Gear c баркодом 100000000000000l, получила новый tooth -> 3 и новый weight -> 0.18. (old tooth = 2; old weight = 0.15;)
    //det[0] = new Gear_v2(100000000000000l, 10,"M1",0.15,"V1",7.5,200, 6.5,2, 3) деталь для замены из конструктора в классе Test
    // Остальные параметры, включая баркод не изменились.
    // Поставщику вернули все Gear старого образца, и он бесплатно поменял их на новые Detail_v2 detail.
    @Override
    public boolean updateSparePart(Detail_v2 newDetail) {
        if ((findSparePart(newDetail.getBarCode()) == null)) return false;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == newDetail.getBarCode()) {
                count++;
                details[i] = newDetail;
            }//end if
        }//end for
        return true;
    }//end updateSparePart

    @Override
    public Detail_v2 removeSparePart(long barCode) {
        for (int i = 0; i < size; i++) {
            if (details[i].getBarCode() == barCode) {
                Detail_v2 victim = details[i];
                details[i] = details[size - 1];
                size--;
                return victim;
            }//end if
        }//end fori
        return null;
    }//end removeSparePart

    @Override
    public double totalWeightInStorage() {
         double totalWeight = 0;
        for (int i = 0; i < size; i++) {
            totalWeight += details[i].getWeight() * details[i].getQuantityOfOrderedSparePart();
        }//end for
        return totalWeight;
    }//end totalWeightInStorage

    @Override
    public double averageWeightSparePartInStorage() {
        return totalWeightInStorage() / quantityOfPiecesOfSpareParts();
    }//end averageWeightSparePartInStorage

    @Override
    public int quantityOfPiecesOfSpareParts() {
        int totalPiecesQuantity = 0;
        for (int i = 0; i < size; i++) {
            totalPiecesQuantity += details[i].getQuantityOfOrderedSparePart();
        }//end for
        return totalPiecesQuantity;
    }//end quantityOfPiecesOfSpareParts

    @Override
    public int quantityOfSpareParts() {
        return size;
    }//end quantityOfSpareParts

    @Override
    public void printSparePart() {
        for (int i = 0; i < size; i++) {
            System.out.println(details[i]);
        }//end for
    }//end sprintSparePart
}//end StockImplementation
