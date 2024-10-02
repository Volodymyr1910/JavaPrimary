package Day12;
//Задать целочисленные переменные x и y, выполнить c ними математические действия, напечатать результаты вместе с текстовыми пояснениями:
//- какие переменные участвовали;
//- какие действия с ними выполнялись;
//- что получилось в результате.
public class MassOperations {
    public static void main(String[] args) {

        int x = 38;
        int y = 63;
        System.out.println(x + y);
        int res = x + y;
        System.out.println("x = " + x + " додаємо y = " + y + ". Результат: " + res);

        res=x - y;
        System.out.println("x= " + x + " віднімаємо y = " + y + ". Результат: " + res);

        //ділення дає цілу частину від ділення
        res = y/x;
        System.out.println("y = " + y + " / x = " + x + ". Результат: " + res);

        //% показує залишок від ділення
        res = y % x;
        System.out.println("y = " + y + " % x = " + x + ". Результат: " + res);
    }//end of main
}//end of class
