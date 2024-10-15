package HW14.italy_journey;
//Задача 2. Семья планирует поехать в отпуск в Италию из Германии и покрыть порядка 3000 км. Имеется информация о 5 автомобилях на жидком топливе (бензин или дизтопливо):
//
//марка автомобиля: Audi, BMW, Opel, VW, Mercedes.
//тип расходуемого топлива: d, b, d, d, b
//стоимость 1 литра топлива: d - 1.6, b - 1.8
//расход на 100 км пути: 6.6, 6.8, 6.9, 6.5, 6.3
//стоимость недельной аренды автомобиля: 45, 49, 45, 39, 49 Какой автомобиль ей следует выбрать, исходя из минимальной стоимости?

import HW14.italy_journey.model.ItalyJourney;

//делаем допущения :
// семья хочет получить чистых 7 дней отдыха
//арендная плата авто расчитывается понедельно, в случае не возврата авто на 7 день, стягивается оплата новой недели
// в день на дорогу отведено не более 8 часов
// средняя скорость движения 90 км/час

public class ItalyJourneyApplication {
    public void main(String[] args) {

        //константы
        final float DIESEL_COST = 1.6f;
        final float GASOLINE_COST = 1.8f;
        final int RANGE_OF_TRIP = 6000; // дорога туда и обратно
        final int CLEAN_RELAX = 7; // семья хочет получить чистых 7 дней отдыха
        final float DAY_DRIVING = 8; // в день на дорогу отведено не более 8 часов
        final float AVERAGE_SPEED = 90; // средняя скорость движения 90 км/час

        //создаем обьекты
        ItalyJourney j1 = new ItalyJourney("Audi", 'd', 6.6f, 45);
        ItalyJourney j2 = new ItalyJourney("BMW", 'b', 6.8f, 49);
        ItalyJourney j3 = new ItalyJourney("Opel", 'd', 6.9f, 45);
        ItalyJourney j4 = new ItalyJourney("VW", 'd', 6.5f, 39);
        ItalyJourney j5 = new ItalyJourney("Mercedes", 'b', 6.3f, 49);

        //формируем массив из обьектов
        ItalyJourney[] generalArray = new ItalyJourney[5];

        generalArray[0] = j1;
        generalArray[1] = j2;
        generalArray[2] = j3;
        generalArray[3] = j4;
        generalArray[4] = j5;

        Float[] totalCostArray = new Float[generalArray.length]; // массив содержащий общие затраты по каждому авто

        float drivingDays = RANGE_OF_TRIP / (AVERAGE_SPEED * DAY_DRIVING); //считаем сколько дней в пути
        Float[] roadCostArray = new Float[generalArray.length]; // массив содержащий затраты на дорогу по каждому авто
        Float[] rentCostArray = new Float[generalArray.length]; // массив содержащий затраты на аренду по каждому авто

        //int minCost = bestPriceFinder(generalArray, roadCostArray, rentCostArray, totalCostArray, DIESEL_COST, GASOLINE_COST, RANGE_OF_TRIP, CLEAN_RELAX,  DAY_DRIVING, AVERAGE_SPEED ); // включить для метода bestPriceFinder
        //---------------------------------------------------------------
        int count = 0; // вводим переменные чтоб знать какому элементу принадлежит минимальная стоимость поездки
        Float minCost = 0f;

        for (int i = 0, j = 0, k = 0; i < generalArray.length; i++, j++, k++) {
            // находим затраты на аренду для всех авто и заносим в массив
            rentCostArray[i] = (((drivingDays / 7) + 1) + CLEAN_RELAX ) * (generalArray[i].getWeekRentCost());

            // находим затраты на дорогу для всех авто и заносим в массив
            roadCostArray[j] = (RANGE_OF_TRIP / 10) * (generalArray[i].getFuelConsumption());
            if (generalArray[j].getFuelType() == 'd') roadCostArray[j] *= DIESEL_COST;
            else roadCostArray[j] *= GASOLINE_COST;

            //считаем общие затраты и находим самый дешевый вариант
            totalCostArray[k] = roadCostArray[j] + rentCostArray[i];
            minCost = totalCostArray[k];
            if (totalCostArray[k] < minCost) {
                minCost = totalCostArray[k];
                count = k;
            }//end if

        }//end for */

        System.out.print("Family choosed " + generalArray[count].getBrand());
       System.out.printf(" because trip cost %.2f", minCost);
        System.out.print(" $ is the lowest !");

        //System.out.println("Family choosed " + generalArray[minCost].getBrand() + " because trip in this auto is the chipest !"); // включить для метода bestPriceFinder
    }//end main

    public int bestPriceFinder (ItalyJourney [] array, Float[] roadCostArray, Float[] rentCostArray, Float[] totalCostArray, float DIESEL_COST, float GASOLINE_COST, int RANGE_OF_TRIP, int CLEAN_RELAX, float DAY_DRIVING, float AVERAGE_SPEED) {

        int count = 0; // вводим переменные чтоб знать какому элементу принадлежит минимальная стоимость поездки
        Float minCostTemp = 0f;

        float drivingDays = RANGE_OF_TRIP / (AVERAGE_SPEED * DAY_DRIVING); //считаем сколько дней в пути

        for (int i = 0, j = 0, k = 0; i < array.length; i++, j++, k++) {
            // находим затраты на аренду для всех авто и заносим в массив
            rentCostArray[i] = (((drivingDays / 7) + 1) + CLEAN_RELAX ) * (array[i].getWeekRentCost());

            // находим затраты на дорогу для всех авто и заносим в массив
            roadCostArray[j] = (RANGE_OF_TRIP / 10) * (array[i].getFuelConsumption());
            if (array[j].getFuelType() == 'd') roadCostArray[j] *= DIESEL_COST;
            else roadCostArray[j] *= GASOLINE_COST;

            //считаем общие затраты и находим самый дешевый вариант
            totalCostArray[k] = roadCostArray[j] + rentCostArray[i];
            if (totalCostArray[k] < minCostTemp) {
                minCostTemp = totalCostArray[k];
                count = k;
            }//end if
        }//end for
        return count;
    }//bestPriceFinder

}//and class


