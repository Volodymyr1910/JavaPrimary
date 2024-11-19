package HW8;
//Задание 1. Соберите в структуру Map порядка 20 стран, по несколько стран из разных континентов Земли. Подсчитайте количество стран на континентах из полученного списка.
import java.util.HashMap;
import java.util.Map;

public class ContinentsAndCountries {

    public static void main(String[] args) {


        Map<String, String> countries1 = new HashMap<>(Map.of("Japan", "Asia", "Germany","Europe",  "South Africa","Africa", "Canada", "North America", "Chile","South America", "France", "Europe", "India", "Asia", "China", "Asia", "Egypt", "Africa",  "United States", "North America"));
        Map<String, String> countries2 = new HashMap<>(Map.of("Argentina","South America", "Nigeria", "Africa", "Morocco", "Africa", "Saudi Arabia", "Asia", "Spain", "Europe", "Mexico","North America", "Colombia", "South America", "Sweden", "Europe", "Cuba", "North America", "Brazil", "South America"));


        Map<String, String> countries = new HashMap<>(countries1);
        countries.putAll(countries2);
        System.out.println(countries.size());

        int start = 1;
        int step = 1;
        Map <String, Integer> countriesNew = new HashMap<>();

        //Using keys
        for (String key : countries.keySet()) {
            if(countriesNew.containsKey(countries.get(key)))  countriesNew.put(countries.get(key), countriesNew.get(countries.get(key)) + step);
           else countriesNew.put(countries.get(key), start);
        }//end for

        //using values
        for (String value : countries.values()) {
            if(countriesNew.containsKey(value)) countriesNew.put(value, countriesNew.get(value) + step);
            else countriesNew.put(value, start);
        }//end for

        //print results
        for (String key : countriesNew.keySet()) {
            System.out.println(key + " : " + countriesNew.get(key) + " countries in the list");
        }//end for



    }//end main






}//end class
