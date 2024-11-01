package HW1.planets;

import HW18.cars.model.Car;
import MyMethods.list_methods.ListMethods;

import java.util.*;
////Output a list of planets sorted by:
//    //
//    //order of location in the solar system;
//    //alphabet;
//    //mass;
//    //number of satellites.

public class PlanetsApplication implements Comparable <Planets>{

    public static void main(String[] args) {
        List<Planets> planetsList = List.of(Planets.MERCURY, Planets.Venus, Planets.MARS,Planets.URANUS, Planets.EARTH, Planets.NEPTUNE, Planets.JUPITER, Planets.SATURN);
        ListMethods.printList(planetsList, "");

        // и дальше, как я ни старался, двинуться не выходит ---- UnsupportedOperationException
        planetsList.sort(Comparator.comparing(Planets::getRangeToSun));
        //planetsList.sort(Planets::compareTo);
        //sortByAll(planetsList,"rangeToSun");
        ListMethods.printList(planetsList, "after sort order of location in the solar system ");




       // sortByAll(planetsList);
        //Collections.sort(planetsList);
        //ListMethods.printList(planetsList, " after sort ");
        //List<Planets> planetsList = List.of();
    }//end main



    public static List<Planets> sortByAll (List <Planets> list, String fieldForSort) {

        Comparator<Planets> compByAll = new Comparator<Planets>() {
            @Override
            public int compare(Planets o1, Planets o2) {
                int res = 0;
                switch (fieldForSort){
                    case "name" ->  res = o1.getName().compareTo(o2.getName());
                    case "rangeToSun" ->   res = Long.compare(o1.getRangeToSun(),o2.getRangeToSun());
                    case "massRelativeEarth" ->   res = Double.compare(o1.getMassRelativeEarth(), o2.getMassRelativeEarth());
                    case "numberOfSatellites" ->  res =  Integer.compare(o1.getNumberOfSatellites(), o2.getNumberOfSatellites());
                }
                return res;
            }
        };

        list.sort(compByAll);
        //Collections.sort(Comparator.comparing(Planets::getRangeToSun));
        return list;
    }//end sortByAll


    @Override
    public int compareTo(Planets o) {
        return this.compareTo(o);
    }
}//end class
