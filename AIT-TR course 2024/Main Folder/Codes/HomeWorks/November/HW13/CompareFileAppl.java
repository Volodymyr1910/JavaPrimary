package HW13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Задание 1. В классе CompareFileAppl реализовать логику сравнения двух файлов в методе main. Имена файлов принимать через массив args. Два файла считаем одинаковыми, если у них одинаковая длина, и на тех же позициях стоят те же байты. Результат должен быть выведен на консоль в виде сообщения.
public class CompareFileAppl {

    public static void main(String[] args) {

        // если ко-во сравниваемых файлов не 2 - стоп программа
        if (args.length != 2) {System.out.println("Two participants are needed for comparison !"); return;}

        // достаем содержимое файлов в переменные, проверяем совпадение размера, если не равен - меседж и стоп программа
        try (FileInputStream fin1 = new FileInputStream(args[0]);
            FileInputStream fin2 = new FileInputStream(args[1])){
            if (fin1.available() != fin2.available()) System.out.println("Files " + args[0] + " and " + args[1] + " aren't equil.");
            else System.out.println("Files " + args[0] + " and " + args[1] + " are equil -> " + comparingFiles(fin1, fin2)); // если размер файлов одинаковый, делаем побитовую проверку
        } catch (IOException e) {throw new RuntimeException(e);}

    }//end main

    private static boolean comparingFiles(FileInputStream fin1, FileInputStream fin2) {
        try { return Arrays.equals(fin1.readAllBytes(),fin2.readAllBytes()); //метод .readAllBytes() "высыпает" все биты в массив, а метод .equals сравнивает элементы
        } catch (IOException e) {  throw new RuntimeException(e);  }
    }//end comparingFiles

}//end class
