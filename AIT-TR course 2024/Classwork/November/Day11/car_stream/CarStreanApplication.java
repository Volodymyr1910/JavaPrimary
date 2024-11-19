package Day11.car_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//- Перебор всех элементов carList с помощью forEach() и вывод их в консоль
//- Перебор всех элементов с выполнением некоторой операции над каждым элементом списка и вывод их в консоль:
//    - Из регистрационного номера - достаньте только буквы
//- Сортировка списка по полю age
//- Сортировка списка по нескольким свойствам: brand, age, color.
//- Рассчитать средний возраст автомобилей
//- Сделать проверку, что у всех Car возраст (age) больше 5 лет
//- Определить количество машин разных цветов
public class CarStreanApplication {

    public static void main(String[] args) {
        List<CarStream> cars = Arrays.asList(
                new CarStream("AB123CD", "Audi", 8, "Red"),
                new CarStream("EF456GH", "Mercedes", 3, "Black"),
                new CarStream("IJ789KL", "Audi", 10, "Blue"),
                new CarStream("MN012OP", "Tesla", 3, "Green"),
                new CarStream("QR345ST", "Volkswagen", 6, "Red"),
                new CarStream("UV678WX", "Tesla", 2, "Green"));


        printCars(cars);
        printLettersOfRegNumber(cars);

        List<CarStream> carsByAge = sortCayrByAge(cars);
        System.out.println("---------------------------------------Cars sorted by Age------------------------------");
        printCars(carsByAge);

        System.out.println("---------------------------------------Cars sorted by Brand, Age, Color------------------------------");
        List <CarStream> carsSorted = sortCayrByBrandAgeColor(cars);
        printCars(carsSorted);

        System.out.println("---------------------------------------Cars collecting by colors------------------------------");

        Map<String, List<CarStream>> carsByColor = cars.stream()
                .collect(Collectors.groupingBy(CarStream::getColor));

        //carsByColor.forEach((key, value) -> System.out.println(key + " : " + value));

        for (String color : carsByColor.keySet()) {
            System.out.println("Color: " + color + " , cars: " + carsByColor.get(color).size());
        }

    }//end main

    private static List<CarStream> sortCayrByBrandAgeColor(List<CarStream> cars) {

        return cars.stream()
                .sorted(Comparator.comparing(CarStream::getBrand)
                        .thenComparing(CarStream::getAge)
                        .thenComparing(CarStream::getColor)
                )
                .toList();



    }//end sortCayrByBrandAgeColor

    private static List<CarStream> sortCayrByAge(List<CarStream> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(CarStream::getAge))
                .toList();
    }//end sortCayrByAge

    private static void printLettersOfRegNumber(List<CarStream> cars) {
        System.out.println(cars.stream().
                map(carStream -> {
                    return new CarStream(
                            carStream.getRegNumber().substring(0, 2),
                            carStream.getBrand(),
                            carStream.getAge(),
                            carStream.getColor()
                    );
                })
                .toList()
        );
        //чтобы все буквы из номера выводило вот так можно
        //carStream.getRegNumber().replaceAll("[^A-Z]", ""),
    }//end printLettersOfRegNumber

    private static void printCars(List<CarStream> cars) {
        cars.stream().forEach(c -> System.out.println(c));
    }//end printCars


}//end class
