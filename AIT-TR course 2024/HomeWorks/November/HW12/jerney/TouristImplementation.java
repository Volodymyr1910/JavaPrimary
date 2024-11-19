package HW12.jerney;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
//Необходимо ответить на вопросы:
//

//Кто из клиентов посетил наибольшее количество стран?
public class TouristImplementation {
    public static void main(String[] args) {

        List<Tourist> tourists = fillListTourists(); // programmers - новый обьект, внутри которого обьекты, содержащие 2 поля - стринг и лист параметризированный стрингом
        tourists.forEach(System.out::println);

        //Кто из клиентов посетил наибольшее количество стран?
        //нужно найти наибольшее количество стран, затем всех туристов с таким количеством стран
        getListMostActiveTourists(tourists);

        //Какие страны наиболее популярны?
        // каждую страну нужно переложить в лист
        TreeMap <Long, List<String>> sortedMostPopularCountries = getMostpopularCountries(tourists);
        System.out.println("Most popular curortzone is -> " + sortedMostPopularCountries.get(sortedMostPopularCountries.lastKey()));

    }//end main

    private static TreeMap <Long, List<String>> getMostpopularCountries(List<Tourist> tourists) {
        Map<String, Long> mostPopular = tourists.stream().map(Tourist::getCountry).flatMap(List::stream).collect(Collectors.groupingBy(country -> country, Collectors.counting()));
        Map<Long, List<String>> mostPopularCountries = mostPopular.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        TreeMap <Long, List<String>> sortedMostPopularCountries = new TreeMap<>(mostPopularCountries);
        System.out.println();System.out.println(" Frequency of countries: ");sortedMostPopularCountries.forEach((key, value) -> System.out.println(key + " : " + value));
        return sortedMostPopularCountries;
    }//end getMostpopularCountries

    private static void getListMostActiveTourists(List<Tourist> tourists) {
        int max = tourists.stream().map(tourist -> tourist.getCountry().size()).max(Integer::compareTo).orElse(0);
        System.out.println("Most active tourists: ");tourists.stream().filter(tourist -> tourist.getCountry().size() == max).forEach(n -> System.out.println(n));
    }//end getListMostActiveTourists

    private static List<Tourist> fillListTourists() {
        return List.of(
                new Tourist("Name", List.of("C1", "C2", "C3")), new Tourist("Olesia", List.of("Iran", "Kyrgystan", "United Arab Emirates", "France", "Italy", "Portugal", "Spain")), new Tourist("Bilbo Baggins", List.of("Italy", "Spain", "Turkey")), new Tourist("Tatyana", List.of("Italy", "Spain", "Italy", "Greece", "Turkey")), new Tourist("Anton", List.of("Germany", "Nederland", "Turkey", "Georgia")), new Tourist("Sergei_B", List.of("Tunis", "Turkey", "China", "Vietnam")), new Tourist("Galina", List.of("Italy", "France", "Italy")), new Tourist("Anatoly", List.of("Montenegro", "Albania", "Greece", "Italy")), new Tourist("Andrii", List.of("UK", "Ireland", "Spain")), new Tourist("Liubov", List.of("Croatien", "Slovenien", "Spain", "France", "Egypt")), new Tourist("Liam", List.of("Spain", "Portugal", "Morocco", "Cyprus")), new Tourist("Emma", List.of("Greece", "Turkey", "Croatia", "Montenegro")), new Tourist("Mia", List.of("Italy", "Malta", "Spain", "Turkey")), new Tourist("Noah", List.of("Turkey", "Greece", "Italy", "Croatia")), new Tourist("Olivia", List.of("Croatia", "Montenegro", "Albania", "Greece")), new Tourist("Lucas", List.of("Portugal", "Spain", "France", "Italy")), new Tourist("Amelia", List.of("Greece", "Cyprus", "Spain", "Italy")), new Tourist("Oliver", List.of("Spain", "Italy", "Turkey", "Greece")), new Tourist("Isabella", List.of("France", "Spain", "Italy", "Greece")), new Tourist("Ethan", List.of("Italy", "Greece", "Spain", "Croatia")), new Tourist("Ava", List.of("Greece", "Turkey", "Spain", "Italy")), new Tourist("Liam", List.of("Spain", "Italy", "Morocco", "Greece")), new Tourist("Sophia", List.of("Italy", "Spain", "Turkey", "Greece")), new Tourist("Jackson", List.of("Greece", "Spain", "Italy", "Croatia")), new Tourist("Olivia", List.of("Croatia", "Greece", "Italy", "Montenegro")), new Tourist("Logan", List.of("Spain", "Greece", "Italy", "Turkey")), new Tourist("Emma", List.of("Greece", "Italy", "Spain", "Cyprus")), new Tourist("Aiden", List.of("Italy", "Greece", "Spain", "Turkey"))
        );
    }//fillListTourists


}//end class
