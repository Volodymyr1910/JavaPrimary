package HW13;

public class HomeWork13 {
/*Напишите методы для конвертации валюты:
    евро в доллары США
    евро в британские фунты
    евро в китайские юани и проверьте их работу, вызвав их в main.
    Напишите метод, который переводит градусы Цельсия в градусы по Фаренгейту. Формулу пересчета найти в Интернете. Вызовите метод в main.

    Создайте метод, который пересчитывает морские мили в километры. 1 морская миля = 1852 метра.*/
    public static void main(String[] args) {

        //расход топлива по пройденным километрам
        double fuel = 10; //расход топлива л/100км
        double range = 500; //пройденный путь
        double fuelcomsumption = fueleat(fuel,range);
        System.out.println("Our fuelcomsumption is " + fuel + " litres for 100km. We drived " + range + " km. We spend " + fuelcomsumption + " litres of fuel.");

        //евро в доллары США
        double dollars = 350; //количество имеющихся долларов
        double euro = dollarsToEuro (dollars);
        System.out.println("If we sell " + dollars + " Dollars, we can buy " + euro + " Euro.");

        //евро в британские фунты
        double euro1 = 350; //количество имеющихся эвро
        double pound = euroToPounds (euro1);
        System.out.println("If we sell " + euro1 + " Euro, we can buy " + pound + " Pounds.");

        //евро в китайские юани
        double euro2 = 350; //количество имеющихся эвро
        double chineseYuan = euroToChineseYuanes (euro2);
        System.out.println("If we sell " + euro2 + " Euro, we can buy " + chineseYuan + " Chinese Yuanes.");

        //градусы Цельсия в градусы по Фаренгейту
        double gradC = 15;
        double f = cToF (gradC);
        System.out.println(gradC + " градусов Цельсия это - " + f + " градусов по шкале Фаренгейта.");

        //морские мили в километры
        double miles = 70;
        double km = mToKm (miles);
        System.out.println("Путь в - " + miles + " морских миль, равняется " + km + " километрам");



    }//end of main
    private static double mToKm (double x){// конвертация морских миль в километры
        return x * 1.852;
    }//end of mToKm

    private static double cToF (double x){// конвертация градусов °C в градусы по F
        return x * 9/5 + 32;
    }//end of cToF

    private static double dollarsToEuro (double x){// конвертация доллара в эвро
        return x * 0.9;
    }//end of dollarsToEuro

    private static double euroToPounds (double x){// конвертация эвро в фунты-стерлинги
        return x * 0.84;
    }//end of euroToPounds

    private static double euroToChineseYuanes (double x){// конвертация эвро в китайские юани
        return x * 7.86;
    }//end of euroToChineseYuanes

    private static double fueleat (double x, double y){ //метод расчета расхода топлива
    return x * y /100;
    }//end of fueleat

}//end of class
