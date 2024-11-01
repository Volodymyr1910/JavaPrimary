package HW1.planet;

import java.util.Objects;
//Task 2. Add the planets of the solar system to a list containing:
//
//name;
//distance to the Sun;
//mass;
//number of satellites.
public class Planet implements Comparable <Planet> {

    private String name;
    private long rangeToSun;
    private double massRelativeEarth;
    private int numberOfSatellites;


    public Planet(String name, long rangeToSun, double massRelativeEarth, int numberOfSatellites) {
        this.name = name;
        this.rangeToSun = rangeToSun;
        this.massRelativeEarth = massRelativeEarth;
        this.numberOfSatellites = numberOfSatellites;
    }


    public String getName() {
        return name;
    }

    public long getRangeToSun() {
        return rangeToSun;
    }

    public double getMassRelativeEarth() {
        return massRelativeEarth;
    }

    public int getNumberOfSatellites() {
        return numberOfSatellites;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planet{");
        sb.append("name='").append(name).append('\'');
        sb.append(", rangeToSun=").append(rangeToSun);
        sb.append(", massRelativeEarth=").append(massRelativeEarth);
        sb.append(", numberOfSatellites=").append(numberOfSatellites);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet planet)) return false;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public int compareTo(Planet o) {
        return Long.compare(this.getRangeToSun(), o.getRangeToSun());
    }
}//end class
