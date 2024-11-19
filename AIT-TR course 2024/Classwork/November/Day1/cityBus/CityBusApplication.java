package Day1.cityBus;

import java.util.*;

public class CityBusApplication {
    public static void main(String[] args) {

        List <Bus> cityBusList = new ArrayList<>();
        cityBusList.add( new Bus("MAN","num1","3", 35));
        cityBusList.add(new Bus("Scania", "num2", "10A", 40));
        cityBusList.add(new Bus("MAN", "num3", "10C", 25));
        cityBusList.add(new Bus("Mercedes", "num4", "10A", 35));
        cityBusList.add(new Bus("Volvo", "num5", "10A", 45));

        for (Bus bus : cityBusList) {
            System.out.println(bus);
        }//end for

        cityBusList.sort(Bus::compareTo);
        System.out.println("-------------------after native sort-------------------");
        for (Bus bus : cityBusList) {
            System.out.println(bus);
        }//end for

        Set <Bus> cityBusSet = new HashSet<>();
        cityBusSet.add( new Bus("MAN","num1","3", 35));
        cityBusSet.add(new Bus("Scania", "num2", "10A", 40));
        cityBusSet.add(new Bus("MAN", "num3", "10C", 25));
        cityBusSet.add(new Bus("Mercedes", "num4", "1A", 35));
        cityBusSet.add(new Bus("Volvo", "num5", "100", 45));
        System.out.println("--------------------===================== set =====================------------------------");
        for (Bus bus : cityBusSet) {
            System.out.println(bus);
        }

        Comparator <Bus> comp = new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                int res = o1.getRoute().compareTo(o2.getRoute());
                return  res != 0 ? res : - Integer.compare(o1.getBusCapacity(),o2.getBusCapacity());
            }
        };
        cityBusList.sort(comp);
        System.out.println("------------------------------ list after sort by capasity and route------------------------------------------");
        for (Bus bus : cityBusList) {
            System.out.println(bus);
        }//end for


    }//end main

}//end class
