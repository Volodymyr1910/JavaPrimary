package Day12.programmers_and_technologies;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//1. Кто из программистов знает больше всего языков (поименно)
//   Ф И - > кол-во языков или кол-во языков -> программист
//2. Какие языки пользуются популярностью среди наших программистов
//   язык программирования -> сколько программистов его знают
public class ProgrammerApplication {


    public static void main(String[] args) {

        //data set
        List<Programmer> programmers = fillListProgrammers(); // programmers - новый обьект, внутри которого обьекты, содержащие 2 поля - стринг и лист параметризированный стрингом
        programmers.forEach(System.out::println);

        //print Technology

        System.out.println("================ List of technologies ======================");
        printTechnologies(programmers);

        System.out.println();
        System.out.println("================ Frequency, popular technologies ======================");
        //tecnology => frequancy
        printTechnologiesByFrequency1(programmers);

        System.out.println("================ Frequency, popular technologies sorted ======================");
        printTechnologiesByFrequencySorted(programmers);

        //System.out.println("======================== Technology rating =================================");
        //printTechnologyrating(programmers);

        System.out.println("============= Most Skilled Programmres ============="); // кто с программистов знает больше языков
        printMostSkilledProgrammers(programmers);

    }//end main

    private static void printMostSkilledProgrammers(List<Programmer> programmers) {
        Map <Integer, List <Programmer>> skilledProgrammers = programmers.stream()
                .collect(Collectors.groupingBy(p -> p.getTechnology().size())) ;

        skilledProgrammers.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("---------------------------------------------------------------------");
        //  ищем max
        int max = skilledProgrammers.keySet().stream()
                .max(Integer::compareTo).orElse(0);

        List <Programmer> champ = programmers.stream()
                .filter(programmer -> programmer.getTechnology().size() == max).toList();
        System.out.println(champ);
    }//end


    // from Natalia
    private static void printTechnologiesByFrequency1(List<Programmer>programmers) {
        // Map frequency => technology
       Map< String , Long > technologiesByFrequency = programmers.stream()
                .map(Programmer::getTechnology)  // получаем список технологий каждого программиста
               .flatMap(List::stream)           // объединяем списки в единый поток
                .collect(Collectors.groupingBy(   // группируем по названию технологии
                        technology -> technology,     // ключ - название технологии
                        Collectors.counting()         // считаем количество каждой технологии
               ));
       technologiesByFrequency.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue())) //
                .forEach(entry -> System.out.printf("Технология: %s, Частота: %d%n", entry.getKey(), entry.getValue()));
    }

    // from Elena
    //private static void printTechnologyRating(List<Programmer> programmers) {
    //   Map<String, Long> technologyCount = programmers.stream()
    //           .flatMap(programmer -> programmer.getTechnology().stream())
    //           .collect(Collectors.groupingBy(technology -> technology, Collectors.counting()));
    //
    //   technologyCount.entrySet().stream()
    //           .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
    //           .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    //}




    /*
    private static void printTechnologyrating(List<Programmer> programmers) {
        //Map technology => frequency;
        //Map frequency => technology;
        Map <String,Long> technologiesByFrequency = programmers.stream()
                .map(Programmer::getTechnology)
                .flatMap(List::stream)// собираем с конвеера значения и
                .collect(Collectors.toMap(  //группируем по имени элемента
                       Map.Entry::getKey,  // ключ название технологии
                       Map.Entry::getValue, // считаем количество каждой технологии
                        (e1, e2) -> e1,
                        TreeMap::new
                ));
        System.out.println(technologiesByFrequency);
    }//end printTechnologiesByFrequancy */

    /*
    private static void printTechnologyrating(List<Programmer> programmers) {
       // Map <String, Long> technologyRating = StreamSupport.stream(printTechnologiesByFrequency(List<Programmer> programmers).spliterator(), false).
        Map <String, Long> technologyRating = programmers.stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // сортируем по значению в убывающем порядке
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,               // обработка коллизий, хотя они не должны возникнуть
                        LinkedHashMap::new            // используем LinkedHashMap для сохранения порядка
                ));

    }//end printTechnologyrating */

    private static void printTechnologiesByFrequencySorted(List<Programmer> programmers) {

        List <String> technologies = programmers.stream()
                .map(Programmer::getTechnology)
                .flatMap(List::stream)
                .distinct()
                .sorted().toList();
        technologies.forEach(System.out::println);

        /*TreeMap <Long,String> t = programmers.stream().peek(t.put(
                        .map(Programmer::getTechnology)
                        .flatMap(List::stream)
                        .collect(Collectors.groupingBy(
                                technology -> technology,Collectors.counting()
                ,Programmer::getTechnology))

                )); */

    }//end printTechnologiesByFrequencySorted

    private static void printTechnologiesByFrequency(List<Programmer> programmers) {
        //Map technology => frequency;
        //Map frequency => technology;
        Map <String,Long> technologiesByFrequency = programmers.stream()
                .map(Programmer::getTechnology)
                .flatMap(List::stream)// собираем с конвеера значения и
                .collect(Collectors.groupingBy(  //группируем по имени элемента
                        technology -> technology,  // ключ название технологии
                        Collectors.counting() // считаем количество каждой технологии
                ));
        System.out.println(technologiesByFrequency);
    }//end printTechnologiesByFrequancy

    private static void printTechnologies(List<Programmer> programmers) {
        List<String> technologies = programmers.stream()
                .map(Programmer::getTechnology) // у каждого Programmer берем его technology
                .flatMap(List::stream)// обьединили все technology в один список, для дальнейшей работы
                //.distinct() // убираем дубликаты
                .sorted() // так как на конвеере елементы типа Стринг, включаем сортировку нативную (для Стринг - по алфавиту)
                .toList();
                //.reversed(); - можно развернуть в обратном  - от алфавитного - порядке
        System.out.println(technologies);

        // второй способ убрать дубли
        StreamSupport.stream(technologies.spliterator(), false) // подключаемся второй раз к потоку для продолжения работы с ним, аргумент false - сообщаем что не нужно обрабатывать в паралельных потоках
                .distinct()
                .forEach(System.out::println);

    }//end printTechnologies

    private static List<Programmer> fillListProgrammers() {
        return List.of(
                new Programmer("Peter", List.of("C++", "Pyton", "Java", "Kotlin")),
                new Programmer("John", List.of("Python", "Java")),
                new Programmer("Helen", List.of("Kotlin", "Scala", "Java", "JavaScript")),
                new Programmer("Jakob", List.of("Python", "Go")),
                new Programmer("Mike", List.of("Fortran", "Algol", "PL-1"))
        );
    }//end fillListProgrammers


}//end class
