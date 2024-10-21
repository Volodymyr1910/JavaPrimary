package HW18.details_trade_v2.details_v2.controller_v2;

import HW18.details_trade_v2.details_v2.dao_v2.Stock_v2;
import HW18.details_trade_v2.details_v2.model_v2.Detail_v2;
import HW18.details_trade_v2.details_v2.model_v2.Gear_v2;
import HW18.details_trade_v2.details_v2.model_v2.Lever_v2;

import java.util.function.Predicate;

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
        return findDetailByPredicate(details -> details.getVendor().equals(vendor));
    }//end findSparePartByVendor

    @Override
    public Detail_v2[] findSparePartByMaterial(String material) {
        return findDetailByPredicate(details -> details.getMaterial().equals(material));
    }//end findSparePartByMaterial

    @Override
    public Detail_v2[] findSparePartWithDiscount() {
        return findDetailByPredicate(details -> details instanceof Lever_v2);
    }//end findSparePartWithDiscount

    @Override
    public Detail_v2[] findSparePartWithDiscountLowerThan(double n) {
        // return findDetailByPredicate(details -> details instanceof Lever_v2 && (Lever_v2) details[i].getdiscountCost <= n);
       int count = 0;
        for (int i = 0; i < size; i++) {
            if(details[i] instanceof Lever_v2){
                if(((Lever_v2) details[i]).getDiscountCost() <= n) {
                    count++;
                }//end if
            }//end if
        }//end fori
        Detail_v2 [] detailsWithDLowerN = new Detail_v2[count];
        for (int i = 0, j = 0; i < size; i++) {
            if(details[i] instanceof Lever_v2){
                if(((Lever_v2) details[i]).getDiscountCost() <= n) {
                    detailsWithDLowerN[j] = details[i];
                    j++;
                }//end if
            }//end if
        }//end fori
        return detailsWithDLowerN;
    }//end findSparePartWithDiscountLowerThan

    @Override
    public Detail_v2[] findSetSparePart() {
        return findDetailByPredicate(details -> details instanceof Gear_v2);
    }//end findSetSparePart

    @Override
    public Detail_v2 findCheapestSparePart() {
        Detail_v2 cheapestDetail = details [0];
        for (int i = 0; i < size; i++) {
            if(details[i].getSparePartCost() < cheapestDetail.getSparePartCost()) cheapestDetail = details[i];
        }//end for
        return cheapestDetail;
    }//end findCheapestSparePart

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

    private Detail_v2 [] findDetailByPredicate (Predicate <Detail_v2> pred){
        int count = 0;
        for (int i = 0; i < size; i++) {
            if(pred.test(details[i]))count++;
        }//end for
        Detail_v2 [] res = new Detail_v2[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if(pred.test(details[i])){
                res[j++] = details[i];
            }//end if
        }//end fori
        return res;
    }//end findDetailByPredicate


    // как учесть в аргументах predicate 2 условия я не разобрался
    private Detail_v2 findDetailByPredicateWithCondition (Predicate<Boolean> pred){
        double minCost = details[0].getSparePartCost();
        Detail_v2 cheapestDetail = null;
        for (int i = 0; i < size; i++) {
                if(pred.test(details[i].getSparePartCost() < minCost)){
                    minCost = details[i].getSparePartCost();
                    cheapestDetail = details [i];
                }//end if
        }//end for
        return cheapestDetail;
    }//end findDetailByPredicate


}//end class
