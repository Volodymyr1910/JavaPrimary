package Day23;
//Создайте массив и заполните его символами латинского алфавита от A до Z.
//Раcпечатайте полученный массив.
public class Alfabet {

    public static void main(String[] args) {

        char [] alphabet = new char[26];

        for (int i = 0; i < alphabet.length; i++) {

            alphabet[i] = (char) (65 + i); // 65 это цифровой код буквы а по таблицу
            System.out.print(alphabet[i] + ", ");
        }//end for


    }//end main
}//end class
