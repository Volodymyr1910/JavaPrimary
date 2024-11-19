package Day9_lesson20.application;

public class ArgsApplication {

    public static void main(String[] args) {

        // метод main аргумент (String[] args)
        // String[] - это массив данных типа String
        // args - имя массива String[]

        String str1 = args[0];
        //int n1 = Integer.parseInt(str1);

        String str2 = args[1];
        //int n2 = Integer.parseInt(str2);

        String str3 = args[2];
        //int n3 = Integer.parseInt(str3);

        //System.out.println(str1 + " * " + str2  + " = " + n1 * n2);
        System.out.println(str1 + " and " + str2 + " " + str3);




    }//end main
}//end class
