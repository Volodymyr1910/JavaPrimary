package HW28.weekDay;
////Задача 1. Задать ENUM weekDay - дни недели. Опробовать на нем методы: .values() .toString .ordinal() .valueOf()
////Реализуйте метод, позволяющий прибавлять дни к выбранному дню недели, получая правильный день недели. Пример: Monday + 10 days = Thursday (понедельник + 10 дней = четверг) Проверьте работу метода с помощью теста.
import Day28.season.Season;
import MyMethods.array_methods.ArrayMethods_Object;

////Задача 1. Задать ENUM weekDay - дни недели. Опробовать на нем методы: .values() .toString .ordinal() .valueOf()
public class WeekDayApplication {
    public static void main(String[] args) {


        WeekDay w [] = WeekDay.values();
        ArrayMethods_Object.printObjectArray(w, " + Enum -> method values()");
        WeekDay newDay = null;
        ArrayMethods_Object.insertNewObjectToArrayEndWithReturn(w,newDay);
        ArrayMethods_Object.printObjectArray(w, " Enum after inserting new object -> null");
        System.out.println("----------valueOf()-----------");
        WeekDay myDay = WeekDay.valueOf("TUE");
        System.out.println(myDay);
        ArrayMethods_Object.insertNewObjectToArrayEndWithReturn(w,myDay);
        ArrayMethods_Object.printObjectArray(w, " Enum after inserting new object -> TUE");

        System.out.println("----------toString()-----------");
        String str = WeekDay.FRI.toString();
        System.out.println("FRI is -> " + str);

        System.out.println("----------ordinal()-----------");
       int ind = WeekDay.SAT.ordinal();
        System.out.println(WeekDay.SAT.getName() + " have idex " + ind + ".");


    }//ena main



}//end class
