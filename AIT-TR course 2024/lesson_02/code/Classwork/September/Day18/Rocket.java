package Day18;
//Запустить обратный отсчет старта ракеты от 10 до 0.
//Последнее сообщение: "Поехали!...".
public class Rocket {
    public static void main(String[] args) {
        int countDown = 10;
        System.out.println("We have " + countDown + " seconds before start !");

        while (countDown != 0){
            countDown --; //уменшает значение переменной на 1 единицу
            System.out.println("We have " + countDown + " seconds before start.");
        }
        System.out.println("Countdown is over! Rocket has been started !");
    }//end of main
}//end of class
