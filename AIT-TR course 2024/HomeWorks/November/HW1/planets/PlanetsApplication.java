package HW1.planets;

import MyMethods.list.list_methods.ListMethods;

import java.util.*;
////Output a list of planets sorted by:
//    //
//    //order of location in the solar system;
//    //alphabet;
//    //mass;
//    //number of satellites.

public class PlanetsApplication {

    public static void main(String[] args) {
        List<Planets> planetsList = new ArrayList<>();

        planetsList.add(Planets.MERCURY);
        planetsList.add(Planets.Venus);
        planetsList.add(Planets.MARS);
        planetsList.add(Planets.URANUS);
        planetsList.add(Planets.EARTH);
        planetsList.add(Planets.NEPTUNE);
        planetsList.add(Planets.JUPITER);
        planetsList.add(Planets.SATURN);
        ListMethods.printList(planetsList, "");
        System.out.println();

        Collections.sort(planetsList, Comparator.comparing(Planets::getRangeToSun));
        ListMethods.printList(planetsList, "after sort by order of location in the solar system ");
        System.out.println();

        Collections.sort(planetsList, Comparator.comparing(Planets::getName));
        ListMethods.printList(planetsList, "after sort by name ");
        System.out.println();

        Collections.sort(planetsList, Comparator.comparing(Planets::getMassRelativeEarth));
        ListMethods.printList(planetsList, "after sort by mass relative Earth ");
        System.out.println();

        Collections.sort(planetsList, Comparator.comparing(Planets::getNumberOfSatellites));
        ListMethods.printList(planetsList, "after sort by number of satellites ");
        System.out.println();

    }//end main

}//end class
