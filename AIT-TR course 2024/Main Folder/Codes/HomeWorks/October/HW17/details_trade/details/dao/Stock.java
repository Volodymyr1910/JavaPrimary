package HW17.details_trade.details.dao;

import HW17.details_trade.details.model.Detail;

public interface Stock {

    //добавить деталь на склад
    boolean addSparePart(Detail detail);

    //найти деталь по barCode
    Detail findSparePart(long barCode);

    //найти все детали определенного поставщика
    Detail [] findSparePartByVendor(String vendor);

    //найти все детали из определенного материала
    Detail [] findSparePartByMaterial(String material);

    //найти все детали по которым есть дисконтная цена
    Detail [] findSparePartWithDiscount();

    //найти все детали по которым есть дисконтная цена в размере n
    Detail [] findSparePartWithFixedDiscount(double n);

    //найти все детали идущие комплектом
    Detail [] findSetSparePart();

    //найти самую дешевую запчасть
    Detail findCheapestSparePart();

    //обновить данные о детали
    Detail updateSparePart(Detail detail);

    //удалить деталь
    Detail removeSparePart(long barCode);

    //общая масса всех деталей на складе
    double totalWeightInStorage(Detail detail);

    //средняя масса деталей на складе
    double averageWeightSparePartInStorage(int n);

    // ко-во деталей на складе
    int quantityOfSpareParts ();

    //распечатать список запчастей
    void printSparePart ();





}//end interface
