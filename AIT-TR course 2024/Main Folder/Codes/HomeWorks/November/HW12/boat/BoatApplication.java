package HW12.boat;

import Day12.programmers_and_technologies.Programmer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



public class BoatApplication {
    public static void main(String[] args) {

        List<Boat> boats = createBoatList();

        //отобразить все яхты;
        boats.forEach(boat -> System.out.println(boat));

        //отобразить яхты, сделанные из указанного материала корпуса;
        String material = "Wood";
        System.out.println();
        System.out.println("wood boats:");
        printBoatsFromChossenMaterial(boats, material);
        //отобразить яхты дороже указанной цены;
        int cost = 40000;
        System.out.println();
        System.out.println("boats, more expensive than " + cost + " $");
        printBoatsMoreExpensiveThanCost(boats, cost);
        //отобразить яхты, чей год выпуска находится в заданном диапазоне;
        int yearFrom = 2014;
        int yearTo = 2018;
        printBoatsManufacturedFrom_To_Year(boats, yearFrom, yearTo);
        //отсортировать яхты в порядке убывания стоимости;
        List <Boat> boatsFromExpToCheap = printBoatsByPriceFromHighToLow(boats);
        System.out.println();System.out.println("Boats from expensive to cheap:");
        boatsFromExpToCheap.forEach(boat -> System.out.println(boat));

        //получить среднюю стоимость яхты из созданного набора;
      System.out.println();System.out.printf("average price of the boats is -> %.2f", getAverageBoatPrice(boats)); double avgPrice = getAverageBoatPrice(boats);  System.out.println();

        //сколько и конкретно какие яхты под каким флагом стоят в порту.
        System.out.println();System.out.println("General List by countries:");Map<String, List<Boat>> boatsSortedByCountries = getBoatesSortedByCountries(boats);

    }//end main

    private static List <Boat> printBoatsByPriceFromHighToLow(List<Boat> boats) {
        return boats.stream().sorted(Comparator.comparing(Boat::getPrice).reversed()).toList();
    }//end printBoatsByPriceFromHighToLow

    private static Map<String, List<Boat>> getBoatesSortedByCountries(List<Boat> boats) {

        Map<String, List<Boat>> boatsTMP = boats.stream()
                .collect(Collectors.groupingBy(Boat::getCountry, Collectors.toList()));

        boatsTMP.forEach((country, boatsList) ->
                System.out.println(country + ": " + boatsList.size() + " boats -> " + boatsList));

        return  boatsTMP;
    }//end getBoatesSortedByCountries


    private static double getAverageBoatPrice(List<Boat> boats) {
        return boats.stream().mapToDouble(Boat::getPrice).summaryStatistics().getAverage();
    }//end getAverageBoatPrice

    private static void printBoatsManufacturedFrom_To_Year(List<Boat> boats, int yearFrom, int yearTo) {
        //Вариант 1, сорт по годам делаем сразу при отборе нужных boat c исходного списка boats
        //List<Boat> b = boats.stream().filter(boat -> boat.getYear() > yearFrom && boat.getYear() <= yearTo).sorted(Comparator.comparing(Boat::getYear)).toList();
        //System.out.println();System.out.println("boats manufactured between " + (yearFrom -1) + " and " + (yearTo + 1));b.forEach(System.out::println);

        //Вариант 2, сделали отбор нужных boat c исходного списка boats
        List<Boat> b = boats.stream().filter(boat -> boat.getYear() > yearFrom && boat.getYear() <= yearTo).toList();
        System.out.println();System.out.println("boats manufactured between " + (yearFrom -1) + " and " + (yearTo + 1));b.forEach(System.out::println);

        // отсортировать полученный список, от старой к новой можно только создавая нового получателя результата сортировки, т.к. стрим НЕ МЕНЯЕТ ИСТОЧНИК
        // оба варианта сорттировки работают
        //List<Boat> boatsSorted = StreamSupport.stream(b.spliterator(), false).sorted(Comparator.comparing(Boat::getYear)).toList();
        //List<Boat> boatsSorted = StreamSupport.stream(b.spliterator(), false).sorted((b1, b2) -> Integer.compare(b1.getYear(), b2.getYear())).toList();
        //System.out.println();System.out.println("boats manufactured between " + (yearFrom - 1) + " and " + (yearTo + 1));  boatsSorted.forEach(System.out::println);
    }//end printBoatsManufacturedFrom_To_Year

    private static void printBoatsMoreExpensiveThanCost(List<Boat> boats, int cost) {
        boats.stream().filter(boat -> boat.getPrice() > cost).forEach(boat -> System.out.println(boat));
    }//end printBoatsMoreExpensiveThanCost


    private static void printBoatsFromChossenMaterial(List<Boat> boats, String material) {
        boats.stream().filter(boat -> boat.getMaterial().equals(material)).forEach(boat -> System.out.println(boat));
    }//end printBoatsFromChossenMaterial

    private static List<Boat> createBoatList() {
        return List.of(
                new Boat("Fibi", "Norway", 2015, 18.5, "Aluminium", 80000),
                new Boat("Forest", "Poland", 2018, 22, "Wood", 35000),
                new Boat("Crow", "Italy", 2016, 15, "Iron", 25000),
                new Boat("Crow", "Italy", 2020, 28, "Aluminium", 100000),
                new Boat("Storm", "Finland", 2019, 22, "Iron", 40000),
                new Boat("Rainbow", "Germany", 2012, 18, "Wood", 34000)
        );
    }//end createBoatList


}//end class
