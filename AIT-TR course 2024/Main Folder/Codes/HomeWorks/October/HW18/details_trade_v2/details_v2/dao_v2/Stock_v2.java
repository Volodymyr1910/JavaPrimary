package HW18.details_trade_v2.details_v2.dao_v2;

import HW18.details_trade_v2.details_v2.model_v2.Detail_v2;

public interface Stock_v2 {

    //добавить деталь на склад
    boolean addSparePart(Detail_v2 detail);

    //найти деталь по barCode
    Detail_v2 findSparePart(long barCode);

    //найти все детали определенного поставщика
    Detail_v2[] findSparePartByVendor(String vendor);

    //найти все детали из определенного материала
    Detail_v2[] findSparePartByMaterial(String material);

    //найти все детали по которым есть дисконтная цена
    Detail_v2[] findSparePartWithDiscount();

    //найти все детали по которым есть дисконтная цена в размере n
    Detail_v2[] findSparePartWithDiscountLowerThan(double n);

    //найти все детали идущие комплектом
    Detail_v2[] findSetSparePart();

    //найти самую дешевую запчасть
    Detail_v2 findCheapestSparePart();

    //обновить данные о детали
    boolean updateSparePart(Detail_v2 newDetail);

    //удалить деталь
    Detail_v2 removeSparePart(long barCode);

    //общая масса всех деталей на складе
    double totalWeightInStorage();

    //средняя масса деталей на складе
    double averageWeightSparePartInStorage();

    // ко-во штук на складе
    int quantityOfPiecesOfSpareParts ();

    // ко-во деталей на складе
    int quantityOfSpareParts ();

    //распечатать список запчастей
    void printSparePart ();





}//end interface
