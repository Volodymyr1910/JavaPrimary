package Day17;
//Задайте в программе две переменные и их значения, которые отвечают за координаты точки на плоскости.
//  Определите в какую четверть попадает точка с этими координатами.
public class CoordinateXY {
    public static void main(String[] args) {
        int x = 35;
        int y = -76;

        if (x>0 & y>0){
            System.out.println("Point is in first quarter.");
        }//end of if1
        if (x>0 & y==0){
            System.out.println("Point is in first quarter.");
        }//end of if
        if (x<0 & y==0){
            System.out.println("Point is in first quarter.");
        }//end of if
        if (x==0 & y>0){
            System.out.println("Point is in first quarter.");
        }//end of if
        if (x==0 & y<0){
            System.out.println("Point is in first quarter.");
        }//end of if

        if (x<0 & y>0){
            System.out.println("Point is in second quarter.");
        }//end of if2

        if (x<0 & y<0){
            System.out.println("Point is in third quarter.");
        }//end of if3

        if (x>0 & y<0){
            System.out.println("Point is in fourth quarter.");
        }//end of4
        if (x==0 & y==0){
            System.out.println("Point is in zero.");
        }//end of if5

    }//end of main

}//end of class
