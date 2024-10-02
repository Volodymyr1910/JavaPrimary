package HW16;

public class HomeWork16 {

    public static void main(String[] args) {
        // минимальное из двух целых чисел
        int a = 20;
        int b = 25;
        int min = findLowerNumber(a,b);
        System.out.println("We have two numbers: " + a + " and " + b + ". " + min + " is the lower number.");

        //выполнимость неравенства треугольника
        a = 5;
        b = 15;
        int c = 18;
        if (a < b + c ){
            if (b < a + c){
                if (c < a + b){
                    System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is possible.");
                }else{
                    System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is not possible.");
                }//end of if
            }else{
                System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is not possible.");
            }//end of else
        }else{
            System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is not possible.");
        }//end of else

        // Шопинг
        double n1 = 2; // Ко-во купленных ноутбуков
        double p1 = 8; // Цена одного ноутбука
        double d1 = 3; // Скидка на ноутбук в процентах
        double n2 = 1; // Ко-во купленных холодильников
        double p2 = 15; // Цена одного холодильника
        double d2 = 5; // Скидка на холодильник в процентах

        double res1 = totalPriceLaptop(n1, p1, d1);
        double res2 = totalPriceFridge(n2, p2, d2);
        double totalPrice = res1 + res2;
        if (totalPrice>100){
            double finalTotalPrice = totalPrice * 0.95;
            double finalTotalDiscount = d1 + d2 + 10;
            System.out.println("Congratulations ! You bought " + n1 + " laptops and " + n2 + " fridges.");
            System.out.printf("Total price is %.2f", finalTotalPrice);
            System.out.println(" euro. You received " + finalTotalDiscount + " % of discount !");

        }else {
            double finalTotalPrice = totalPrice;
            double finalTotalDiscount = d1 + d2;
            System.out.println("Good job! You bought " + n1 + " laptops and " + n2 + " fridges.");
            System.out.printf("Total price is %.2f",finalTotalPrice);
            System.out.println(" euro with " + finalTotalDiscount + " % discount !");
            double secondChance = 100 - totalPrice;
            System.out.println("Make purchases worth " + secondChance + " euro. And You will get an extra discount 10% !");
        }//end of else



    }//end of main

    private static double totalPriceLaptop ( double n1, double p1, double d1){ // Шопинг
        double res1 = (p1 - (p1 * (d1/100))) * n1;
        return  res1;
    }//end of totalPriceLaptop

    private static double totalPriceFridge( double n2, double p2, double d2 ){ // Шопинг
        double res2 = (p2 - (p2 * (d2/100))) * n2;
        return res2;
    }//end of totalPriceFridge


    private static int findLowerNumber(int a, int b ) {  // минимальное из двух целых чисел
        if (a >= b) ;
        int min = b;
        if (a<b);
        min = a;
        return min;
    }//end of findLowerNumber

}//end of class