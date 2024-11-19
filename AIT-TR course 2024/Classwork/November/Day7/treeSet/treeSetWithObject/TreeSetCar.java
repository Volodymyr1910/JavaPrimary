package Day7.treeSet.treeSetWithObject;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetCar {

    public static void main(String[] args) {

        TreeSet<Car> carTreeSet = new TreeSet<>();

        Car[] cars = new Car[5];
        cars[0] = new Car("N4", "Model1", "C1", 2.0, "red");
        cars[1] = new Car("N3", "Model2", "C2", 2.5, "red");
        cars[2] = new Car("N2", "Model1", "C3", 3.0, "green");
        cars[3] = new Car("N1", "Model3", "C1", 1.4, "gray");
        cars[4] = new Car("N4", "Model2", "C3", 2.5, "red");

        for (Car car : cars) {
            carTreeSet.add(car);
        }//end for

        System.out.println(carTreeSet.size()); // 4, without duplicate  cars[4]

        for (Car car : carTreeSet) {
            System.out.println(car);
        }//end for
        System.out.println("===================================================================");
        Comparator <Car> compByColor = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                //return o1.compareTo(o2);
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        System.out.println("----------------------------------------------------------");
        TreeSet <Car> treeSetByColor =  new TreeSet<>(compByColor); // кампаратор изменил "уникальный элемент" по которому происходит сравнение

        for (Car car : cars) {
            treeSetByColor.add(car);
        }//end for

        for (Car car : treeSetByColor) {
            System.out.println(car);
        }//end for
        System.out.println("================================================");



        TreeSet <Car> carTreeSetByCompany = new TreeSet<>(Comparator.comparing(Car::getCompany));

        for (Car car : cars) {
        carTreeSetByCompany.add(car);
        }
        System.out.println("´´´´´´´´´´´´´´´´´´´99999999999999999999999999999999999999999999999999--------------------------");
        for (Car car :  carTreeSetByCompany) {
            System.out.println(car);
        }
    }//main




}//end class
