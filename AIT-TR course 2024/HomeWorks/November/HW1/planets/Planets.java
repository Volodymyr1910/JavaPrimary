package HW1.planets;

public enum Planets implements Comparable <Planets>{

    MERCURY ("Mercury", 57_910_006l, 0.06, 0), EARTH ("Earth",149_599_951l, 1, 1 ), JUPITER ("Jupiter", 778_330_257l , 318, 79), SATURN ("Saturn", 1_429_400_028l, 95, 82 ), MARS ("Mars", 227_939_920l, 0.11,2), URANUS ("Uranus", 2_870_989_228l, 14.6, 27 ), NEPTUNE ("Neptune", 4_504_299_579l, 17.2, 14 ),  Venus ("Venus", 108_199_995l, 0.82, 0)


    ;
    //Task 2. Add the planets of the solar system to a list containing:
    //
    //name;
    //distance to the Sun;
    //mass;
    //number of satellites.


    private String name;
    private long rangeToSun;
    private double massRelativeEarth;
    private int numberOfSatellites;

    Planets(String name, long rangeToSun, double massRelativeEarth, int numberOfSatellites) {
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
        final StringBuilder sb = new StringBuilder("Planets{");
        sb.append("name='").append(name).append('\'');
        sb.append(", rangeToSun=").append(rangeToSun);
        sb.append(", massRelativeEarth=").append(massRelativeEarth);
        sb.append(", numberOfSatellites=").append(numberOfSatellites);
        sb.append('}');
        return sb.toString();
    }


}//end enum
