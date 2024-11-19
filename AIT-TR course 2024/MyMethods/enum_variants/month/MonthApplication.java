package MyMethods.enum_variants.month;


public class MonthApplication {


    public static void main(String[] args) {
        int k = 35;
        Month m = Month.AUG;
        System.out.println(m);
        System.out.println("-------------after " + k + " month----------------------");
      m = m.plusMonth(k);
        System.out.println(m);



    }//end  main
}//end class
