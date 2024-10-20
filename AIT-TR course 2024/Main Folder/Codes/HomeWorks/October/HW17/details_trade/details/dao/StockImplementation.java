package HW17.details_trade.details.dao;

import HW17.details_trade.details.model.Detail;

public class StockImplementation implements Stock{

    private Detail [] details;
    private int size;

    public StockImplementation( int capasity) {
        this.details = new Detail[capasity];
        this.size = size;
    }

    @Override
    public boolean addSparePart(Detail detail) {
        if(detail == null) return  false;
        if(size == details.length) return  false;
        if (detail == findSparePart(detail.getBarCode())) return false;
        details[size] = detail;
        size++;
        return true;
    }//end addSparePart

    @Override
    public Detail findSparePart(long barCode) {
        for (int i = 0; i < size; i++) {
            if(details[i].getBarCode() == barCode) return details[i];
        }//end
        return null;
    }//end

    @Override
    public Detail[] findSparePartByVendor(String vendor) {
        return new Detail[0];
    }

    @Override
    public Detail[] findSparePartByMaterial(String material) {
        return new Detail[0];
    }

    @Override
    public Detail[] findSparePartWithDiscount() {
        return new Detail[0];
    }

    @Override
    public Detail[] findSparePartWithFixedDiscount(double n) {
        return new Detail[0];
    }

    @Override
    public Detail[] findSetSparePart() {
        return new Detail[0];
    }

    @Override
    public Detail findCheapestSparePart() {
        return null;
    }

    @Override
    public Detail updateSparePart(Detail detail) {
        return null;
    }

    @Override
    public Detail removeSparePart(long barCode) {
        for (int i = 0; i < size; i++) {
            if(details[i].getBarCode() == barCode) {
                Detail victim = details[i];
                details[i] = details[size-1];
                size--;
                return victim;
            }//end if
        }//end fori
        return null;
    }//end removeSparePart

    @Override
    public double totalWeightInStorage(Detail detail) {
        return 0;
    }

    @Override
    public double averageWeightSparePartInStorage(int n) {
        return 0;
    }

    @Override
    public int quantityOfSpareParts() {
        return size;
    }

    @Override
    public void printSparePart() {
        for (int i = 0; i < size; i++) {
            System.out.println(details[i]);
        }//end for
    }//end sprintSparePart
}//end StockImplementation
