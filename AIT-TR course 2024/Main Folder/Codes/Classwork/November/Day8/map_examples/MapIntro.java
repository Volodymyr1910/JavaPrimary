package Day8.map_examples;

import java.util.*;

//сформируем Map - города и их население
public class MapIntro {


    public static void main(String[] args) {
        //      K  ,    V
        Map<String, Integer> cityMap = new TreeMap<>(); // нативная сортировка по ключам , значит по алфавиту

        cityMap.put("Hamburg", 1_800_000);
        cityMap.put("Berlin", 3_500_000);
        cityMap.put("Munich", 1_500_000);
        cityMap.put("Cologne", 1_080_000);
        cityMap.put("Ingolstadt", 140_000);
        cityMap.put("Augsburg", 350_000);
        cityMap.put("Isny", 14_835);
        cityMap.put("Odessa", 1_500_000);

        System.out.println(cityMap.size()); // 8
        System.out.println(cityMap.isEmpty()); // false
        System.out.println();
        System.out.println("-----------------get by key-----------------");
       Integer population = cityMap.get("Berlin");
        System.out.println(population); // 3_500_00

        // overload
        cityMap.put("Berlin", 300);
        System.out.println(cityMap.get("Berlin"));
        cityMap.put("Berlin", 3_500_000);

        System.out.println("-----------------contains key-----------------");
        System.out.println(cityMap.containsKey("Isny")); // true

        System.out.println("-----------------total population-----------------");
        int totalPopulation = 0;

        List<Integer> tp = new ArrayList<>(cityMap.values());
        System.out.println(tp);
        for (Integer p : tp) {
            totalPopulation += p;
        }
        System.out.println("Total Population : " + totalPopulation);

        System.out.println("------------------------set of cities-------------------------");
        Set <String> citySet = cityMap.keySet();
        citySet.forEach(System.out::println);
        System.out.println();
        System.out.println("------------------------Map: cityMap-------------------------");

        for (String key : cityMap.keySet()) {
            System.out.println("Key: " + key + ", value: " + cityMap.get(key));
        }
        System.out.println("------------------------Вариант Артема-------------------------");
        cityMap.forEach((key, value) -> System.out.println("Key: " + key + " value: " + value));

        System.out.println("------------------------Entry: cityMap-------------------------");
        //Set <Map.Entry<String, Integer>> ttt =



    }//end main4

}//end class
