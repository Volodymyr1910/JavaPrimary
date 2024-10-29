package MyMethods.enum_variants.season;

import MyMethods.array_methods.ArrayMethods_Object;

//Задать ENUM seasons - времена года (Summer, Autumn, Winter, Spring)
//Опробовать на нем методы:
//.values() - извлекает данные в массив
//.toString - выбраный Enum перегоняет в тип String
//.ordinal() - отдает индекс (тип int) выбраного Enum, если б он был в массиве
//.valueOf() - выбраный Enum перегоняет в, такой же тип, как тип  Enum
public class SeasonApplication {


    public static void main(String[] args) {

        Season seasons [] = Season.values();
        ArrayMethods_Object.printObjectArray(seasons, "values of Enum");
        System.out.println("------------------------------------------------------------------------------------");
        for (int i = 0; i < seasons.length; i++) {
            System.out.println(seasons[i].getNumber() + " : " + seasons[i].getName());
            System.out.println(seasons[i]);
        }//end for

        // for each
        System.out.println("------------------------------------------------------------------------------------");
        for (Season s : seasons) {
            System.out.println(s.getName());
            System.out.println(s.getDuration());
        }//for

        System.out.println("------------------------------------toString для Enum------------------------------------------");
        String str = Season.AUTUMN.toString();
        System.out.println(str);  // -> Season{name='Autumn', duration=91, number=4}


        System.out.println("------------------------------------ordinal()------------------------------------------");
        int num = Season.AUTUMN.ordinal(); // печатает индекс
        System.out.println(num); // -> 3
        int num2 = Season.WINTER.ordinal(); // печатает индекс
        System.out.println(num); // -> 0


        System.out.println("------------------------------------valueOf()------------------------------------------");
        Season s = Season.valueOf("SUMMER"); // стринг должен соответствовать имени Enum
        System.out.println(s);






    }//end main



}//end class
