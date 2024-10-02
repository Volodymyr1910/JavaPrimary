package HW23;
//Собрать в массив данные о дневной температуре в вашем городе за прошедшую неделю. Выведите на печать температуру, которая была во вторник и затем в четверг.
// Найти среднюю температуру за прошлую неделю.
public class DayTemperature {
    public static void main(String[] args) {

        //double [] dayTemperature = {15.2, 17, 18.9, 13, 16.2, 18.5, 18.7};
        double a = 15;
        double b = 18.5;

        double [] dayTemperature = new double[7];

        for (int i = 0; i < dayTemperature.length; i++) {
            dayTemperature[0] = (Math.random() * (b - a + 1) + a);
            dayTemperature[1] = (Math.random() * (b - a + 1) + a);
            dayTemperature[2] = (Math.random() * (b - a + 1) + a);
            dayTemperature[3] = (Math.random() * (b - a + 1) + a);
            dayTemperature[4] = (Math.random() * (b - a + 1) + a);
            dayTemperature[5] = (Math.random() * (b - a + 1) + a);
            dayTemperature[6] = (Math.random() * (b - a + 1) + a);

        }//end for
        System.out.printf("There was %.1f", dayTemperature[1]);
        System.out.println(" degrees on Tuesday.");
        System.out.printf("There was %.1f", dayTemperature[3]);
        System.out.println(" degrees on Thursday.");
        double sum = 0;
        for (int i = 0; i < dayTemperature.length; i++) {
            sum = sum + dayTemperature[i];
        }//end for
        double averageTemperature = sum / dayTemperature.length;

        System.out.printf("Last week average temperature was %.1f", averageTemperature);
        System.out.println(" degrees.");
    }//end main
}//end class
