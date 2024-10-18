package HW17.car_parts.details.dao;

import HW17.car_parts.details.model.Detail;

public class StockImplementation implements Stock{

    private Detail [] details;
    private int size;

    public StockImplementation( int capasity) {
        this.details = new Detail[capasity];
        this.size = size;
    }

    @Override
    public boolean addSparePart(Detail detail) {
        return false;
    }

    @Override
    public Detail findSparePart(int barCode) {
        return null;
    }

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
    public Detail removeSparePart(int barCode) {
        return null;
    }

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
        return 0;
    }

    @Override
    public void printSparePart() {

    }
}//end StockImplementation
