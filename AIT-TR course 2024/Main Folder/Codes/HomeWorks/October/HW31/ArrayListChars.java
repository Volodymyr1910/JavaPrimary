package HW31;

import java.util.ArrayList;

//Задача 3.(*) Заполните структуру типа ArrayList<> символами латинского алфавита от A(65) до Z(...).
public class ArrayListChars {
    public static void main(String[] args) {

        ArrayList<Character> s = new ArrayList<Character>(26);

        for (int i = 0; i < 26; i++) {
            s.add(i, (char) (65 + i));
        }
        System.out.println(s);

    }//end main

}//end class
