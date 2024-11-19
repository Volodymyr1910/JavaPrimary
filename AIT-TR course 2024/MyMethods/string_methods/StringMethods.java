package MyMethods.string_methods;

import array_methods.ArrayMethods_String;

public class StringMethods {


    //отримує на вхід будь-яку строку
    //повертає сумму з типом long всіх цифр у вхідній строчці;
    public static long totalOfDigitsInString (String str) {
        String sentenceInArray[] = str.split("");
        String sentenceWithOnlyDigits[] = ArrayMethods_String.tranferToNewArrayOnlyDigitsAutoSize(sentenceInArray);
        long sum = 0;
        for (int i = 0; i < sentenceWithOnlyDigits.length; i++) {
            sum += Integer.parseInt(sentenceWithOnlyDigits[i]);
        }//end for
        return sum;
    }//end totalOfDigitsInString

    // make copy elements from one STRING ARRAY to another INT ARRAY
    // розмір нового масиву такий самий як розмір масиву-донора
    public static int [] copyArrayWithChangeStringToIntAutoSize (String[] arrayFrom) {
        int u = 0;
        int arrayTo[] = new int[arrayFrom.length];
        for (int i = 0; i < arrayFrom.length; i++) {
            arrayTo[u] = Integer.parseInt(String.valueOf(arrayFrom[i]));
            u++;
        }// end copyArrayWithChangeStringToIntAutoSize
        return arrayTo;
    }//copyArrayWithChangeStringToIntAutoSize


    // рахує скільки в строчці цифр
    public static int howMuchDigitsInString (String str) {
        int count = 0;
        int n = 1;
        while (n <= str.length()){
            if (Character.isDigit(str.charAt(n-1))) {
                count++;
            }//end if
            n++;
        }//end while
        return count;
    }//end  howMuchDigitsInString

    // рахує скільки в строчці букв верхнього регістру
    public static int howMuchUpperCaseLettersInString (String str) {
        int count = 0;
        int n = 1;
        while (n <= str.length()){
            String temp = String.valueOf(str.charAt(n-1));
            String temp1 = temp.toUpperCase();
            if (Character.isLetter(str.charAt(n-1))) {
                if(temp1.equals(String.valueOf((str.charAt(n-1))))){
                    count++;
                }//end if
            }//end if
            n++;
        }//end while
        return count;
    }//end  howMuchUpperCaseLettersInString


    // рахує скільки в строчці букв
    public static int howMuchLettersInString (String str) {
        int count = 0;
        int n = 1;
        while (n <= str.length()){
            if (Character.isLetter(str.charAt(n-1))) {
                count++;
            }//end if
            n++;
        }//end while
        return count;
    }//end  howMuchLettersInString

    //рахує скільки в строчці є шукомих символів
    public static int howMuchSelectedElementsInString (String str, String x) {
        int count = 0;
        int n = 1;
        while (n <= str.length()){
            if (x.equals(String.valueOf((str.charAt(n-1))))) {
                count++;
            }//end if
            n++;
        }//end while
        return count;
    }//end  howMuchSelectedElementsInString


}//end class
