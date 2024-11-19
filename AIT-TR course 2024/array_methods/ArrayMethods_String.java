package array_methods;

import java.util.Arrays;


//// ------------------------------------- Searching in array  ----------------------------------------------


//// ------------------------------------- Sorting array ----------------------------------------------------


//// ------------------------------------- Copy or transfer array with CHANGING ARRAY -----------------------

public class ArrayMethods_String {
    //разворачивает символы каждого елемента массива в обратном порядке и формирует новый массив, елементы остаются на родных индексах
    // arrayFrom {abcd, fghj, klöä} -> arrayTo {dcba, jhgf, äölk}
    public static String[] reverseArrayString(String[] array) {
        return new String[]{new StringBuilder(Arrays.toString(array)).reverse().toString()};
    }//end reverseArrayString

    // метод що розвертає дані в масиві типу String навпаки int[a,b,c] -> int[c,b,a]
    // если размер arrayFrom больше - будет error
    //если размер arrayTo больше -  в нем останутся пустые ячейки или ячейки с его "родными" елементами
    public static String[] transferFromOneArrayToAnotherWithTurnAroundString(String[] arrayFrom, String[] arrayTo) {
        int u = 0;
        for (int t = arrayFrom.length - 1; t >= 0; t--) {
            arrayTo[u] = arrayFrom[t];
            u++;
        }//end for
        //System.out.println();
        return arrayTo;
    }//end transferFromOneArrayToAnotherWithTurnAroundString

    //переносить в новий масив з масиву-донора тільки букви
    // працює ТІЛЬКИ з ПОСИМВОЛЬНИМИ масивами (елемент массиву - не слово, а 1 символ)
    //розмір нового масиву  =  кількості букв в  масиві-донорі
    public static String[] tranferToNewArrayOnlyLettersAutoSize(String[] array) {
        String[] temp = new String[howMuchLettersInArray(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                temp[j] = array[i];
                j++;
            }//end if
        }//end for
        return temp;
    }// end tranferToNewArrayOnlyLettersAutoSize

    //переносить в новий масив з масиву-донора тільки цифри
    // працює ТІЛЬКИ з ПОСИМВОЛЬНИМИ масивами (елемент массиву - не слово, а 1 символ)
    //розмір нового масиву  =  кількості цифр в масиві-донорі
    public static String[] tranferToNewArrayOnlyDigitsAutoSize(String[] array) {
        String[] temp = new String[howMuchDigitsInArray(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                temp[j] = array[i];
                j++;
            }//end if
        }//end for
        return temp;
    }// end tranferToNewArrayOnlyDigitsAutoSize

    // рахує скільки в масиві букв
    // працює ТІЛЬКИ з ПОСИМВОЛЬНИМИ масивами (елемент массиву - не слово, а 1 символ)
    public static int howMuchLettersInArray(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                count++;
            }//end if
        }//end for
        return count;
    }//end  howMuchLettersInArray

    // рахує скільки в масиві цифр
    // працює ТІЛЬКИ з ПОСИМВОЛЬНИМИ масивами (елемент массиву - не слово, а 1 символ)
    public static int howMuchDigitsInArray(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                count++;
            }//end if
        }//end for
        return count;
    }//end  howMuchDigitsInArray

//// ------------------------------------- Copy or transfer array -------------------------------------------


    //// ------------------------------------- Other operations with array  -------------------------------------


//// ------------------------------------- Total and Average of array  --------------------------------------

    // повертає сумму кодів за таблицею ASCII всіх елементів массиву
    // массив має бути посимвольним з типом String.
    public static double sumArrayByASCII (String[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
                sum = sum + array[i].charAt(0);
        }//end for
        return sum;
    }//end sumArrayByASCII

//// ------------------------------------- Print array ------------------------------------------------------
// String [] array = {"saf", "qwe", "jhgjhg"};
// System.out.println(Arrays.toString(array)); // метод toString распечатыывает массивы, но результат не возвращает

    //print String[] array
    public static void printArrayString(String[] array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            n++;
            if (n < array.length) {
                System.out.print("; ");
            }//end if
        }//end for
        System.out.println();
        System.out.println("------------------------------");
    }//end printArrayString


//// ------------------------------------- Fill array -------------------------------------------------------


}//end class

