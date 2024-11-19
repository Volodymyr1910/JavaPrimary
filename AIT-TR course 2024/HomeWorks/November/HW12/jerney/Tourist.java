package HW12.jerney;

import java.util.List;

public class Tourist {

    private String name;
    private List<String> country;

    public Tourist(String name, List<String> country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public List<String> getCountry() {
        return country;
    }


    @Override
    public String toString() {

        return "Name: " + name + " -> " + country;
    }
}//end class
