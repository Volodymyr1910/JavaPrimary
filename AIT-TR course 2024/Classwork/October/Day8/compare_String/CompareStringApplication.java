package Day8.compare_String;

//равенство строк  - как понять?

public class CompareStringApplication {
    public static void main(String[] args) {

        System.out.println("------сравнение int------");
        int x = 5; // стек
        int y = 5; // стек
        boolean checker = (x == y);
        System.out.println(checker); //true

        System.out.println("------сравнение String------");
        String  str1 = "Europe"; // str1 - stack =>(link) Europe - heap
        String  str2 = "Europe"; // str2 - stack =>(link) Europe - heap
        checker = (str1 == str2); // сравнение ссылок на обьекты типа String
        System.out.println(checker); //true

        System.out.println("------сравнение String 2------");
        String str3 = new String("Europe"); // создали новый обьект create new object with new link
        checker = (str1 == str3);
        System.out.println(checker); // false, because links NOT equal !

        System.out.println("------сравнение String with method equals------");
        //метод учитывает что ссылки могут быть разными(игнорирует ссылки, проверяет значения), а значения обьектов  - одинаковые
        checker = str1.equals(str3);
        System.out.println(checker);


    }//end main
}//end class
