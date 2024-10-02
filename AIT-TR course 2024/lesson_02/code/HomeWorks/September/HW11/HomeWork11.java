package HW11;

public class HomeWork11 {
    public static void main(String[] args) {
       method1();
       ripka();
    }//end of main
    public static void method1(){
        System.out.println("method1 started");
        method2();
        System.out.println("method1 finished");
    }//end of m1
    public static void method2(){
        System.out.println("method2 started");
        method3();
        System.out.println("method2 finished");
    }//end of m2
    public static void method3(){
        System.out.println("method3 started");
        System.out.println("method3 finished");
    }//end of m3

    public static void ripka(){
        System.out.println("Виросла на городі ріпка. Дідусь побачив що вона вже велика і прийшов витягнути !");
        grandPa();
    }//end of ripka
    public static void grandPa(){
        System.out.println("Тягнув дідусь ріпку, але не витягнув. Вирішив покликати бабусю на допомогу !");
        grandMa();
    }//end of grandPa
    public static void grandMa(){
        System.out.println("Тягнули дідусь і бабуся ріпку, але не витягнули. Покликали онучку на допомогу !");
        grandDo();
    }//end of grandMa
    public static void grandDo(){
        System.out.println("Тягнули втрьох, але не витягнули. Покликали собачку на допомогу !");
        dog();
    }//end of grandDo
    public static void dog(){
        System.out.println("Тягнули вчотирьох, але не витягнули. Покликали кішечку на допомогу !");
        cat();
    }//end of dog
    public static void cat(){
        System.out.println("Кішечка прибігла, потягнули п'ятеро. І витягнули !!!");
    }//end of cat
}//end of class

