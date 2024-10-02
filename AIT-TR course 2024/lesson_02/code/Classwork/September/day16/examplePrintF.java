package day16;
/*Расчет Гипотенузы по двум катетам (теорема Пифагора).с применением PrintF*/
public class examplePrintF {
    public static void main(String[] args) {
        double k1 = 2; //Введіть величину першого катета
        double k2 = 4; //Введіть величину другого катета
        double g = gipotenuza(k1, k2); // вказує що результати розрахунку в методі gipotenuza повернути в цю строку
        double gk = sqrtGipotenusa(g);

        System.out.println("Triangle has 2 katets: " + k1 + " and " + k2 + ". Gipotenuse is: " + gk + "."); // Виведення на консоль результату розрахунку гіпотенузи
        System.out.printf("Gipotenuse is: %.0f", gk);
        System.out.println(".");
        System.out.println("The end.");
    }//End of main
    public static double sqrtGipotenusa(double g){
        return Math.sqrt(g);
    }//end of sqrtGipotenusa

    public static double gipotenuza(double x, double y) { // Метод що виконує розрахунки гіпотенузи
        return y + x * x; // формула розрахунку і команда на повернення отриманого результату в метод main
    }// end of gipotenuza
}//end of class