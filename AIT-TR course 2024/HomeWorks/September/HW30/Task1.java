package HW30;
public class Task1 {

    public static void main(String[] args) {
    //Задача 1. Дана строка "I'm proud to learn Java! Java is the most famous programming language!!!" Выполнить практикум с этой строкой:

        String str = "I'm proud to learn Java! Java is the most famous programming language!!!";

        //Распечатать последний символ строки.
        char ch = str.charAt(str.length() - 1);
        System.out.println("The last symbol in line is: " + ch);
        System.out.println("------------1------------");

        //Проверить, содержит ли заданная строка подстроку “Java”.
        //Найти позицию подстроки “Java” в строке.
        String withoutUseless = str.replace("!", " "); //заменяю ненужные символы на пробелы
        System.out.println(withoutUseless);
        System.out.println("----------2---------------");

        String words[] = withoutUseless.split(" "); // все что между разделитем "пробел" кладу в массив
        int w = words.length; // длина массива
        System.out.println(w);
        System.out.println("-----------------3--------------");
        int count = 0;
        boolean check = false;

        for (int i = 0; i < words.length; i++) { //узнаем есть ли в массиве слово Java, и сколько раз встретили
            if (words[i].equals("Java")) {
                count++;
                check = true;
            }//end if
        }///end for
        System.out.println("We have word Java in our array, it's " + check);
        System.out.println("We have found word Java in our array " + count + " times.");
        String checker = "Java";
        int arrayWithIndexes[] = new int[count];
        for (int i = 0, j = 0; i < words.length; i++) { //находим индексы слова Java в массиве и заносим их в другой массив
            if (words[i].equals(checker)) {
                arrayWithIndexes [j] = i;
                j++;
            }//end if
        }//end for
        System.out.println();
        int firstIndex = arrayWithIndexes[0]; //переносим значения елементов массива с индексами Java в переменные
        int secondIndex = arrayWithIndexes[1];
        System.out.println("Word Java we found in positions " + firstIndex + " and " + secondIndex + ".");
        System.out.println("---------------4-----------------");

        //Заменить все символы “o” на “a”.
        String withoutO = str.replace("o", "a");
        System.out.println(withoutO);
        System.out.println("----------5---------------");

        //Преобразуйте строку к верхнему регистру.
        System.out.println(str.toUpperCase());
        //Преобразуйте строку к нижнему регистру.
        System.out.println(str.toLowerCase());
        System.out.println("----------6-----------");

        //Вырезать подстроку Java c помощью метода substring().
        System.out.println(str.substring(49));
        System.out.println("-------------7-------------");

        //Проверить, заканчивается ли строка подстрокой “!!!”.
        System.out.println(str);
        String lookingWord1 = "!!!";
       int index1 = str.lastIndexOf(lookingWord1);
        boolean checkWord1 = false;
        System.out.println(index1);
        if (index1 >= 0) {
            checkWord1 = true;
        }//end if
        //Проверить, начинается ли строка подстрокой “I'm proud”.
        String lookingWord2 = "I'm proud";
        int index2 = str.indexOf(lookingWord2);
        boolean checkWord2 = false;
        System.out.println(index2);
        if (index2 >= 0) {
            checkWord2 = true;
        }//end if
        System.out.println("Our sentence start with -> I'm proud <--, it's " + checkWord2 + ". And ends with -> !!! <-, it's " + checkWord1 + ".");
    }//end main
}//end class
