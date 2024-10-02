package Day13;

public class mathMethods {
    public static void main(String[] args) {
        //перевод долларов в эвро
        double money = 500; //dollars
        double euro = exchangeDollarsToEuro(money);
        System.out.println("I have " + money + " dollars. After exchange, I have " + euro + " euro.");

        //количество сьеденных каллорий
        double food = 200; //gramm
        double colorage = 50; // casllories on 100 gramm
        double energyCallories = callories(food,colorage);
        System.out.println("We eat " + food + " gramms of food. We have " + energyCallories + " callories.");

        //расход топлива по пройденным километрам
        double fuel = 10; //расход топлива л/100км
        double range = 500; //пройденный путь
        double fuelcomsumption = fueleat(fuel,range);
        System.out.println("Our fuelcomsumption is " + fuel + " litres for 100km. We drived " + range + " km. We spend " + fuelcomsumption + " litres of fuel.");


    }//end of main
    private static double fueleat (double x, double y){
        return x * y /100;
    }//end of fueleat


    private static double exchangeDollarsToEuro(double money){
        double rate = 0.9;
        return money * rate;
    }// end of exchangeDollarsToEuro

    private static double callories (double food, double colorage){
        return (food * colorage)/100;
    }//end of callories




}//end of class
