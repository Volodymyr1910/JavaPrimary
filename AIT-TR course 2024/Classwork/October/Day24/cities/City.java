package Day24.cities;
////Создать класс City - название, население.
////Сделать класс City сортируемым по полю кол-во населения.
import java.util.Objects;

public class City implements Comparable <City>{

    private String name;
    private int population;


    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return population == city.population && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population);
    }


    @Override
    public String toString() {
        return String.format("City name: %s, population: %d",name, population);
    }

    @Override
    public int compareTo(City o) {
        //return this.population - o.population;
        return Integer.compare (this.population, o.population);
        //return this.name.compareTo(o.name); //сортировка по алфавиту
    }
}//end class
