package Day11.stream_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Возьмите список городов, отфильтруйте только те названия, которые начинаются с заданной буквы,
//преобразуйте их в верхний регистр и выведите в алфавитном порядке.
public class CityStream {

    public static void main(String[] args) {

        List<String > cityList = new ArrayList<>(Arrays.asList("Augsburg", "Munich", "berlin", "Heidelberg", "Worms", "Frankfurt am Main", "Bremen", "Bonn", "Braunschweig"));

   char firstLetter = 'b';

   List <String> result = filterCities(cityList, firstLetter);

   result.forEach(System.out::println);

    }//end class

    private static List<String> filterCities(List<String> cityList, char firstLetter) {
        return cityList.stream().filter(city -> city.toLowerCase().startsWith(String.valueOf(firstLetter))).map(String::toUpperCase).sorted().toList().reversed();
        // опускаем в нижний регистр, отбираем значения с первой буквой, которую ищем, затем все в верхний регист, сортируем по алфавиту(для String по умолчанию), перекладываем с стрима в лист, делаем реверс
    }//end filterCities


}//end class
