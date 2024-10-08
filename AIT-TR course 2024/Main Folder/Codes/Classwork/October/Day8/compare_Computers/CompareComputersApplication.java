package Day8.compare_Computers;
//Сравнение двух объектов типа Computer. Использование метода equals для сравнения объектов.
import java.util.Scanner;

public class CompareComputersApplication {

    public static void main(String[] args) {

    Computer c1 = new Computer("i7", 32, 1024, "HP", 1500);
        System.out.println(c1);
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input CPU: ");
        String cpu = scanner.nextLine();
        System.out.println("Input RAM: ");
        int ram = scanner.nextInt();
        System.out.println("Input SSD: ");
        int ssd = scanner.nextInt();
        System.out.println("Input Brand: ");
        scanner.nextLine();
        String brand = scanner.nextLine();
        System.out.println("Input price: ");
        double price = scanner.nextDouble(); */

        Computer c2 = new Computer("i7", 32, 1024, "HP", 1500);
        System.out.println(c2);

        //compare links, but not the objects
        boolean checker = (c1 == c2);
        System.out.println(checker); // false, because links NOT equal

        System.out.println("---------------------");
        checker = c1.equals(c2);
        System.out.println(checker);


    }//end main
}//end class
