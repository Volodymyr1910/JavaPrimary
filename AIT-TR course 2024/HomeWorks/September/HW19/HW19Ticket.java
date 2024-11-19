package HW19;

import java.util.Scanner;
//Задача 4. В кинотеатре есть разные типы билетов: стандартный, студенческий (-10%) и для пенсионеров(-25%).
// Каждый тип билета имеет свою стоимость. Клиент может также выбрать место в VIP-зоне, что увеличит стоимость билета на 25%.
//Создайте метод calculateTicketPrice, который принимает возраст клиента, статус студента и флаг VIP-места, а возвращает итоговую стоимость билета.
//Реализуйте приложение-бот, которое задает необходимые вопросы и объявляет стоимость билета.
public class HW19Ticket {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Good day ! Enter your age, please: ");
        int x = scanner.nextInt();
        int y = 10; // ticket start cost
        double price = y;
        if (x < 23){
            System.out.println("Are you a student? y/n");
            //scanner.nextLine(); // вариант 1
            //String q = scanner.nextLine(); // вариант 1
            String q = scanner.next(); // вариант 2

            if (q.equals("y")){
                System.out.println("You have 10% discount. Be ready to present your student documents");
                price = y * 0.9;
            }//end if q
        } else if (x>=65) {
            price = y * 0.75;
            System.out.println("You have 25% discount. Be ready to present your pension certificate.");
        }//end if x
        System.out.println("Do you want to have VIP-zone place ? It cost 25% extra.");
        System.out.println("Press 1 for ussual or Press 2 for VIP-zone:");
        x = scanner.nextInt();
        while (x < 1 | x > 2 ){
            System.out.println("Wrong input. 1 for ussual or 2 for VIP. Make your choise, please:");
            x = scanner.nextInt();
        }//end while x
        switch (x){
            case 2 : {
                price = price * 1.25;
                System.out.printf("Total cost of movie-ticket is: %.2f",price);
                System.out.println(" euro");
                break;
            } default:{
                System.out.printf("Total cost of movie-ticket is: %.2f",price);
                System.out.println(" euro");
            }//end default
        }//end switch x
    }
}
