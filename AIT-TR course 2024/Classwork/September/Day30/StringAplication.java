package Day30;

public class StringAplication {
    public static void main(String[] args) {

        String str1 = "Hello,";

        char[] chars = {32, 'W', 'o', 'r', 'l', 'd', '!'}; // 32 - код пробела по таблицу ASCII

         String str2 = new String(chars); // str2 - это обьект класса String, сделаннй конструктором (конструктор - это метод)
                                          // new - это обращение к конструктору

        System.out.println(str1); // Hello,
        System.out.println(str2); //  World!

        //concatination (concat) - обьединяем (складываем) обьекты типа String
        String str = str1 + str2;
        System.out.println(str);

        System.out.println(str1.concat(str2)); // конкатенация с помощью метода concat
        System.out.println(str1); // str1 не изменился т.к. тип String является immutable (неизменяемым)
        String strNew = str1.concat(str2); // так можно сохранить результат метода concat

        //lenght of String
        int l = str.length(); // определяем длину строки str - cчитает все символы включая пробелы
        System.out.println(l);

        // first symbol
        char ch = str.charAt(0);
        System.out.println("First symbol is: " + ch); // H// first symbol
        // last symbol
        ch = str.charAt(str.length()-1); //получаем последний символ в строке str
        System.out.println("Last symbol is: " + ch); // !

        //print with spaces
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();

        //check equals проверить равенство строк

        String str3 = " worLD!"; // сравниваем
        boolean checker = str3.equals(str2); // str2 = " World!"
        System.out.println(checker); //false
        checker = str3.equalsIgnoreCase(str2); // str2 = " World!"
        //IgnoreCase игнорирует только регистр, ко-во символов в строках и расположение елементов должно быть одинаковым, чтоб получить true
        System.out.println(checker); //true
        System.out.println("------------------");


        //изменение значения переменной типа String  //// ПОКА НЕ РАБОТАЕТ, Я ЧТО ТО НЕПРАВИЛЬНО СДЕЛАЛ
         String strnew = str1 + " Vova"; // изменяем значение str1
         System.out.println(str1);
        System.out.println("--------------------");

         //symbol in position находит идекс искомого элемента
        System.out.println(str);  // str = Hello, World! индексы начинаются с нуля, считает все символы включая пробел
        int index = str.indexOf('W'); // ведем поиск слева направо
        System.out.println(index); //7 находит позицию символа в строке
        int index1 = str.lastIndexOf('d'); // ведем поиск справа налево? - да, индекс присваивает по счету слева направо
        System.out.println(index1);
        index = str.indexOf('o');
        index1 = str.lastIndexOf('o');
        System.out.println(index + ", " + index1);
        index = str.indexOf('x');
        System.out.println(index);

        System.out.println("--------substring---------"); //выделить
        System.out.println(str.substring(7)); // диапазон с 7 индекса до конца строки
        System.out.println(str.substring(7, 10)); // диапазон с 7 по 10 индекс

        System.out.println("--------replace---------"); //заменить
        System.out.println(str.replace("o","o-o-o"));

        System.out.println("--------split---------"); //разделить строку на подстроки, который будут упакованы в массив
        String str4 = "I love, string in Java."; //если перед I будет пробел " I love string in Java" то сплит посчитает - 6 символов в строке
        String [] words = str4.split(" "); // все что между разделителем - отправляет в массив words
        int w = words.length;                      //все, что находиться после последнего разделителя и до конца строки - будет последним елементом массива
        System.out.println("Numbers of words in sentence: " + w + ".");


        //number of letters
        String [] letters = str4.split(""); // если разделитель "" - то в массив отправляються посимвольно
        int let = letters.length;
        System.out.println("Numbers of letters in sentence: " + let + ".");

        System.out.println("--------String.format---------"); //
        //Вставьте в строку дату полета Гагарина в виде:
        //"Дата полета Гагарина в космос: число – месяц – год." и напечатайте ее в консоли.
        //Используйте String.format()
        int day = 12;
        String month = "April";
        int year = 1961;
        String gagarinDay = String.format("Дата полета Гагарина в космос: %d - %s - %d.", day, month ,year);
        System.out.println(gagarinDay); // Дата полета Гагарина в космос: 12 - April - 1961.

    }//end main
}//end class
