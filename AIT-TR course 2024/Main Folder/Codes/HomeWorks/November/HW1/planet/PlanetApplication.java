package HW1.planet;


import MyMethods.list.list_methods.ListMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
////Output a list of planets sorted by:
//    //
//    //order of location in the solar system;
//    //alphabet;
//    //mass;
//    //number of satellites.
public class PlanetApplication {

    public static void main(String[] args) {

        List<Planet> planetList = new ArrayList<>();
        planetList.add(new Planet("Mercury", 57_910_006l, 0.06, 0));
        planetList.add(new Planet("Earth",149_599_951l, 1, 1 ));
        planetList.add(new Planet("Jupiter", 778_330_257l , 318, 79));
        planetList.add(new Planet("Saturn", 1_429_400_028l, 95, 82 ));
        planetList.add(new Planet("Mars", 227_939_920l, 0.11,2));
        planetList.add(new Planet("Uranus", 2_870_989_228l, 14.6, 27 ));
        planetList.add(new Planet("Neptune", 4_504_299_579l, 17.2, 14 ));
        planetList.add(new Planet("Venus", 108_199_995l, 0.82, 0));

        Collections.sort(planetList);
        ListMethods.printList(planetList,"after native sort");
        System.out.println();

        sortByAll(planetList,"name");
        ListMethods.printList(planetList,"after sort by name");
        System.out.println();

        sortByAll(planetList,"massRelativeEarth");
        ListMethods.printList(planetList,"after sort by mass");
        System.out.println();

        sortByAll(planetList,"numberOfSatellites");
        ListMethods.printList(planetList,"after sort by number of satellites");
        System.out.println();


    }//end main
    public static  void sortByAll (List <Planet> list, String fieldForSort) {

        Comparator<Planet> compByAll = new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
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
        Collections.sort(list,compByAll);
    }//end sortByAll



}//end class
