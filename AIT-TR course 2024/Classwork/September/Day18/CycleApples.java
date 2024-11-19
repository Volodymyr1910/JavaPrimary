package Day18;



//Задача о яблоках (начальное значение 30 яблок).
//// Запустить цикл, в котором яблоки берутся из корзины до тех пор,
//// пока они там есть. Последнее сообщение: "Яблоки кончились!".
public class CycleApples {
    public static void main(String[] args) {
        int aplles = 30;// исходные данные
        int count = 0; //паоаметр цикла
        int startAplles = 30;

        while (count < 30){
            System.out.println("Take one apple.");
            aplles = aplles - 1;
            count = count + 1;
            System.out.println("Now we have only " + aplles + " aplles in the bascet");
        }//end of while
        System.out.println("The job is done ! " + count + " aplles was added in to the pie." );
    }//end main
}//end of class
