package day16;
//**Задание 4:**
//  Реализовать метод, определяющий, делится ли одно целое число на другое нацело или нет.
public class Task4Devision {
    public static void main(String[] args) {
        int a = 17;
        int b = 9;
        boolean res = isDivided(a,b);
        System.out.println("a = " + a + "; b = " + b + ". Is Divided " + res);
    }//end of main

    public static boolean isDivided (int a, int b){
        return a%b == 0;

    }//end of isDivided

}//end of class
