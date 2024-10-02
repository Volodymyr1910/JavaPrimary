package HW16;

public class HomeWork16TriangleExtra {

    public static void main(String[] args) {
        //выполнимость неравенства треугольника
        int a =10 ;
        int b = 11;
        int c = 12;
        if (a < b + c ){
            if (b < a + c){
                if (c < a + b) {
                    System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is possible.");
                    if (a == b) {
                        if (a == c) {
                            System.out.println("All sides of your triangle is equal!");
                        } else {
                            System.out.println("Your triangle have two equal sides.");
                        }//end of else1
                    }//end of if1
                    if (b == c) {
                        if (a != b) {
                            System.out.println("Your triangle have two equal sides.");
                        }
                    }//end of if2
                    if (a == c) {
                        if (a != b) {
                            System.out.println("Your triangle have two equal sides.");
                        }
                    } if(a!=b){
                        if (b!=c) {
                            System.out.println("All three sides of your triangle are different.");
                        }
                    }
                }else{
                   System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is not possible.");
                }//end of else
            }else{
                System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is not possible.");
            }//end of else
        }else{
            System.out.println("We have three Trianglesides: " + a + ", " + b + ", and " + c + ". Building of Triangle is not possible.");
        }//end of else

    }//end of main
}//end of class