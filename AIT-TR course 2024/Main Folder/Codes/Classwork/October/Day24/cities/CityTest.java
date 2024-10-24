package Day24.cities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.beancontext.BeanContextChild;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {
    City[] cities;

    @BeforeEach
    void setUp() {

        cities = new City[]{

                new City("Denver", 600_000),
                new City("Boston", 670_000),
                new City("Chicago", 2_700_000),
                new City("Atlanta", 470_000),
                new City("New York", 8_500_000),
                new City("Dallas", 1_300_000),

        };
    }//end setUp


    public void printArray(Object[] array, String titleOfReport) {
        System.out.println("-------------------" + titleOfReport + "------------------");
        for (Object anyNameVariable : array) {
            System.out.println(anyNameVariable);
        }//end for
    }//end printArray

    //Распечатать в отсортированном виде.
//Есть ли в списке городов город с населением 1.2 млн человек?
//Отсортируйте список по алфавиту.
//Есть ли в списке город по имени Chicago? Какой он имеет номер в списке?
    @Test
    void testComparable() {
        printArray(cities, "List of cities as is");
        Arrays.sort(cities);
        printArray(cities, "List of cities sorted by population");
        City pattern = new City(null, 600_000);
        int index = Arrays.binarySearch(cities, pattern);
        System.out.println(index);
    }//end testComparable

    @Test
    void testComparatorByName() {

        Comparator<City> compByCityName = new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Arrays.sort(cities, compByCityName);
        printArray(cities, "List of cities sorted by name");
        City pattern = new City("Las Vegas", 0);
        //int index = Arrays.binarySearch(cities, pattern, compByCityName);
        int index = Arrays.binarySearch(cities, pattern, ((o1, o2) -> o1.getName().compareTo(o2.getName())));
        if (index >= 0) System.out.println("Founded  city " + pattern.getName() + " on index " + index);
        else System.out.println("City " + pattern.getName() + " not founded. But it could be on index " + (-index - 1));
        System.out.println(index);
    }//end testComparatorByName


//Скопируйте массив в другой, имеющий в 2 раза большую длину.
//Отсортируйте полученный массив.
//Имеется ли в списке городов город Salem?
//"Salem", 690_000

    @Test
    void testArrayCopy() {

        City[] citiesCopy = Arrays.copyOf(cities, cities.length * 2);
        printArray(citiesCopy, "CitiesCopy as is");
        System.out.println(citiesCopy.length);
        Comparator<City> compByName = Comparator.nullsLast((c1, c2) -> c1.getName().compareTo(c2.getName())); // передать лямбду сразу компаратору, и сообщаем компаратору что в конце массива есть нули
        Arrays.sort(citiesCopy, compByName);
        printArray(citiesCopy, "CitiesCopy after sort by name");

        City pattern = new City("Salem", 0);
        int index = Arrays.binarySearch(citiesCopy, 0, cities.length, pattern, compByName); // ищет от индекса 0 по заполненным полям
        System.out.println(index); // size = -index-1 ----> это для меня, для понимания как можно получить индекс, куда поставить новый обьект, для дальнейшего использования
    }//end testArrayCopy

    //Вставить город Salem в список, сохранив сортировку по населению !
    //вставляем в имеющийся список
    @Test
    void testInsertKeepSorting() {
        //описан алгоритм как добавить в массив обьектов новый обьект, не нарушив его сортировку

        Arrays.sort(cities); //сортируем по умолчанию (по популяции в данном примере)
        printArray(cities, "List of cities sorted by population - native sorting");
        //increase up to 7
        //создаем новый массив с обьектами City [] citiesCopy7, копируем - методом  copyOf из класса Arrays - массив cities в массив citiesCopy7, который получает размер  на 1 больше исходного cities
        //а значит последний элемент массива citiesCopy7 - является null
        City[] citiesCopy7 = Arrays.copyOf(cities, cities.length + 1);

        // создаем новый обьект, который хотим добавить в массив обьектов citiesCopy7
        City city = new City("Boston", 670_000);

        //включаем защиту на добавление дубликата
        int checker = 0;
        for (City c : cities) {
            if (c.equals(city))  System.out.println(" We allready have this town !");
            else checker++;
        }//end for

        //если в массиве еще нет такого обьекта, идем дальше
        if (checker > 0) {
            int index = Arrays.binarySearch(citiesCopy7, 0, citiesCopy7.length - 1, city);
            index = index >= 0 ? index : -index - 1; // обработка индекса для дальнейшего использования
            //подготовили место для вставки методом arraycopy из класса System
            System.arraycopy(citiesCopy7, index, citiesCopy7, index + 1, citiesCopy7.length - index - 1);
            //System.arraycopy(citiesCopy7 - массив с которого копируем, index - с какого индекса копируем, citiesCopy7 - массив в который копируем, index+1 - индекс куда ставим копируемый массив, citiesCopy7.length - index - 1 - обозначаем длину хвоста, начало котрого сдвигается на место index+1);
            //таким образом все что было от индекса index в массиве citiesCopy7 сдвигается вправо на индекс index + 1
            //а значит место с индексом index теперь пустое - null; кладем наш добавляемый обьект на свободное место
            citiesCopy7[index] = city;
            // переопределили ссылку на массив, т.е.
            cities = citiesCopy7;
            printArray(cities, "List of cities after adding new city");
        }//end if
    }//end testInsertKeepSorting


}//end class