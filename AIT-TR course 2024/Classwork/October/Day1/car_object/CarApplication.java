package Day1.car_object;

import Day1.car_object.model.Car;

public class CarApplication {

    public static void main(String[] args) {
        //создали обьект с актуальными данными, create object with real data
        Car myCar =  new Car("VW",2014,15000,"silver",false);
        System.out.println(myCar.display()); // отдаем рузультат работы метода на печать
        //результат с консоли:
        //Car{brand='VW', year=2014, price=15000.0, color='silver', isNew=false}
        System.out.println("------");
        //System.out.println(myCar); // так можно если имя метода не display а - toString (т.е. если не меняли)

        myCar.move();
        myCar.stop();

    }//end main
}//end class
