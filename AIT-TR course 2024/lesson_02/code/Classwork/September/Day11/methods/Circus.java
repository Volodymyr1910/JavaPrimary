package Day11.methods;

public class Circus {
    public static void main(String[] args) {

        lightOn();
        entertainer();
        lightOff();

    }// end of main
    public static void lightOff(){
        System.out.println("Lights Off !");
    }//end of lightOff
    public static void lightOn(){
        System.out.println("Light ON !!!");
    }// end of lightOn
    public static void entertainer(){
        jogger();
        clown();
        singer();
    }// end of Entertainer
    public static void jogger(){
        System.out.println("I am jogging ... ");
    }// end of jogger
    public static void clown(){
        System.out.println("I am jocking... ");
    }// end of clown
    public static void singer(){
        System.out.println("I am singing... ");
    }// end of singer

}// end of class

