package Day1.iList;

import Day1.iList.model.IList;
import HW18.cars.model.Car;

import java.util.ArrayList;
import java.util.List;

public class IListApplication {

    public static void main(String[] args) {

        //список с целыми числами
        IList<Integer> listOfAge = new IListImplementation<> ();

        listOfAge.add(61);
        listOfAge.add(37);
        listOfAge.add(23);
        listOfAge.add(44);
        listOfAge.add(27);
        listOfAge.add(20);
        listOfAge.add(19);
        listOfAge.add(37);
        listOfAge.add(30);
        listOfAge.add(48);
        listOfAge.add(37);
        listOfAge.add(26);
        listOfAge.add(33);
        listOfAge.add(35);

        System.out.println(listOfAge.size());
        System.out.println(listOfAge.indexOf(37));
        System.out.println(listOfAge.indexOf(27));

        int index = 0;
        for (Integer i : listOfAge) {
            System.out.println(index++ + " : " + i);
        }
        System.out.println("---------------------------------------------");
        for (int i = 0; i < listOfAge.size(); i++) {
            if(listOfAge.get(i) == 37){
                System.out.println(i + " : " + "37");
            }
        }
        int sum = 0;
        for (Integer i : listOfAge) {
            sum += i;
        }
        double avgAge = (double) sum / listOfAge.size();
        System.out.println(avgAge);

        //

        IList <String> listOfNames = new IListImplementation<>();
        listOfNames.add("Leonid");
        System.out.println(listOfNames.size());
        listOfNames.add("Artem");
        listOfNames.add("Diana");
        listOfNames.add("Juriy");
        listOfNames.add("Carina");
        listOfNames.add("Dmitriy");
        listOfNames.add("Leonid");
        listOfNames.add(null);
        listOfNames.add("German");
        System.out.println(listOfNames.size());

        int index2 = 0;
        for (String i : listOfNames) {
            System.out.println(index2++ + " : " + i);
        }
        String strTotal = "";
        for (String str : listOfNames) {
            strTotal += str;
        }
        System.out.println();
        System.out.println(strTotal);
        listOfNames.remove(0);
        listOfNames.remove("Carina");

        index = 0;
        for (String l : listOfNames) {
            System.out.println(index++ + " : " + l);
        }
        System.out.println(listOfNames.size());

        List<Car> carList = new ArrayList<>();
        carList.add(0,null);
        System.out.println(carList);


    }//end main


}//end class
